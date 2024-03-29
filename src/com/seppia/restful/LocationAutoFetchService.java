package com.seppia.restful;

import java.util.ArrayList;
import java.util.Collection;

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
import com.seppia.model.*;
import com.seppia.action.*;

@Path("/fetch")
public class LocationAutoFetchService {
	@GET
	@Path("/fetchLocationsByZipcode")
	@Produces("application/json")
	public String fetchLocationsByZipCode(@QueryParam("zipcode") String zipcode, @QueryParam("country") String country, @QueryParam("sportID") int sportID){
		String locations = "";
		String tag = "/fetch/fetchLocationsByLocation";
		//TODO: 1) validate result, 2)parse and send single result to model factory
		
		//loop through the zipcode, contry and sportID in python script
		if(zipcode == null){
			zipcode = "95051";
			country = "USA";
			sportID = 1;
		}
		
		//should have Stype fetched in Action and returned as a HashMap
		try {
			STypeAction typeAction = new STypeAction();
			LocationFetcher fetcher = new LocationFetcher();
			String sportName = typeAction.getSTypeById(sportID);
			String query = Utility.constructAutoSearchQuery(sportName, zipcode, country);
			//String search = Utility.constructSearchURL(Constants.textSearchBaseURL ,query);
			ArrayList<Location> locationData = fetcher.fetchLocationsByQuery(query);
			if(locationData != null){
				// call save data action here
				return "";
			}
			else{
				return "";
			}
			
		} catch (Exception e) {
			// TODO return error message
			e.printStackTrace();
			return "";
		}
		
		
		
	}
	
	@GET
	@Path("/fetchLocationsByZipcodeUSA")
	@Produces("application/json")
	public String fetchLocationsByZipCode(@QueryParam("zipcode") String zipcode, @QueryParam("sportID") int sportID){
		//default zipcode
		return "";
	}
	
	@GET
	@Path("/fetchLocationsByCity")
	@Produces("application/json")
	public String fetchLocationsByCity(@QueryParam("city") String city, @QueryParam("country") String country, @QueryParam("sportID") int sportID){
		return "";
	}
	
	@GET
	@Path("/fetchLocationsByLocation")
	@Produces("application/json")
	public String fetchLocationsByLocation(@QueryParam("lat") double lat, @QueryParam("lng") double lng, @QueryParam("radius") double radius, @QueryParam("keyword") String keyword ){
		String locations = "";
		String tag = "/fetch/fetchLocationsByLocation";
		
		if(lat == 0){
			lat = 37.3594951;
			lng = -121.9984934;
			radius = 5000.0;
			keyword = "sports";
		}
		
		try {
			LocationFetcher fetcher = new LocationFetcher();
			//String query = Utility.contructNearbySearchQuery(lat, lng, radius, keyword);
			//String search = Utility.constructSearchURL(Constants.nearbySearchBaseURL, query);
			ArrayList<Location>  locationData= fetcher.fetchLocationsByGeometry(new Geometry(lat, lng), (int)radius, keyword);
			
			locations = Utility.constructGSON(tag, true, locationData);
			
			//
			return locations;
			
		} catch (Exception e) {
			// TODO return error message
			e.printStackTrace();
			return "";
		}
	}
}
