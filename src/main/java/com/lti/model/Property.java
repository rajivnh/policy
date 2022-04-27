package com.lti.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Property {
	private String address;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private int age;

	private Coverages coverages;
}
