package com.seppia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.seppia.model.Location;
public class STypeDB {

	public static HashMap<Integer, String> getAllSportTypes(Connection connection) throws Exception{
		HashMap<Integer, String> sportsMap = new HashMap<Integer, String>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT id,name FROM SType ORDER BY id DESC");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.toString());
			while(rs.next())
			{
			sportsMap.put(new Integer(rs.getInt("id")), rs.getString("name"));
			}
			return sportsMap;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public static String getSportTypeById(Connection connection, int id) throws Exception{
		String sport = "";
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT id,name FROM SType WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.toString());
			sport = rs.getString("name");
			return sport;
		}
		catch(Exception e){
			throw e;
		}
	}
	
}
