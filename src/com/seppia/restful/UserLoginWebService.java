package com.seppia.restful;

import java.util.Timer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.seppia.action.UserLoginAction;
import com.seppia.util.Utility;


@Path("/UserLogin")
public class UserLoginWebService {
	// to edit
	@GET //should be a post function but use get to get return message
	@Path("/addUserLogin")
	@Produces("application/json")
	public String addUserLogin(@QueryParam("user_mail") String mail, @QueryParam("user_pwd") String pwd){
		String message = "";
		String tag = "/Userlogin/addUserLogin";
		try
		{
			boolean status = false;
			UserLoginAction act = new UserLoginAction();
			
			if(mail == null || pwd == null){
				return Utility.constructGSON(tag, status, "Missing not-null data");
			}
			
			status = act.addUserLogin(mail, pwd);
			if(status){
				message = Utility.constructGSON(tag, status, "Register succeeded");
			}else{
				message = Utility.constructGSON(tag, status, "Register failed");
			}
			return message;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return Utility.constructGSON(tag, false, e.getMessage());
		}
	}
	
	@GET //should be a post function but use get to get return message
	@Path("/findUserLogin")
	@Produces("application/json")
	public String findUserLogin(@QueryParam("user_mail") String mail, 
								@QueryParam("user_pwd") String pwd){
		String message = "";
		String tag = "/User/findUserLogin";
		try
		{
			boolean status = false;
//			System.out.println("mail is "+mail);
//			System.out.println("pwd is "+pwd);
			UserLoginAction act = new UserLoginAction();

			if(mail == null || pwd == null){
				return Utility.constructGSON(tag, status, "Missing not-null data");
			}
			status = act.findUserLogin(mail, pwd);
//			if(status) System.out.println("checked");
			if(status){
				message = Utility.constructGSON(tag, status, "User found");
			}else{
				message = Utility.constructGSON(tag, status, "User not found");
			}
			
			return message;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return Utility.constructGSON(tag, false, e.getMessage());
		}
	}
	
	
}
