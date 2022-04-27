package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lti.model.Agent;
import com.lti.model.Coverages;
import com.lti.model.NamedInsured;
import com.lti.model.Policy;
import com.lti.model.Property;
import com.lti.property.VendorProperties;
import com.lti.store.Request;

@Service
public class PolicyImpl implements PolicyService {
	@Autowired
	private VendorProperties vendorProperties;
	
	@Override
	@Cacheable(cacheNames = "names")
	public Policy details(Request request) {
		NamedInsured namedInsured = NamedInsured.builder()
				.insuredName("A-One Condo Associates")
				.emailId("r1moatret@geico.com")
				.phoneNo("(888) 395-1200")
				.address("111 East St")
				.city("Chicago")
				.state("IL")
				.zip("60604-3269")
				.build();
		
		Coverages coverages = Coverages.builder()
				.dwellingLimit("147,000")
				.dwellingPremium("756.26")
				.otherStructureLimit("14,700")
				.otherStructurePremium("Included")
				.personalPropertyLimit("80,850")
				.personalPropertyPremium("15.17")
				.lossOfUseLimit("29,400")
				.lossOfUsePremium("Included")
				.liabilityLimit("500,000")
				.liabilityPremium("35.00")
				.medicalPaymentLimit("5,000")
				.medicalPaymentPremium("10.00")
				.build();
		
		Property property = Property.builder()
				.age(12)
				.address("126 Main St")
				.city("Oak Lawn")
				.state("IL")
				.zip("60453-6030")
				.coverages(coverages)
				.build();
		
		Agent agent = Agent.builder()
				.name("Stephen G Neil Jr")
				.address("11132 W 179th St")
				.city("Orland Park")
				.state("IL")
				.zip("60467-9435")
				.faxNo("(708) 478-3332")
				.phoneNo("(708) 478-3339")
				.emailId("stephen.neil.sxbd@statefarm.com")
				.code("453RF8593Y7")
				.build();
				
		Policy policy = Policy.builder()
				.vendorName(vendorProperties.getName())
				.policyNo("SPR-6WW568-1004")
				.namedInsured(namedInsured)
				.agent(agent)
				.effectiveDate("03/24/2022")
				.expirationDate("03/24/2023")
				.policyStatus("Active")
				.policyType("COND Residential Community Assn Policy")
				.property(property)
				.build();
		
		return policy;
	}
}
