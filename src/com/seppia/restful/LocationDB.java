package com.seppia.restful;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.seppia.restful.Location;

public class LocationDB {
	
	//Get all locations
	public static ArrayList<Location> getLocations(Connection connection) throws Exception{
		ArrayList<Location> locationData = new ArrayList<Location>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT address,phone,name FROM locations ORDER BY id DESC");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.toString());
			while(rs.next())
			{
			Location locationObject = new Location();
			locationObject.setAddress(rs.getString("address"));
			locationObject.setPhone(rs.getString("phone"));
			locationObject.setName(rs.getString("name"));
			locationData.add(locationObject);
			}
			return locationData;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public static ArrayList<Location> getLocationByAddress(Connection connection, String address) throws Exception{
		ArrayList<Location> locationData = new ArrayList<Location>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT address,phone,name FROM locations WHERE address = ?");
			ps.setString(1, address);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			Location locationObject = new Location();
			locationObject.setAddress(rs.getString("address"));
			locationObject.setPhone(rs.getString("phone"));
			locationObject.setName(rs.getString("name"));
			locationData.add(locationObject);
			}
			return locationData;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public static boolean insertLocation(Connection connection, String address, String phone, String name) throws Exception{
		boolean insertStatus = false;
		try
		{
			PreparedStatement ps = connection.prepareStatement("INSERT into locations(address, phone, name) values(?, ?, ?)");
			ps.setString(1, address);
			ps.setString(2, phone);
			ps.setString(3, name);
			int status = ps.executeUpdate();
			if(status>0){
				insertStatus = true;
			}
			return insertStatus;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public static boolean insertLocation(Connection connection, String address, String name) throws Exception{
		try
		{
			return LocationDB.insertLocation(connection, address, "0", name);
		}
		catch(Exception e){
			throw e;
		}
	}
}
