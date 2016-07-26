package com.seppia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.seppia.model.Location;
public class STypeDB {

	public static HashMap getAllSportTypes(Connection connection) throws Exception{
		HashMap sportsMap = new HashMap();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT id,name FROM SType ORDER BY id DESC");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.toString());
			while(rs.next())
			{
			sportsMap.put(rs.getInt("id"), rs.getString("name"));
			}
			return sportsMap;
		}
		catch(Exception e){
			throw e;
		}
	}
	
}
