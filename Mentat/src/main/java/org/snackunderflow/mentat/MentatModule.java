package org.snackunderflow.mentat;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class MentatModule extends AbstractModule {
  @Override
  protected void configure() {
  }

  @Provides
  @Singleton
  public DBI getDbi(MySqlConfiguration configuration) {
    DataSource dataSource = new MentatDataSourceProvider(configuration).get();
    return new DBI(dataSource);
  }
}
