package org.example.apis.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException>{

    @Override
    public Response toResponse(ResourceNotFoundException arg0) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(arg0.getMessage());
        errorMessage.setErrorCode(404);
        errorMessage.setErrorDescription("ID NOT FOUND");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
    
}
