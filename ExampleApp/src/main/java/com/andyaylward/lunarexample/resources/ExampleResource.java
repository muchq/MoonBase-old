package com.andyaylward.lunarexample.resources;

import com.andyaylward.lunarexample.data.ExampleDao;
import com.andyaylward.lunarexample.data.ExampleRecord;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
  private final String greeting;
  private final ExampleDao dao;

  @Inject
  public ExampleResource(@Named("zamboni") String greeting, ExampleDao dao) {
    this.greeting = greeting;
    this.dao = dao;
  }

  @GET
  public Map<String, String> sayHi() {
    Map<String, String> output = new HashMap<>();
    output.put("yo", greeting);
    return output;
  }

  @GET
  @Path("{id}")
  public Optional<ExampleRecord> sayHello(@PathParam("id") int id) {
    Optional<ExampleRecord> recordMaybe = dao.getRecordById(id);
    return recordMaybe;
  }
}
