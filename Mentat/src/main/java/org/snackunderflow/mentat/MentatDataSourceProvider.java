package org.snackunderflow.mentat;

import com.google.inject.Provider;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class MentatDataSourceProvider implements Provider<DataSource> {
  private final MySqlConfiguration mySqlConfiguration;

  public MentatDataSourceProvider(MySqlConfiguration mySqlConfiguration) {
    this.mySqlConfiguration = mySqlConfiguration;
  }

  @Override
  public DataSource get() {
    HikariConfig config = new HikariConfig("/hikari.properties");
    config.setUsername(mySqlConfiguration.getUsername());
    config.setPassword(mySqlConfiguration.getPassword());
    config.addDataSourceProperty("databaseName", mySqlConfiguration.getDb());
    config.addDataSourceProperty("serverName", mySqlConfiguration.getHost());

    return new HikariDataSource(config);
  }
}
