package com.lti.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.PolicyApplication;
import com.lti.model.Agent;
import com.lti.model.Coverages;
import com.lti.model.NamedInsured;
import com.lti.model.Policy;
import com.lti.model.Property;
import com.lti.service.PolicyImpl;
import com.lti.service.PolicyService;
import com.lti.store.Request;

@SpringBootTest(classes = PolicyApplication.class)
public class PolicyControllerTests {
	@Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;
    
    @MockBean 
    private PolicyService policyService;
    
    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
    
    @Test
    public void testToConfirmPolicyReturnValidData() throws Exception {
    	Mockito.when(policyService.details(Mockito.any(Request.class))).thenReturn(getPolicy());
    	
    	Request request = new Request();
    	
    	request.setPhoneNo("899-345-8756");
    	
    	mockMvc.perform(MockMvcRequestBuilders
    			.post("/api/details")
    			.accept(MediaType.APPLICATION_JSON)
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(new ObjectMapper().writeValueAsString(request)))
    			.andDo(print())
    			.andExpect(status().isOk());
    }
    
    private Policy getPolicy() {
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
				.policyNo("ICW-6WW568-XXXX")
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
