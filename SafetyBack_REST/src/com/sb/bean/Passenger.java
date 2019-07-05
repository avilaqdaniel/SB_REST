package com.sb.bean;

import lombok.Data;

public @Data class Passenger {

	private String passDni;
	private Parent parent;
	private Vehicle vehicle;
	private School school;
	private String passName;
	private String passAddress;
	private District district;
	private int passAge;
	private String passGrade;
}
