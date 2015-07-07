package com.codergabs.elastic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class ElasticMain {

	public static void main(String[] args) {

		Employee emp = new Employee();

		String[] interest = { "Code", "Football" };

		Address adr = new Address();
		adr.setApartment("FF2");
		adr.setFlatName("Venkata Sai Enclave");
		adr.setArea("Vinayaka Nagar");
		adr.setCity("Bangalore");
		adr.setPin(560017);

		emp.setName("gabs");
		emp.setAge(28);
		emp.setId(60782);
		emp.setInterest(interest);
		emp.setAdr(adr);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(emp);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);

		RestClient.httpPost(json,"http://localhost:9200/gabsindex/employee/1");
			
		System.out.println(RestClient.httpGet("http://localhost:9200/gabsindex/employee/_search"));
		
	}

}
