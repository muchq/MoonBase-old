package com.andyaylward.lunarexample.data;

import com.hubspot.rosetta.annotations.RosettaProperty;
import org.immutables.value.Value.Immutable;
import org.snackunderflow.moonbase.core.MoonStyle;

@Immutable
@MoonStyle
public interface ExampleRecordIF {
  @RosettaProperty("id")
  int getId();
  @RosettaProperty("name")
  String getName();
}
