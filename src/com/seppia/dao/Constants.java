package com.seppia.dao;

//Change these parameters according to DB
public class Constants {
  public static String dbClass = "com.mysql.jdbc.Driver";
  private static String dbName= "ebdb";
  public static String dbUrl = "jdbc:mysql://aa1mcncj2hmom9q.c2jlvu9axx5p.us-east-1.rds.amazonaws.com:3306/"+dbName;
  public static String dbUser = "root";
  public static String dbPwd = "seppiadb";
  public static String mapAPIKey = "AIzaSyCwiqPDugfGJQtYn-LBvwkhscUpJkStlFs";
  public static String textSearchBaseURL = "https://maps.googleapis.com/maps/api/place/textsearch/json?";
  public static String nearbySearchBaseURL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
  public static String publicJWTResource = "https://cognito-idp.us-east-1.amazonaws.com/us-east-1_dDcvwYYrs/.well-known/jwks.json";
}
 
