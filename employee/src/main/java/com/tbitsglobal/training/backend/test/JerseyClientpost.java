package com.tbitsglobal.training.backend.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.tbitsglobal.training.backend.entities.Employee;
 
public class JerseyClientpost {
	
	
	
	 public Employee post(Employee emp)
	 {
		 try
		 {
					ClientConfig clientConfig = new DefaultClientConfig();
					clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				
					Client client = Client.create(clientConfig);
					
					WebResource webResource = client.resource("http://localhost:8080/employee/rest/employee/post");
					
					//String input = "{\"name\":\"abc\",\"designation\":\"Employee\",\"salary\":1500}";
					
					ClientResponse response = webResource.type("application/json")
							   .post(ClientResponse.class, emp);
			        emp=null;
			        
					if (response.getStatus() != 201) {
						   throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
						}
					
					emp = response.getEntity(Employee.class);
					System.out.println("Output from Server .... \n");
					System.out.println(emp);
					
			}
			 catch (Exception e) {
				 
					e.printStackTrace();
			 
				  }		 
		 return emp;	
	 }
}
