package com.exlibris.dps.repository.plugin.ar;

import java.net.HttpURLConnection;
import java.net.URL;

import com.exlibris.dps.repository.plugin.ARPlugin;


public class OrcidARPlugin implements ARPlugin  {
	
	 public boolean validateToken(String ip, String iePid, String token) {
	        
		 	if (token == null) {
	            return false;
	        }
	        URL url;
	        int statusCode=0;
			try {
				url = new URL("http://pub.sandbox.orcid.org/v1.2/"+token+"/orcid-bio");
				HttpURLConnection http = (HttpURLConnection)url.openConnection();
			    statusCode = http.getResponseCode();
			} catch (Exception e) {
				e.printStackTrace();
			}
	      	        
	        if (statusCode==200){
	        	return true;
	        } else {
	        	return false;	
	        }
	 }
}
	