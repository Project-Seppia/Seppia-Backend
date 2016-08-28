package com.seppia.restful;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.*;
import com.seppia.action.LocationAction;
import com.seppia.model.Location;
import com.seppia.util.Utility;
import com.seppia.action.*;
@Path("/location")
public class LocationWebService {
	
	@GET
	@Path("/getLocations")
	@Produces("application/json")
	public String getNearbyLocations(@QueryParam("address") String address, @QueryParam("token") String token){
		String locations = "";
		String tag = "/location/getLocations";
		try
		{
			TokenAction tokenAction = new TokenAction();
			String username = tokenAction.validAccessToken(token);
			if(username != null){
				ArrayList<Location> locationData = new ArrayList<Location>();
				LocationAction lc = new LocationAction();
				//for test should return FALSE status
				if(address == null){
					address = "1650 81 ST";
				}
				locationData = lc.getNearbyLocationsByAddress(address);
				locations = Utility.constructGSON(tag, true, locationData);
				if(username != "defaultUser"){
					//TODO: log user activity here
				}
				return locations;
			}
			else{
				return Utility.constructGSON(tag, false, "Invalid Token");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return Utility.constructGSON(tag, false, e.getMessage());
		}
	}
	
	@GET //should be a post function but use get to get return message
	@Path("/addLocation")
	@Produces("application/json")
	public String addLocation(@QueryParam("address") String address, @QueryParam("name") String name, @QueryParam("phone") String phone){
		String message = "";
		String tag = "/location.addLocation";
		try
		{
			boolean status = false;
			LocationAction lc = new LocationAction();
			if(address == null || name == null){
				return Utility.constructGSON(tag, status, "Missing not-null data");
			}
			status = lc.addNewLocation(address, phone, name);
			message = Utility.constructGSON(tag, status, "Added");
			
			return message;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return Utility.constructGSON(tag, false, e.getMessage());
		}
	}
}
