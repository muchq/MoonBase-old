package org.snackunderflow.mentat;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.skife.jdbi.v2.DBI;

public class MentatModule extends AbstractModule {
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

    return new DBI(new HikariDataSource(config));
  }
}
