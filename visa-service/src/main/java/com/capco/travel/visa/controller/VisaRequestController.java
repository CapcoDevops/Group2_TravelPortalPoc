package com.capco.travel.visa.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.travel.visa.model.VisaRequestBO;
import com.capco.travel.visa.repository.VisaRepository;
import com.capco.travel.visa.service.VisaService;
import com.capco.travel.visa.util.TravelConstants;

@RestController 
public class VisaRequestController {
	private static final Logger logger = Logger.getLogger(VisaRequestController.class);
	
	@Autowired
	VisaRepository visaRepo;
	
	@Autowired
	VisaService visaService;
	
	@GetMapping("/visa")
	public String hello() {
		
		System.out.println("in controller");
		
		return "hello";
	}
	
	@RequestMapping(value="/addVisaDetails",method = RequestMethod.POST, headers = "Accept=application/json")
	public String addVisa(@RequestBody VisaRequestBO visa) {
		logger.info("VisaRequestController : addVisa : Started"+visa);
		System.out.println();
		if(visa!=null) {
			visaRepo.save(visa);
		}
		logger.info("VisaRequestController : addVisa : Ended");
		return TravelConstants.RESULT_SUCCESS;
		
	}
	
	@RequestMapping(value = "/getVisaDetails/{requestId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<VisaRequestBO> getvisaDetails(@PathVariable("requestId") int requestId) {
		logger.info("VisaServiceController : getVisa : Started");
		VisaRequestBO visaDetails;
			 visaDetails = visaRepo.findByRequestId(requestId);
			 System.out.println("visa requests id in visa service        "+requestId);
			 System.out.println("visa request from visa service     "+visaDetails);
			logger.info("VisaServiceController : getVisa : Ended");
		return new ResponseEntity<VisaRequestBO>(visaDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllVisaDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<VisaRequestBO> getAllvisas() {
		logger.info("VisaServiceController : getAllvisas : Started");
		List<VisaRequestBO> listOfVisas= new ArrayList<VisaRequestBO>();
		
			listOfVisas = (List<VisaRequestBO>) visaRepo.findAll();
			logger.info("visaServiceController : getAllvisas : Ended");
		
		return listOfVisas;
	}
	
	@RequestMapping(value = "/deleteVisaDetails/{requestId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteVisas(@PathVariable("requestId") int requestId) {
		logger.info("visaServiceController : deletevisas : Started");
		
			visaRepo.deleteById(requestId);
			logger.info("VisaServiceController : deleteVisas : Ended");
		
		
		return TravelConstants.RESULT_SUCCESS;
	}
	
	@RequestMapping(value = "/updateVisaDetails", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updatevisaDetails(@RequestBody VisaRequestBO newVisaDetails) {
		logger.info("VisaRequestController : UpdateVisa : Started");
			
		int uid= newVisaDetails.getRequestId();
		
		visaService.updateVisaDetails(uid, newVisaDetails);
		logger.info("VisaServiceController : UpdateVisas : Ended");
		return TravelConstants.RESULT_SUCCESS;
	}

}
