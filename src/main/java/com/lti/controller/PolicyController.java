package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lti.model.Policy;
import com.lti.service.PolicyService;
import com.lti.store.Request;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class PolicyController {
	private PolicyService policyService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public PolicyController(PolicyService policyService) {
		this.policyService = policyService;
	}
	
	@PostMapping("/v1/details")
	public Policy details(@RequestBody Request request) {
		return policyService.details(request);
	}
	
	@GetMapping("/v1/discovery")
	public String hello() {
		String response = (String) restTemplate.getForEntity("http://policy-service/policy/api/v1/endpoint", String.class).getBody();
		
		return response;
	}
	
	@GetMapping("/v1/endpoint")
	public String endpoint() {
		return "RestTemplate consumes endpoint services provided by Discovery Server";
	}
}
