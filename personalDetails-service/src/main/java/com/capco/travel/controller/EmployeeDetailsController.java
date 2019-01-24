package com.capco.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.travel.exception.CustomException;
import com.capco.travel.jpaRepo.EmployeeDetailsRepo;
import com.capco.travel.model.EmployeeDetailsBO;
import com.capco.travel.service.EmployeeDetailsService;

@RestController
public class EmployeeDetailsController {
	@Autowired
	private EmployeeDetailsService employeeDetailsService;

	@RequestMapping(value = "/details/{capcoUserId}", method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public EmployeeDetailsBO getPersonalDetailsById(@PathVariable("capcoUserId") String capcoUserId) throws CustomException {
		
		try {
			EmployeeDetailsBO personalDetails = employeeDetailsService.getPersonalDetailsById(capcoUserId);
			//return new ResponseEntity<EmployeeDetailsBO>(personalDetails, HttpStatus.OK);
			return personalDetails;
		}
		catch(CustomException e) {
			throw e;
		}
		
	}
	
	
}
