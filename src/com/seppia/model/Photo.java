package com.seppia.model;
import java.util.*;
import java.io.*;
import java.net.*;

public class Photo {
	private int height;
	private int width;
	private String photoReference;
	
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
	
	public void trySaveImage(String imageUrl) throws IOException{
		//set the image url here
	}
}
