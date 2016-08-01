package com.seppia.model;
import java.util.*;
import java.net.URL;

public class LocationFetched {

	private String address; //vicinity in return result
	private String vicinity;
	private String phone;
	private String name;
	private Geometry geometry;
	private URL icon;
	private String gPlaceID;
	
	private ArrayList<String> openingTimeInSevenDays; 
	private ArrayList<String> type;
	private ArrayList<Photo> photos;
	
	public ArrayList<Photo> getPhotos(){
		return photos;
	}
	
	public void setPhotos(Photo[] photos){
		this.photos = new ArrayList<Photo>(Arrays.asList(photos));
	}
	
	public LocationFetched(){
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
	public URL getIcon() {
		return icon;
	}
	public void setIcon(URL icon) {
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
	public void setOpeningTimeInSevenDays(String[] openingTimeInSevenDays) {
		this.openingTimeInSevenDays = new ArrayList<String>(Arrays.asList(openingTimeInSevenDays));
	}
	public ArrayList<String> getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = new ArrayList<String>(Arrays.asList(type));
	}
	
	
}
