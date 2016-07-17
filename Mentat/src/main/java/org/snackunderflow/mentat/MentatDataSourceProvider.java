package org.snackunderflow.mentat;

import com.google.inject.Provider;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class MentatDataSourceProvider implements Provider<DataSource> {
  private final String databaseName;

  public MentatDataSourceProvider(String databaseName) {
    this.databaseName = databaseName;
  }

  @Override
  public DataSource get() {
    HikariConfig config = new HikariConfig("/hikari.properties");
    config.setUsername("root");
    config.setPassword("");
    config.addDataSourceProperty("databaseName", databaseName);

    return new HikariDataSource(config);
  }
}
