package com.prashanth.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.rest.model.Activity;
import com.pluralsight.rest.model.ActivitySearch;
import com.pluralsight.rest.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	/* (non-Javadoc)
	 * @see com.prashanth.rest.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity1.setDescription("Cycling");
		activity1.setDuration(120);
		
		activities.add(activity2);
		
		return activities;
	}

	
	public Activity findActivity(String id) {
		
		if(id.equals("7777")) {
			return null;
		}
		Activity activity1 = new Activity();
		
		User user = new User();
		user.setId("5678");
		user.setName("Prashanth");
		
		activity1.setId("1234");
		activity1.setDescription("Running");
		activity1.setDuration(200);
		activity1.setUser(user);
		
		
		return activity1;
	}


	@Override
	public void create(Activity activity) {
		
		
	}


	@Override
	public Activity update(Activity activity) {
		//search the activity in the database
		//sql statement select * from database where id = ?
		//if rssize == 0
		//create activity
		//else update the activity in database
		
		return activity;
	}


	@Override
	public void delete(String id) {
		//delete activity from database where id=?
		System.out.println(id);
	}


	@Override
	public List<Activity> findByDescription(List<String> descriptions) {
		//search database where description=(? ? ? ?)
		
		List<Activity> activities = new ArrayList<>();
		Activity activity1 = new Activity();
		activity1.setId("1234");
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		
		Activity activity2 = new Activity();
		activity2.setId("2345");
		activity2.setDescription("Running");
		activity2.setDuration(55);
		
		activities.add(activity1);
		activities.add(activity2);
		return activities;
	}


	@Override
	public List<Activity> findByConstraints(ActivitySearch search) {
		System.out.println(search.getDurationFrom());
		List<Activity> activities = new ArrayList<>();
		Activity activity1 = new Activity();
		activity1.setId("1234");
		activity1.setDescription("biking");
		activity1.setDuration(30);
		
		Activity activity2 = new Activity();
		activity2.setId("2345");
		activity2.setDescription("running");
		activity2.setDuration(55);
		
		activities.add(activity1);
		activities.add(activity2);
		return activities;
	}


	}

