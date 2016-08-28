package com.seppia.action;

//TODO: This should be names as Shared Token Manager and use singleton pattern. But do it latter

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import net.minidev.json.JSONObject;

import com.seppia.model.Userinfo;
import com.seppia.util.*;
import com.seppia.dao.Constants;
import com.nimbusds.jose.*;
import com.nimbusds.jose.jwk.source.*;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.*;
import com.nimbusds.jwt.proc.*;

public class TokenAction {

	public String validAccessToken(String token) throws ParseException, BadJOSEException, JOSEException, MalformedURLException{
		ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
		URL jwtResource = new URL(Constants.publicJWTResource);
			JWKSource keySource = new RemoteJWKSet(jwtResource);
			JWSAlgorithm expectedJWSAlg = JWSAlgorithm.RS256;
			JWSKeySelector keySelector = new JWSVerificationKeySelector(expectedJWSAlg, keySource);
			jwtProcessor.setJWSKeySelector(keySelector);
			
			SecurityContext ctx = null; // optional context parameter, not required here
			
			jwtProcessor.setJWTClaimsSetVerifier(new DefaultJWTClaimsVerifier(){
				@SuppressWarnings("unchecked")
				@Override
				public void verify(JWTClaimsSet claimsSet, SecurityContext ctx)
					throws BadJWTException{
						super.verify(claimsSet, ctx);
						String issuer = claimsSet.getIssuer();
						if (issuer == null || !issuer.equals("https://cognito-idp.us-east-1.amazonaws.com/us-east-1_dDcvwYYrs")) {
				            throw new BadJWTException("Invalid token issuer");
				        }
						String tokenUse = (String)claimsSet.getClaim("token_use");
						if(tokenUse == null || !tokenUse.equals("access")){
							throw new BadJWTException("Invalid token usage");
						}
						
					}
			});
			
			//check using our own verifier and process to json object
			JWTClaimsSet claimsSet = jwtProcessor.process(token, ctx);
			JSONObject jsonObject = claimsSet.toJSONObject();
			System.out.println(jsonObject);
			String username = (String) jsonObject.get("username");
			return username;
			
			//there are 4 kind of exception throws out here here
			//1 URL: MalformedURLException
			//2,3 process: BadJOSEExpection, JOSEException
			//4: ParseException;
	}
	
	public Userinfo validIDToken(String token) throws ParseException, BadJOSEException, JOSEException, MalformedURLException{
		ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
		URL jwtResource = new URL(Constants.publicJWTResource);
			JWKSource keySource = new RemoteJWKSet(jwtResource);
			JWSAlgorithm expectedJWSAlg = JWSAlgorithm.RS256;
			JWSKeySelector keySelector = new JWSVerificationKeySelector(expectedJWSAlg, keySource);
			jwtProcessor.setJWSKeySelector(keySelector);
			
			SecurityContext ctx = null; // optional context parameter, not required here
			
			jwtProcessor.setJWTClaimsSetVerifier(new DefaultJWTClaimsVerifier(){
				@SuppressWarnings("unchecked")
				@Override
				public void verify(JWTClaimsSet claimsSet, SecurityContext ctx)
					throws BadJWTException{
						super.verify(claimsSet, ctx);
						String issuer = claimsSet.getIssuer();
						if (issuer == null || !issuer.equals("https://cognito-idp.us-east-1.amazonaws.com/us-east-1_dDcvwYYrs")) {
				            throw new BadJWTException("Invalid token issuer");
				        }
						String tokenUse = (String)claimsSet.getClaim("token_use");
						if(tokenUse == null || !tokenUse.equals("id")){
							throw new BadJWTException("Invalid token usage");
						}
						
					}
			});
			
			//check using our own verifier and process to json object
			JWTClaimsSet claimsSet = jwtProcessor.process(token, ctx);
			JSONObject jsonObject = claimsSet.toJSONObject();
			System.out.println(jsonObject);
			Userinfo userInfo = new Userinfo();
			//TODO: setup the user info object either by get it from our db if any exist or save it from token information
			return userInfo;
			
			//there are 4 kind of exception throws out here here
			//1 URL: MalformedURLException
			//2,3 process: BadJOSEExpection, JOSEException
			//4: ParseException;
	}
	
	public Userinfo userinfoFromToknJsonObject(JSONObject jsonObject){
		//TODO: do the json object to userinfo object transfer
		//May need to call user info dao to save to db here OR use function from Userinfo Action
		return new Userinfo();
		
	}
	
}
