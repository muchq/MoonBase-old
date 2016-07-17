package com.andyaylward.lunarexample.data;

import com.google.inject.Provides;
import org.skife.jdbi.v2.DBI;
import org.snackunderflow.mentat.MentatModule;
import org.snackunderflow.mentat.MySqlConfiguration;
import org.snackunderflow.moonbase.core.BaseGuiceModule;

public class ExampleDataModule extends BaseGuiceModule {
  @Override
  protected void configure() {
    install(new MentatModule());
  }

  @Provides
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
