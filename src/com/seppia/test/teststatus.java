package com.seppia.test;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/status")
public class teststatus {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Service</p>";
	}
	
}
