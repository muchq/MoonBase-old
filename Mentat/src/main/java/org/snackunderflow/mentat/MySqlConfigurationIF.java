package org.snackunderflow.mentat;

import org.immutables.value.Value.Immutable;
import org.snackunderflow.moonbase.core.MoonStyle;

@Immutable
@MoonStyle
public interface MySqlConfigurationIF {
  String getUsername();
  String getPassword();
  String getHost();
  String getDb();
}
