package com.mohran.brains.messenger.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InjectDemoResource {
	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
										   @HeaderParam("customHeaderValue") String header,
										   @CookieParam("name") String cookie)
	{
		return "Matrix Param:  "+matrixParam + "   Header Param : "+ header 
				  ;
	}
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders headers)
	{
		
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString(); 
		return "Path : " +  path + "  Cookies : "+cookies; 
	}
	
}
