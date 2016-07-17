package org.snackunderflow;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.snackunderflow.config.Configuration;
import org.snackunderflow.config.LunarCatServiceModule;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import java.util.EventListener;
import java.util.Optional;
import java.util.Set;

public class BaseService {
  private static final String DEFAULT_CONTEXT_PATH = "/";
  private static final String DEFAULT_SERVLET_PATH_SPEC = "/*";

  private final Server server;
  private final Injector injector;

  public BaseService(Configuration configuration) {
    this.injector = createInjector(configuration);
    EventListener guiceListener = injector.getInstance(GuiceResteasyBootstrapServletContextListener.class);
    this.server = newServer(configuration, guiceListener);
  }

  public void run() {
    try {
      server.start();
      server.join();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Injector createInjector(Configuration configuration) {
    Set<Module> modules = configuration.getModules();
    modules.add(new LunarCatServiceModule(configuration.getBasePackage().getName()));
    Injector injector = Guice.createInjector(modules);
    injector.getAllBindings();
    injector.createChildInjector().getAllBindings();
    return injector;
  }

  private Server newServer(Configuration configuration, EventListener listener) {
    Server server = new Server(configuration.getPort());
    server.setHandler(servletHandler(configuration.getContextPath(), listener));
    return server;
  }

  private Handler servletHandler(Optional<String> contextPathMaybe, EventListener listener) {
    ServletContextHandler servletHandler = new ServletContextHandler();
    servletHandler.addEventListener(listener);

    ServletHolder sh = new ServletHolder(HttpServletDispatcher.class);
    servletHandler.addServlet(sh, DEFAULT_SERVLET_PATH_SPEC);
    servletHandler.setContextPath(contextPathMaybe.orElse(DEFAULT_CONTEXT_PATH));
    return servletHandler;
  }
}
