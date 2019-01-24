package com.capco.travel.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.capco.travel.model.ForexDetailsBO;
/**
 * This is an interace of Forex 
 * created by Rafik Pinjari
 * 
 */
@FeignClient("forex-service")
public interface ForexClient {
	 
	/*@RequestMapping(value = "/getForexDetails/{requestId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ForexDetailsBO getForexDetails(@PathVariable Integer requestId);*/
	
	@RequestMapping(value = "/getAllForexDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Object> getAllForexDetails();
	
	@RequestMapping(value ="/addForexDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Object> addForex(@RequestBody ForexDetailsBO forexDetails);
	
	/*@RequestMapping(value = "/updateForexDetails", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<String> updateForexDetails(@RequestBody ForexDetailsBO forexDetailsBO);
	
	@RequestMapping(value = "/deleteForexDetails/{requestId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteForexDetails(@PathVariable int requestId);
	
	*/
	
	@RequestMapping("/hello")
	public String sayhello();
}
