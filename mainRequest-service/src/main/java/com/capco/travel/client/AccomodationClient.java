package com.capco.travel.client;

import java.util.List;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.travel.model.AccomodationDetailsBO;

/**
 * This is an interace of accommodation client
 * created by Rafik Pinjari
 * 
 */
@FeignClient("accommodation-service")
public interface AccomodationClient {
	@RequestMapping(value = "/addAccomodationDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<AccomodationDetailsBO> addAccomodationDetails(@RequestBody AccomodationDetailsBO accomodationDetails);
	
	
	@RequestMapping(value = "/getAccomodationDetails/{requestId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AccomodationDetailsBO getAccomodationDetails(@PathVariable("requestId") int requestId);
	
	@RequestMapping(value = "/getAllAccomodationDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<AccomodationDetailsBO>> getAllAccomodationDetails();
	
	/*
	@RequestMapping(value = "/updateAccomodationDetails/{request_id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<AccomodationDetailsBO> updateAccomodationDetails(@PathVariable(value="request_id") int requestId ,@RequestBody AccomodationDetailsBO newaccomodationDetailsBO);

	
	@RequestMapping(value = "/deleteAccomodationDetails/{request_id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<AccomodationDetailsBO> deleteAccomodationDetails(@PathVariable("request_id") int requestId);*/
}
