package com.prashanth.rest.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.pluralsight.rest.model.Activity;
import com.pluralsight.rest.model.ActivitySearch;

public class ActivitySearchClient {
	private Client client;
	public ActivitySearchClient() {
		client = ClientBuilder.newClient();
	}
	
	public List<Activity> searchActivity(String param, List<String> searchValues){
		URI uri = UriBuilder.fromUri("http://localhost:8080/rest/webapi/")
				.path("search/Activities")
				.queryParam(param, searchValues)
				.build();
		WebTarget target = client.target(uri);
		List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {});
		System.out.println(response);
		return response;
	}

	public List<Activity> search(ActivitySearch search) {
//		URI uri = UriBuilder.fromUri("http://localhost:8080/rest/webapi")
//				.path("search/Activities")
//				.build();
//		
		WebTarget target = client.target("http://localhost:8080/rest/webapi/");
		Response response = target.path("search/Activities").request(MediaType.APPLICATION_JSON).post(Entity.entity(search, MediaType.APPLICATION_JSON));
		
		if(response.getStatus()!=200) {
			throw new RuntimeException(response.getStatus()+":there was an error on the server");
		}
		
		return response.readEntity(new GenericType<List<Activity>>() {});
	}
}
