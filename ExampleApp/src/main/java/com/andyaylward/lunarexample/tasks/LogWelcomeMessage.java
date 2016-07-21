package com.andyaylward.lunarexample.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snackunderflow.lunarcat.lifecycle.StartupTask;

public class LogWelcomeMessage implements StartupTask {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogWelcomeMessage.class);

  @Override
  public void execute() {
    LOGGER.info("Woo! We're starting up!");
  }
}
