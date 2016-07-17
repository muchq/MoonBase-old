package com.andyaylward.lunarexample.data;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import java.util.Optional;

public interface ExampleDao {
  @GetGeneratedKeys
  @SqlUpdate("INSERT INTO something (name) VALUES (:name)")
  int insert(@Bind("name") String name);

  @SingleValueResult
  @SqlQuery("SELECT id, name FROM something WHERE id=:id")
  Optional<ExampleRecord> getRecordById(@Bind("id") int id);
}
