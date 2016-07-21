package org.snackunderflow.lunarcat.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Optional;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class OptionalMessageBodyWriter implements MessageBodyWriter<Optional<?>> {
  private final ObjectMapper mapper;

  @Inject
  public OptionalMessageBodyWriter(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public long getSize(Optional<?> entity, Class<?> type, Type genericType,
                      Annotation[] annotations, MediaType mediaType) {
    return 0;
  }

  @Override
  public boolean isWriteable(Class<?> type, Type genericType,
                             Annotation[] annotations, MediaType mediaType) {
    return (Optional.class.isAssignableFrom(type));
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public void writeTo(Optional<?> entity,
                      Class<?> type,
                      Type genericType,
                      Annotation[] annotations,
                      MediaType mediaType,
                      MultivaluedMap<String, Object> httpHeaders,
                      OutputStream entityStream)
      throws IOException {
    if (!entity.isPresent()) {
      throw new NotFoundException();
    }

    entityStream.write(mapper.writeValueAsBytes(entity.get()));
  }
}
