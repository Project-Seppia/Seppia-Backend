package com.seppia.action;

import java.sql.Connection;

import com.seppia.dao.DB;
import com.seppia.dao.UserLoginDB;

public class UserLoginAction {
	public boolean addUserLogin(String mail, String pwd) throws Exception{
		try
		{
			if(mail != null && pwd != null){
				Connection dbConnection = DB.createConnection();
				return UserLoginDB.addUserLogin(dbConnection, mail, pwd);
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			throw e;
		}
	}

	public boolean findUserLogin(String mail, String pw) throws Exception {
		try
		{
			if(mail != null && pw != null){
				Connection dbConnection = DB.createConnection();
				return UserLoginDB.findUserLogin(dbConnection, mail, pw);
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
