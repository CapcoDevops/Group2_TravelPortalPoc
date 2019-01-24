package com.capco.travel.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.travel.model.VisaRequestBO;

/**
 * This is an interace of Visa 
 * created by Rafik Pinjari
 * 
 */
@FeignClient("visa-service")
public interface VisaClient {
	

	@RequestMapping(value="/addVisaDetails",method = RequestMethod.POST, headers = "Accept=application/json")
	public String addVisa(@RequestBody VisaRequestBO visa);
	
	@RequestMapping(value = "/getVisaDetails/{requestId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public VisaRequestBO getvisaDetails(@PathVariable("requestId") int requestId); 
	/*
	@RequestMapping(value = "/getAllVisaDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<VisaRequestBO> getAllvisa();
	
	@RequestMapping(value = "/deleteVisaDetails/{requestId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteVisas(@PathVariable("requestId") int requestId);
	
	@RequestMapping(value = "/updateVisaDetails", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updatevisaDetails(@RequestBody VisaRequestBO newVisaDetails);
*/
}
