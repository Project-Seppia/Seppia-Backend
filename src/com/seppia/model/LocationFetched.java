package com.seppia.model;
import java.util.*;
public class LocationFetched {

	private String address; //vicinity in return result
	private String vicinity;
	private String phone;
	private String name;
	private Geometry geometry;
	private String icon;
	private String gPlaceID;
	private ArrayList<String> openingTimeInSevenDays; 
	//should be an array of enum
	private ArrayList<String> type;
	
	public LocationFetched(String gSon){
		//public contructor, need to switch to model factory afterwards
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getgPlaceID() {
		return gPlaceID;
	}
	public void setgPlaceID(String gPlaceID) {
		this.gPlaceID = gPlaceID;
	}
	public ArrayList<String> getOpeningTimeInSevenDays() {
		return openingTimeInSevenDays;
	}
	public void setOpeningTimeInSevenDays(ArrayList<String> openingTimeInSevenDays) {
		this.openingTimeInSevenDays = openingTimeInSevenDays;
	}
	public ArrayList<String> getType() {
		return type;
	}
	public void setType(ArrayList<String> type) {
		this.type = type;
	}
	
	
}
