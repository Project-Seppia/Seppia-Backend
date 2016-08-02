package com.seppia.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Location {
	private String address;
	private String phone;
	private String name;
	private Geometry geometry;
	private Photo photo;
	private String price;
	private double rating;
	
	private ArrayList<String> openingTimeInSevenDays; 
	
	public ArrayList<String> getOpeningTimeInSevenDays() {
		return openingTimeInSevenDays;
	}
	public void setOpeningTimeInSevenDays(ArrayList<String> openingTimeInSevenDays) {
		this.openingTimeInSevenDays = openingTimeInSevenDays;
	}
	
	public Photo getPhoto(){
		return photo;
	}
	
	public void setPhoto(Photo photo){
		this.photo = photo; 
	}
	
	public void setPhoto(int height, int width, String refer){
		Photo photo = new Photo();
		photo.setHeight(height);
		photo.setWidth(width);
		photo.setPhotoReference(refer);
		this.photo = photo;
	}
	
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(double lat, double lng) {
		Geometry geo = new Geometry(lat, lng);
		this.geometry = geo;	
	}
	
	public void setGeometry(Geometry geo){
		this.geometry = geo;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
