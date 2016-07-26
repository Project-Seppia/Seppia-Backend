package com.seppia.restful;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.util.*;

import com.google.gson.*;
import com.google.maps.*;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.seppia.dao.Constants;
import com.seppia.util.Utility;
import com.seppia.dao.*;

@Path("/autoFetch")
public class LocationAutoFetchService {
	@GET
	@Path("/fetchLocationsByZipcode")
	@Produces("application/json")
	public String fetchLocationsByZipCode(@QueryParam("zipcode") String zipcode, @QueryParam("country") String country, @QueryParam("sportID") int sportsID){
		//TODO: 1) validate result, 2)parse and send single result to model factory
		GeoApiContext context = new GeoApiContext().setApiKey(Constants.mapAPIKey);
		if(zipcode == null){
			zipcode = "95051";
			country = "USA";
		}
		//HashMap sportMap = STypeDB.
		//String sportName = 
		String query = Utility.constructSearchQuery("sports club", zipcode, country);
		TextSearchRequest request =  PlacesApi.textSearchQuery(context, query);
		try{
			PlacesSearchResponse response = request.await();
			PlacesSearchResult[] results = response.results;
			//loop through to get results.
		} catch (Exception e){
			
		}
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
