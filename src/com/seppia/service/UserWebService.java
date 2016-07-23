package com.seppia.service;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;

import com.google.gson.*;
import com.seppia.action.UserAction;
import com.seppia.model.User;

@Path("/User")
public class UserWebService {
	
	
	@GET
	@Path("/getAllUsers")
	@Produces(MediaType.TEXT_HTML)

//	

	public String getAllUsers(){
		String Users = "";
		try
		{
			ArrayList<User> userSet = new ArrayList<User>();
			UserAction act = new UserAction();
			userSet = act.getAllUsers();
			//serialization should be added in to utility.java
			Gson gson = new Gson();
			System.out.println("aaa");
			JsonElement je = gson.toJsonTree(userSet);	
//			System.out.println(je.toString());
			JsonObject jo = new JsonObject();
			jo.add("result", je);
			jo.addProperty("tag", "/User/getUsers");
			jo.addProperty("status", true);
			Users = gson.toJson(jo);
			return Users;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			//delete error
			return e.getMessage();
		}
	}
}
