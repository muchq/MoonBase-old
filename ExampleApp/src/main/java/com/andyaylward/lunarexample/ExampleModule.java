package com.andyaylward.lunarexample;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import org.skife.jdbi.v2.DBI;
import org.snackunderflow.mentat.MentatModule;
import org.snackunderflow.mentat.MySqlConfiguration;

public class ExampleModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new MentatModule());
    bind(String.class).annotatedWith(Names.named("zamboni")).toInstance("Wonk!");
  }

  @Provides
  @Singleton
  public ExampleDao getExampleDao(DBI dbi) {
    return dbi.onDemand(ExampleDao.class);
  }

  @Provides
  public MySqlConfiguration getMySqlConfiguration() {
    return MySqlConfiguration.builder()
        .setUsername("root")
        .setPassword("")
        .setHost("localhost")
        .setDb("bonky")
        .build();
  }
}
