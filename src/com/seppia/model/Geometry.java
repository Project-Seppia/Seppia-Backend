package com.seppia.model;


public class Geometry {
	private double lat;
	private double lng;
	public Geometry(double lat, double lng){
		this.lat = lat;
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public double getDir(){
		return 0.0;
	}
}
