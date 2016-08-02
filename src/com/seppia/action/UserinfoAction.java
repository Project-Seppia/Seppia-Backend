package com.seppia.action;

import java.sql.Connection;
import java.util.ArrayList;

import com.seppia.dao.DB;
import com.seppia.dao.LocationDB;
import com.seppia.dao.UserinfoDB;
import com.seppia.model.Userinfo;

public class UserinfoAction {
	public ArrayList<Userinfo> getAllUsers() throws Exception{
		ArrayList<Userinfo> userSet = new ArrayList<Userinfo>();
		try
		{
			Connection dbConnection = DB.createConnection();
			userSet = UserinfoDB.getAllUsers(dbConnection);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return userSet;
	}
	
	
}
