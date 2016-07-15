package com.seppia.restful;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDB {
//	private int registerUser(String name, String uname, String pwd){
//        System.out.println("Inside checkCredentials");
//        int result = 3;
//        if(Utility.isNotNull(uname) && Utility.isNotNull(pwd)){
//            try {
//                if(DB.insertUser(name, uname, pwd)){
//                    System.out.println("RegisterUSer if");
//                    result = 0;
//                }
//            } catch(SQLException sqle){
//                System.out.println("RegisterUSer catch sqle");
//                //When Primary key violation occurs that means user is already registered
//                if(sqle.getErrorCode() == 1062){
//                    result = 1;
//                } 
//                //When special characters are used in name,username or password
//                else if(sqle.getErrorCode() == 1064){
//                    System.out.println(sqle.getErrorCode());
//                    result = 2;
//                }
//            }
//            catch (Exception e) {
//                // TODO Auto-generated catch block
//                System.out.println("Inside checkCredentials catch e ");
//                result = 3;
//            }
//        }else{
//            System.out.println("Inside checkCredentials else");
//            result = 3;
//        }
// 
//        return result;
//    }
	
//	get all user from the user table
	public static ArrayList<User> getAllUsers(Connection connection) throws Exception{
		ArrayList<User> userSet = new ArrayList<User>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT uid, uname, upwd, utime FROM User ORDER BY uid DESC");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			User user = new User();
			user.setUserId(rs.getString("uid"));
			user.setUserName(rs.getString("uname"));
			user.setPwd(rs.getString("upwd"));
			user.setRegisterTime(rs.getString("utime"));
			userSet.add(user);
			}
			return userSet;
		}
		catch(Exception e){
			throw e;
		}
	}

	
}
