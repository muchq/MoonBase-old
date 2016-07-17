package org.snackunderflow.example;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
  private final String greeting;

  @Inject
  public HelloResource(@Named("zamboni") String greeting) {
    this.greeting = greeting;
  }

  @GET
  public Map<String, String> sayHello() {
    Map<String, String> output = new HashMap<>();
    output.put("yo", greeting);
    return output;
  }
}
