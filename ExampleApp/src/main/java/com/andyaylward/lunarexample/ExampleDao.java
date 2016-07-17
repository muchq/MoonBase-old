package com.andyaylward.lunarexample;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface ExampleDao {
  @GetGeneratedKeys
  @SqlUpdate("INSERT INTO something (name) VALUES (:name)")
  int insert(@Bind("name") String name);

  @SqlQuery("SELECT name FROM something WHERE id=:id")
  String getNameById(@Bind("id") int id);
}
