package com.seppia.action;

import java.sql.Connection;
import com.seppia.dao.*;

import java.util.*;

public class STypeAction {
	public HashMap<Integer, String> getAllSTypes() throws Exception{
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		try
		{
			Connection connection = DB.createConnection();
			result = STypeDB.getAllSportTypes(connection);
			return result;
		}
		catch(Exception e){
			throw e;
		}
		
	}
	
	public String getSTypeById(int id) throws Exception{
		String result = "";
		try
		{
			Connection connection = DB.createConnection();
			result = STypeDB.getSportTypeById(connection, id);
			return result;
		}
		catch(Exception e){
			throw e;
		}
		
	}
}
