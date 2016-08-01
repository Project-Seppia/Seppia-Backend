package com.seppia.model;
import java.util.*;
import java.io.*;

public class Photo {
	private int height;
	private int width;
	private String photoReference;
	private String PhotoLocalUrl;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getPhotoReference() {
		return photoReference;
	}
	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}
	public String getPhotoLocalUrl() {
		return PhotoLocalUrl;
	}
	public void setPhotoLocalUrl(String photoLocalUrl) {
		PhotoLocalUrl = photoLocalUrl;
	}
	
	public void trySaveImage(String imageUrl) throws IOException{
		//set the image url here
	}
}
