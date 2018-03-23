package com.prashanth.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pluralsight.rest.model.Activity;
import com.pluralsight.rest.model.ActivitySearch;
import com.prashanth.rest.repository.ActivityRepository;
import com.prashanth.rest.repository.ActivityRepositoryStub;

@Path("search/Activities")
public class ActivitySearchResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response searchForActivities(ActivitySearch search) {
		System.out.println(search);
		
		List<Activity> activities = activityRepository.findByConstraints(search);
		
		System.out.println(activities);
		
		if(activities==null||activities.size()<=0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(new GenericType<List<Activity>>() {}).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response searchForActivities(@QueryParam(value="description") List<String> descriptions)
	{
		System.out.println(descriptions);
		
		List<Activity> activities = activityRepository.findByDescription(descriptions);
		
		if(activities==null||activities.size()<=0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(new GenericType<List<Activity>>() {}).build();
	}
}
