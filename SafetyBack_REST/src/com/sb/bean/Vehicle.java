package com.sb.bean;

import lombok.Data;

public @Data class Vehicle {
	private String vehiclePlate;
	private Driver driver;
	private VehicleBrand brand;
	private int sits;
	private String soat;
	private String year;
}
