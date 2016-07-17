package org.snackunderflow.example;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ExampleModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(String.class).annotatedWith(Names.named("zamboni")).toInstance("Wonk!");
  }
}
