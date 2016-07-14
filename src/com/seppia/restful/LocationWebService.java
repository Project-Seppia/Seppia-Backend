package com.seppia.restful;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.*;

@Path("/location")
public class LocationWebService {
	
	@GET
	@Path("/getLocations")
	@Produces("application/json")
	public String getNearbyLocations(@QueryParam("address") String address){
		String locations = "";
		try
		{
			ArrayList<Location> locationData = new ArrayList<Location>();
			LocationController lc = new LocationController();
			locationData = lc.getNearbyLocationsByAddress(address);
			//serialization should be added in to utility.java
			Gson gson = new Gson();
			JsonElement je = (JsonObject) gson.toJsonTree(locationData);	
			System.out.println(je.toString());
			JsonObject jo = new JsonObject();
			jo.add("result", je);
			jo.addProperty("tag", "/location/getLocations");
			jo.addProperty("status", true);
			System.out.println(jo.toString());
			locations = gson.toJson(jo);
			
			return locations;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			//delete error
			return e.getMessage();
		}
	}
	
	@POST
	@Path("/addLocation")
	@Produces("application/json")
	public String addLocation(@QueryParam("address") String address){
		return "not implemented";
	}
}
