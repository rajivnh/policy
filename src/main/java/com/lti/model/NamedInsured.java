package com.lti.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NamedInsured {
	private String insuredName;

	private String emailId;
	
	private String phoneNo;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String zip;
}