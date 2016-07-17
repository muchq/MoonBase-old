package org.snackunderflow.config;

import com.google.common.collect.Sets;
import com.google.inject.AbstractModule;
import org.jboss.resteasy.plugins.guice.ext.RequestScopeModule;
import org.reflections.Reflections;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.Set;

public class RestEasyGuiceModule extends AbstractModule {
  private final Set<String> packagesToScan = Sets.newHashSet("org.snackunderflow");

  public RestEasyGuiceModule(String basePackage) {
    this.packagesToScan.add(basePackage);
  }

  @Override
  protected void configure() {
    install(new RequestScopeModule());
    packagesToScan.forEach(this::bindPathsAndProviders);
  }

  private void bindPathsAndProviders(String packageName) {
    Reflections reflections = new Reflections(packageName);
    reflections.getTypesAnnotatedWith(Path.class).forEach(this::bind);
    reflections.getTypesAnnotatedWith(Provider.class).forEach(this::bind);
  }
}
