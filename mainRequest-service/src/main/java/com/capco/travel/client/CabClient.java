package com.capco.travel.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.travel.model.CabDetailsBO;

/**
 * This is an interace of Cab
 * created by Rafik Pinjari
 * interface name CabClient
 */
@FeignClient("cab-service")
public interface CabClient {
	
	@RequestMapping(value="/getAllCabDetails",method=RequestMethod.GET)
	public List<CabDetailsBO> getAllCabDetails();
	
	
	@RequestMapping(value = "/getCabDetails/{requestId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CabDetailsBO getCabDetailsById(@PathVariable("requestId") int requestId);
	

	@RequestMapping(value="/addCabDetails",method=RequestMethod.POST)
	public String addCabDetails(@RequestBody CabDetailsBO cabDetails);
	
	/*@RequestMapping(value="/deleteCab/{uid}",method=RequestMethod.DELETE)
	public String deleteCabDetails(@PathVariable int uid);
	
	@RequestMapping(value="/updateCabDetails/{uid}",method=RequestMethod.PUT)
	public String updateCabDetails(@PathVariable int uid, @RequestBody CabDetailsBO cabDetailsBO);
*/
}
