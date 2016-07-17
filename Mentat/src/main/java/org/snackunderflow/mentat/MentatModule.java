package org.snackunderflow.mentat;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.skife.jdbi.v2.DBI;
import org.snackunderflow.moonbase.core.BaseGuiceModule;

public class MentatModule extends BaseGuiceModule {
  @Override
  protected void configure() {
  }

  @Provides
  @Singleton
  public DBI getDbi(MySqlConfiguration configuration) {
    HikariConfig config = new HikariConfig("/hikari.properties");
    config.setUsername(configuration.getUsername());
    config.setPassword(configuration.getPassword());
    config.addDataSourceProperty("databaseName", configuration.getDb());
    config.addDataSourceProperty("serverName", configuration.getHost());

    DBI dbi = new DBI(new HikariDataSource(config));
    dbi.registerMapper(new RosettaMapperFactory());
    dbi.registerContainerFactory(new OptionalContainerFactory());
    return dbi;
  }
}
