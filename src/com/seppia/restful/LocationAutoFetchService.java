package com.seppia.restful;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.*;
import com.google.maps.*;
import com.seppia.util.Utility;

@Path("/autoFetch")
public class LocationAutoFetchService {
	@GET
	@Path("/fetchLocationsByZipcode")
	@Produces("application/json")
	public String fetchLocationsByZipCode(@QueryParam("zipcode") String zipcode, @QueryParam("country") String country, @QueryParam("sportID") int sportsID){
		//TODO: 1) validate result, 2)parse and send single result to model factory
		return "";
	}
	
	@GET
	@Path("/fetchLocationsByZipcodeUSA")
	@Produces("application/json")
	public String fetchLocationsByZipCode(@QueryParam("zipcode") String zipcode, @QueryParam("sportID") int sportsID){
		//default zipcode
		return "";
	}
	
}
