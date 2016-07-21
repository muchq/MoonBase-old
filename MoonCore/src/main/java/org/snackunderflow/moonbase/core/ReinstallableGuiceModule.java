package org.snackunderflow.moonbase.core;

import com.google.inject.AbstractModule;

public abstract class ReinstallableGuiceModule extends AbstractModule {
  public boolean equals(Object o) {
    return o != null && this.getClass().equals(o.getClass());
  }

  public int hashCode() {
    return this.getClass().hashCode();
  }
}
