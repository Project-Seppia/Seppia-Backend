package com.seppia.action;

import java.sql.Connection;
import java.util.ArrayList;

import com.seppia.dao.DB;
import com.seppia.dao.UserDB;
import com.seppia.model.User;

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
