package com.lti.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Policy {
	private String vendorName;
	
	private String policyNo;
	
	private String policyType;
	
	private String policyStatus;
	
	private String effectiveDate;
	
	private String expirationDate;
	
	private NamedInsured namedInsured;
	
	private Property property;
	
	private Agent agent;
}
