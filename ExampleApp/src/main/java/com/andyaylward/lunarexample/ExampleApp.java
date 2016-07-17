package com.andyaylward.lunarexample;

import com.andyaylward.lunarexample.config.ExampleModule;
import org.snackunderflow.BaseService;
import org.snackunderflow.config.Configuration;

public class ExampleApp {
  public static void main(String[] args) {
    Configuration configuration = Configuration.newBuilder()
        .withBasePackage(ExampleApp.class.getPackage())
        .withModules(new ExampleModule())
        .build();
    new BaseService(configuration).run();
  }
}
