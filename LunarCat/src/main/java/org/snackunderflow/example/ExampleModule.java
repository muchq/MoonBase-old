package org.snackunderflow.example;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import org.skife.jdbi.v2.DBI;
import org.snackunderflow.mentat.MentatModule;

public class ExampleModule extends AbstractModule {
  private static final String EXAMPLE_DATABASE_NAME = "bonky";

  @Override
  protected void configure() {
    install(new MentatModule(EXAMPLE_DATABASE_NAME));
    bind(String.class).annotatedWith(Names.named("zamboni")).toInstance("Wonk!");
  }

  @Provides
  @Singleton
  public ExampleDao getExampleDao(DBI dbi) {
    return dbi.onDemand(ExampleDao.class);
  }
}
