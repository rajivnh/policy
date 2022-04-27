package com.lti.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coverages {
	private String dwellingLimit;
	
	private String dwellingPremium;
	
	private String otherStructureLimit;
	
	private String otherStructurePremium;
	
	private String personalPropertyLimit;
	
	private String personalPropertyPremium;
	
	private String lossOfUseLimit;
	
	private String lossOfUsePremium;
	
	private String liabilityLimit;
	
	private String liabilityPremium;
	
	private String medicalPaymentLimit;
	
	private String medicalPaymentPremium;
}
