package com.prashanth.rest.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pluralsight.rest.model.Activity;
import com.pluralsight.rest.model.ActivitySearch;

public class ActivityClientTest {
	
	@Test
	public void testSearchObject() {
		ActivitySearchClient client = new ActivitySearchClient();
		List<String> searchValues = new ArrayList<>();
		searchValues.add("biking");
		searchValues.add("running");
		ActivitySearch search = new ActivitySearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(55);
		
		List<Activity> activities = client.search(search);
		System.out.println(activities);
		assertNotNull(activities);
		
	}
	
	@Test
	public void testSearch() {
		ActivitySearchClient client= new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<>();
		searchValues.add("Swimming");
		searchValues.add("Running");
		List<Activity> activities = client.searchActivity(param, searchValues);
		System.out.println(activities);
		assertNotNull(activities);
	}

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1234");
		System.out.println(activity);
		
		assertNotNull(activity);
	}

	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test(expected=RuntimeException.class)
	public void testWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("7777");
	}
	
	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Swimming");
		activity.setDuration(90);
		activity = client.create(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testPut() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setId("2345");
		activity.setDescription("Bikram Yoga");
		activity.setDuration(90);
		activity = client.update(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testDelete() {
		ActivityClient client = new ActivityClient();
		
		client.delete("1234");
//		assertNotNull(activity);
	}
	
}
