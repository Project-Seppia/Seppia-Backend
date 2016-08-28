package com.seppia.restful;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;

import com.google.gson.*;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.proc.BadJOSEException;
import com.seppia.action.LocationAction;
import com.seppia.action.TokenAction;
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
	
	@GET
	@Path("/getUserByID")
	@Produces("application/json")
	public String getUserById(@QueryParam("token") String idToken){
		TokenAction tokenAction = new TokenAction();
		try {
			Userinfo userInfo = tokenAction.validIDToken(idToken);
			//TODO: use user info object to return
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadJOSEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JOSEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Not Implemented";
	}
}
