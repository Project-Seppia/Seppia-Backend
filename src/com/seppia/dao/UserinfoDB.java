package com.seppia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seppia.model.Userinfo;

public class UserinfoDB {
	
//	get all user from the user table
	public static ArrayList<Userinfo> getAllUsers(Connection connection) throws Exception{
		ArrayList<Userinfo> userSet = new ArrayList<Userinfo>();
		try
		{
			PreparedStatement ps = connection.prepareStatement(
					"SELECT ID, FName, LName, Birth, Phone, "
					+ "Address1, Address2, City, State,"
					+ " Country, LastLogin FROM USER_INFO ORDER BY ID DESC");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			Userinfo user = new Userinfo();
			user.setID(rs.getString("ID"));
			user.setFName(rs.getString("FName"));
			user.setLName(rs.getString("LName"));
			user.setBirth(rs.getString("Birth"));
			user.setPhone(rs.getString("Phone"));
			user.setAddress1(rs.getString("Address1"));
			user.setAddress2(rs.getString("Address2"));
			user.setCity(rs.getString("City"));
			user.setState(rs.getString("State"));
			user.setCountry(rs.getString("Country"));
			user.setLastLogin(rs.getString("LastLogin"));
			userSet.add(user);
			}
			return userSet;
		}
		catch(Exception e){
			throw e;
		}

	}

	

	
}
