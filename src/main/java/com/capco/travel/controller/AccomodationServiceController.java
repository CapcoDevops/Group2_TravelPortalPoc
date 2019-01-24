package com.capco.travel.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.travel.exceptions.BaseException;
import com.capco.travel.exceptions.TravelException.TravelServiceException;
import com.capco.travel.model.AccomodationDetailsBO;
import com.capco.travel.repository.AccomodationRepository;
import com.capco.travel.service.AccommodationService;
import com.capco.travel.util.TravelConstants;


@RestController
public class AccomodationServiceController {
	private static final Logger logger = Logger.getLogger(AccomodationServiceController.class);
	@Autowired  
	AccommodationService accomodationservice;
	
	/**
	 * This method to get AccomodationDetails from database*
	 * @methodName getAccomodationDetails
	 * @param long 
	 * @throws BaseException 
	 * @throws -
	 */
	@RequestMapping(value = "/getAccomodationDetails/{request_id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<AccomodationDetailsBO> getAccomodationDetails(@PathVariable("request_id") int requestId) throws BaseException {
		logger.info("AccomodationServiceController : getAccomodationDetails : Started");
		try {
				AccomodationDetailsBO accomodationDetails = accomodationservice.getAccomodationDetails(requestId);
				return new  ResponseEntity<AccomodationDetailsBO>(accomodationDetails,HttpStatus.OK);
		} catch (BaseException ex) {
			throw ex;
		}
			
		 
		
	}

	/**
	 * This method to insert Accomodation Details into database*
	 * @methodName insertAccomodationDetails
	 * @param com.capco.travel.vo.AccomodationDetailsVO
	 * @throws BaseException 
	 * @throws -
	 */
	@RequestMapping(value = "/addAccomodationDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<AccomodationDetailsBO> addAccomodationDetails(@RequestBody AccomodationDetailsBO accomoDetailsBO) throws BaseException {
		try {
			
			AccomodationDetailsBO addAccomodationDetails = accomodationservice.addAccomodationDetails(accomoDetailsBO);
			return new  ResponseEntity<AccomodationDetailsBO>(accomoDetailsBO,HttpStatus.OK);
		} catch (BaseException ex) {
			logger.error("AccomodationServiceController : setAccomodationDetails : ServiceException Caught : " + ex);
			throw ex;
		}
		
	}

	/**
	 * This method to update AccomodationDetails into database*
	 * @methodName updateAccomodationDetails
	 * @param com.capco.travel.vo.AccomodationDetailsVO
	 * @throws BaseException 
	 * @throws -
	 */
	@RequestMapping(value = "/updateAccomodationDetails/{request_id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<AccomodationDetailsBO> updateAccomodationDetails(@PathVariable(value="request_id") int requestId ,@RequestBody AccomodationDetailsBO newaccomodationDetailsBO) throws BaseException {
		logger.info("AccomodationServiceController : updateAccomodationDetails : Started");
		
		
		try {
			AccomodationDetailsBO accomodationDetails = accomodationservice.updateAccomodationDetails(requestId, newaccomodationDetailsBO);
			return new  ResponseEntity<AccomodationDetailsBO>(accomodationDetails,HttpStatus.OK);
	} catch (BaseException ex) {
		throw ex;
	}
		
	}
	
	/**
	 * This method to get All AccomodationDetails from database*
	 * @methodName getAllAccomodationDetails
	 * @param -No param
	 * @throws BaseException 
	 * @throws -
	 */
	@RequestMapping(value = "/getAllAccomodationDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<AccomodationDetailsBO>> getAllAccomodationDetails() throws BaseException {
		logger.info("AccomodationServiceController : getAllAccomodationDetails : Started");
		try {
			List<AccomodationDetailsBO> accomodationDetails = accomodationservice.getAllAccomodationDetails();
			return new  ResponseEntity<List<AccomodationDetailsBO>>(accomodationDetails,HttpStatus.OK);
	} catch (BaseException ex) {
		throw ex;
	}
	}

	/**
	 * @throws BaseException 
	 * This method to delete AccomodationDetails  from database*
	 * @methodName deleteAccomodationDetails
	 * @param long
	 * @throws 
	 */
	@RequestMapping(value = "/deleteAccomodationDetails/{request_id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<AccomodationDetailsBO> deleteAccomodationDetails(@PathVariable("request_id") int requestId) throws BaseException {
		logger.info("AccomodationServiceController : deleteAccomodationDetails : Started");
		
		try {
			AccomodationDetailsBO deleteAccomodationDetails = accomodationservice.deleteAccomodationDetails(requestId);
			logger.info("AccomodationServiceController : deleteAccomodationDetails : Ended");
			return new  ResponseEntity<AccomodationDetailsBO>(deleteAccomodationDetails,HttpStatus.OK);
		} catch (BaseException ex) {
			logger.error("AccomodationServiceController : deleteAccomodationDetails : ServiceException Caught : " + ex);
			throw ex;
		}
	
    }
}
