package org.snackunderflow.mentat;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class MentatModule extends AbstractModule {
  private final String databaseName;

  public MentatModule(String databaseName) {
    this.databaseName = databaseName;
  }

  @Override
  protected void configure() {
  }

  @Provides
  @Singleton
  public DBI getDbi() {
    DataSource dataSource = new MentatDataSourceProvider(databaseName).get();
    return new DBI(dataSource);
  }
}
