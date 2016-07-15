package com.seppia.restful;

import java.sql.Connection;
import java.util.ArrayList;

public class UserAction {
	public ArrayList<User> getAllUsers() throws Exception{
		ArrayList<User> userSet = new ArrayList<User>();
		try
		{
			Connection dbConnection = DB.createConnection();
			userSet = UserDB.getAllUsers(dbConnection);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return userSet;
	}
}
