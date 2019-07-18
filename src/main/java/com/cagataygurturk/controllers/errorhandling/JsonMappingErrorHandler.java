package com.cagataygurturk.controllers.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonProcessingException;

@Provider
public class JsonMappingErrorHandler extends AbstractBaseErrorMapper implements ExceptionMapper<JsonProcessingException> {

    @Override
    protected int getStatusCode() {
        return 400;
    }

    public Response toResponse(JsonProcessingException ex) {
        return Response.status(getStatusCode()).
                entity(new Error("Request is malformed")).
                type("application/json").
                build();
    }
}