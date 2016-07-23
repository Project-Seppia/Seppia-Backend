package com.seppia.action;

import java.sql.Connection;
import java.util.ArrayList;

import com.seppia.dao.DB;
import com.seppia.dao.LocationDB;
import com.seppia.model.Location;

public class LocationAction {
	public ArrayList<Location> getNearbyLocationsByAddress(String address) throws Exception{
		ArrayList<Location> locationData = new ArrayList<Location>();
		try
		{
			Connection dbConnection = DB.createConnection();
			locationData = LocationDB.getLocationByAddress(dbConnection, address);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return locationData;
	}
	public boolean addNewLocation(String address, String phone, String name) throws Exception{
		try
		{
			if(address != null && name != null){
				Connection dbConnection = DB.createConnection();
				if(phone != null) return LocationDB.insertLocation(dbConnection, address, phone, name);
				else return LocationDB.insertLocation(dbConnection, address, name);
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			throw e;
		}
	}
}
