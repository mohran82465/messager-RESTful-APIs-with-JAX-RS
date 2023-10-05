package com.mohran.brains.messenger.exception;

import com.mohran.brains.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

public class GenericExceptionMapper{

//	@Override
//	public Response toResponse(Throwable exception) {
//		// TODO Auto-generated method stub
//		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),500,"http://fb.com");
//		return Response.status(Status.INTERNAL_SERVER_ERROR)
//					   .entity(errorMessage)
//					   .build();
//	}
 
}
