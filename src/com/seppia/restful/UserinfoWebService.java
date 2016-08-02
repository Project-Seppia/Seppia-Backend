package com.seppia.restful;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;

import com.google.gson.*;
import com.seppia.action.LocationAction;
import com.seppia.action.UserinfoAction;
import com.seppia.model.Location;
import com.seppia.model.Userinfo;
import com.seppia.util.Utility;

@Path("/Userinfo")
public class UserinfoWebService {
	
	
	@GET
	@Path("/getAllUsers")
	@Produces("application/json")

//	

	public String getAllUsers(){
		String Users = "";
		String tag = "/Userinfo/getUsers";
		try
		{
			ArrayList<Userinfo> userSet = new ArrayList<Userinfo>();
			UserinfoAction act = new UserinfoAction();
			userSet = act.getAllUsers();
			Users = Utility.constructGSON(tag, true, userSet);
			return Users;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			//delete error
			return e.getMessage();
		}
	}
	
}
