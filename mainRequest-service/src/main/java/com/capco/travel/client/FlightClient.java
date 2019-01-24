package com.capco.travel.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.travel.model.FlightDetailsBO;

/**
 * This is an interace of flight 
 * created by Rafik Pinjari
 * 
 */
@FeignClient("flight-service")
public interface FlightClient {
	
	@RequestMapping(value = "/addFlightDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addFlightDetails(@RequestBody FlightDetailsBO flightDetailsBO);
	
	@RequestMapping(value = "/getAllFlightDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<FlightDetailsBO> getEmpDetails();
	
	@RequestMapping(value="/getRequestById/{requestId}", method = RequestMethod.GET)
	public FlightDetailsBO getFlightRequestById(@PathVariable("requestId") int requestId);
	/*
	@RequestMapping(value = "/deleteFlightDetails/{requestId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteFlightDetails(@PathVariable int requestId);*/
	
}
