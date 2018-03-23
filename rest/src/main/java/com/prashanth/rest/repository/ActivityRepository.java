package com.prashanth.rest.repository;

import java.util.List;

import com.pluralsight.rest.model.Activity;
import com.pluralsight.rest.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String id);
	
	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String id);

	List<Activity> findByDescription(List<String> descriptions);

	List<Activity> findByConstraints(ActivitySearch search);


}