package com.capco.travel.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.travel.model.EmployeeDetailsBO;


@FeignClient("personalDetails-service")
public interface PersonalDetailsClient {
         
	@RequestMapping(value = "/details/{capcoUserId}", method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public EmployeeDetailsBO getPersonalDetailsById(@PathVariable("capcoUserId") String capcoUserId);
}
