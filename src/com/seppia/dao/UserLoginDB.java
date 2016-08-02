package com.seppia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;

import java.time.format.*;

import com.seppia.model.UserLogin;



public class UserLoginDB {

	public static boolean addUserLogin(Connection connection, String mail,
			String pwd) throws Exception {
		boolean result = false;
		try
		{
			// if cannot find user, continue
			// if found, cannot register again
			if(findUserLogin(connection, mail, pwd)) {
				System.out.println("user exists");
				return false;
			}
			ArrayList<String> tokens = generateTimeString();
			PreparedStatement ps = connection.prepareStatement(
					"Insert into USER_LOGIN (user_mail, user_pwd, user_token, user_token_expire) values (?, ?, ?, ?)");
			ps.setString(1, mail);
			ps.setString(2, pwd);
			ps.setString(3, tokens.get(0));
			ps.setString(4, tokens.get(1));
			System.out.println(ps);
			int rs = ps.executeUpdate();
			if(rs > 0){
				result = true;
			}
			return result;
		}
		catch(Exception e){
			throw e;
		}
	}

	public static boolean findUserLogin(Connection connection, String mail,
			String pwd) throws Exception {
		boolean result = false;
		try
		{
			PreparedStatement ps = connection.prepareStatement("Select user_id from USER_LOGIN where user_mail = ? && user_pwd = ?");
			ps.setString(1, mail);
			ps.setString(2, pwd);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				result = true;
			}
			return result;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public static ArrayList<String> generateTimeString(){
		ArrayList<String> rs = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		final Date currentTime = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, +7);
		final Date expireTime = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		rs.add(sdf.format(currentTime));
		rs.add(sdf.format(expireTime));
		
		return rs;
	}
	
	
	public static boolean checkToken(UserLogin user){
		
		return false;
	}
	
	public static void main(String[] args){
		UserLoginDB udb = new UserLoginDB();
		udb.generateTimeString();
	}
}
