package com.seppia.action;

import java.net.MalformedURLException;
import java.net.URL;

import net.minidev.json.JSONObject;

import com.seppia.util.*;
import com.seppia.dao.Constants;
import com.nimbusds.jose.*;
import com.nimbusds.jose.jwk.source.*;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.*;
import com.nimbusds.jwt.proc.*;

public class TokenAction {

	public Boolean validToken(String token){
		ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
		URL jwtResource;
		try {
			jwtResource = new URL(Constants.publicJWTResource);
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
							throw new BadJWTException("Invalid token use");
						}
						
					}
			});
			
			//process to json object
			JWTClaimsSet claimsSet = jwtProcessor.process(token, ctx);
			JSONObject jsonObject = claimsSet.toJSONObject();
			System.out.println(jsonObject);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//there are 4 kind of exception here
			//1 URL: MalformedURLException
			//2,3 process: BadJOSEExpection, JOSEException
			//4: ParseException;
			e.printStackTrace();
		}

		return false;
	}
}
