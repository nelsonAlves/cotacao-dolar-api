package com.coopersystem.desafio.exception;

import org.apache.catalina.connector.Response;
import org.hibernate.exception.ConstraintViolationException;

public class ValidationExceptionMapper {

	  public Response toResponse(ConstraintViolationException ex) {
	    
		  return null;
	  }
}
