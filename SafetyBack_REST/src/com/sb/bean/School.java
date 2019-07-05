package com.sb.bean;

import lombok.Data;

public @Data class School {
	
	private int schoolId;
	private String schoolName;
	private String schoolAddress;
	private Distrito distrito;
}
