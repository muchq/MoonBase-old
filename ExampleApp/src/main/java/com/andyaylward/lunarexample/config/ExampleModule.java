package com.andyaylward.lunarexample.config;

import com.andyaylward.lunarexample.data.ExampleDataModule;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ExampleModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new ExampleDataModule());
    bind(String.class).annotatedWith(Names.named("zamboni")).toInstance("Wonk!");
  }
}
