package com.lti.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Agent {
	private String name;
	
	private String code;
	
	private String phoneNo;
	
	private String faxNo;
	
	private String emailId;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String zip;
}
