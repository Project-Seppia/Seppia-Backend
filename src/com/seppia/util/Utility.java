package com.seppia.util;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.*;
import com.seppia.dao.Constants;

public class Utility {
    /**
     * Null check Method
     * 
     * @param txt
     * @return
     */
    public static boolean isNotNull(String txt) {
        // System.out.println("Inside isNotNull");
        return txt != null && txt.trim().length() >= 0 ? true : false;
    }
 
    /**
     * Method to construct JSON
     * 
     * @param tag
     * @param status
     * @return
     */
    public static String constructJSON(String tag, boolean status) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("tag", tag);
            obj.put("status", new Boolean(status));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
        }
        return obj.toString();
    }
 
    /**
     * Method to construct JSON with Error Msg
     * 
     * @param tag
     * @param status
     * @param err_msg
     * @return
     */
    public static String constructJSON(String tag, boolean status,String err_msg) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("tag", tag);
            obj.put("status", new Boolean(status));
            obj.put("error_msg", err_msg);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
        }
        return obj.toString();
    }
    
    public static String constructGSON(String tag, boolean status, String err_msg){
		Gson gson = new Gson();
		//System.out.println(locationData.toString());
		JsonObject jo = new JsonObject();	
		jo.addProperty("tag", tag);
		jo.addProperty("status", status);
		jo.addProperty("err_msg", err_msg);
		System.out.println(jo.toString());
		return gson.toJson(jo);
    }
    
    //this function can be divided into two: 1) one single object; 2) an array of object
    public static String constructGSON(String tag, boolean status, Object result){
    	//serialization should be added in to utility.java
		Gson gson = new Gson();
		//System.out.println(locationData.toString());
		JsonElement je = gson.toJsonTree(result);	
		//System.out.println(je.toString());
		JsonObject jo = new JsonObject();
		jo.add("result", je);
		jo.addProperty("tag", tag);
		jo.addProperty("status", true);
		jo.addProperty("err_msg", "None");
		//System.out.println(jo.toString());
		return gson.toJson(jo);
    }
 
    public static String constructSearchURL(String query, String radius){
    	StringBuilder result = new StringBuilder(Constants.searchBaseURL);
    	result.append("query=");
    	result.append(query);
    	result.append("&radius=");
    	result.append(radius);
    	result.append("&key=");
    	result.append(Constants.mapAPIKey);
    	return result.toString();
    }
    
    public static String constructSearchQuery(String query, String zipcode, String country){
    	StringBuilder result = new StringBuilder(query);
    	result.append(" in");
    	result.append(zipcode);
    	result.append(" ");
    	result.append(country);
    	return result.toString();
    }
    
}