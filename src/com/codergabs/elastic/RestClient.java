package com.codergabs.elastic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {

	public static void httpPost(String json, String resturl){
		 try {
			 
				URL url = new URL(resturl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Content-Type", "application/json");
		 
				
		 
				OutputStream os = conn.getOutputStream();
				os.write(json.getBytes());
				os.flush();
		 
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}
		 
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));
		 
				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
		 
				conn.disconnect();
		 
			  } catch (MalformedURLException e) {
		 
				e.printStackTrace();
		 
			  } catch (IOException e) {
		 
				e.printStackTrace();
		 
			 }
		 
	}
	
	public static String httpGet(String resturl){
		String output = null; 
		try {
			  
				URL url = new URL(resturl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-Type", "application/json");
		 
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
		 
				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		 
				
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					//System.out.println(output);
				}
		 
				conn.disconnect();
		 
			  } catch (MalformedURLException e) {
		 
				e.printStackTrace();
		 
			  } catch (IOException e) {
		 
				e.printStackTrace();
		 
			  }
		  
		  return output;
	}
}
