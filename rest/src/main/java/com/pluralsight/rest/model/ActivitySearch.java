package com.pluralsight.rest.model;

import java.util.List;

public class ActivitySearch {
	private int durationFrom;
	private int durationTo;
	
	private List<String> descriptions;

	public int getDurationFrom() {
		return durationFrom;
	}

	public void setDurationFrom(int durationFrom) {
		this.durationFrom = durationFrom;
	}

	public int getDurationTo() {
		return durationTo;
	}

	public void setDurationTo(int durationTo) {
		this.durationTo = durationTo;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "ActivitySearch [durationFrom=" + durationFrom + ", durationTo=" + durationTo + ", descriptions="
				+ descriptions + "]";
	}
	
	

}
