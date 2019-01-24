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

import com.capco.travel.custom.exception.TravelException.TravelServiceException;
import com.capco.travel.model.CabDetailsBO;
import com.capco.travel.service.CabService;
import com.capco.travel.TravelConstants.TravelConstants;

@RestController
public class CabServiceController{
	
	private static final Logger logger = Logger.getLogger(CabServiceController.class);
	
	
	@Autowired
	CabService cabService;
	
	/**
	 * This method to get Cab Details from database*
	 * @methodName getAllCabDetails
	 * @param int
	 */
	@RequestMapping(value="/getAllCabDetails",method=RequestMethod.GET)
	public List<CabDetailsBO> getAllCabDetails() {
		logger.info("CabServiceController : getAllCabDetails : Started");
		List<CabDetailsBO> listOfCabs = null;
		try {
			listOfCabs = cabService.getCabDetails();
			logger.info("CabServiceController : getAllCabDetails : Ended");
		} catch (TravelServiceException ex) {
			logger.error("CabServiceController : getAllCabDetails : TravelServiceException Caught : " + ex);
		}
		return listOfCabs;
	}
	/**
	 * This method to get Cab Details from database*
	 * @methodName getCabDetailsById
	 * @param int
	 */
	@RequestMapping(value = "/getCabDetails/{requestId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CabDetailsBO> getCabDetailsById(@PathVariable("requestId") int requestId) {
		logger.info("CabServiceController : getCabDetailsById : Started");
		CabDetailsBO cabDetails =null;
		try {
			 cabDetails = cabService.getCabDetails(requestId);
			logger.info("CabServiceController : getCabDetailsById : Ended");
		} catch (TravelServiceException ex) {
			logger.error("CabServiceController : getCabDetailsById : ServiceException Caught : " + ex);
			return new ResponseEntity(TravelConstants.RESULT_NULL_OBJECT+requestId, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cabDetails, HttpStatus.OK);
	}
	
	/**
	 * This method to get Cab Details from database*
	 * @methodName addCabDetails
	 * @param int
	 */
	
	@RequestMapping(value="/addCabDetails",method=RequestMethod.POST)
	public String addCabDetails(@RequestBody CabDetailsBO cabDetailsBO) {
		
		logger.info("CabServiceController : addCabDetails : Started");
		try {
			cabService.addCabDetails(cabDetailsBO);
			logger.info("CabServiceController : addCabDetails : Ended");
			
		}
		catch(TravelServiceException ex) {
			logger.error("CabServiceController : addCabDetails : TravelServiceException Caught : " + ex);
			return TravelConstants.RESULT_FAIL;
		}
		return TravelConstants.RESULT_SUCCESS;
	}
	
	/**
	 * This method to get Cab Details from database*
	 * @methodName deleteCabDetails
	 * @param int
	 */
	
	@RequestMapping(value="/deleteCab/{uid}",method=RequestMethod.DELETE)
	public String deleteCabDetails(@PathVariable int uid) {
		logger.info("CabServiceController : deleteCabDetails : Started");
		try {
		cabService.deleteCabDetails(uid);
		logger.info("CabServiceController : deleteCabDetails : Ended");
		} catch (TravelServiceException ex) {
			logger.error("CabServiceController : deleteCabDetails : TravelServiceException Caught : " + ex);
			return TravelConstants.RESULT_FAIL;
		}
		return TravelConstants.RESULT_SUCCESS;
	}
	
	/**
	 * This method to get Cab Details from database*
	 * @methodName updateCabDetails
	 * @param int
	 */
	
	@RequestMapping(value="/updateCabDetails/{uid}",method=RequestMethod.PUT)
	public String updateCabDetails(@PathVariable int uid, @RequestBody CabDetailsBO cabDetailsBO) {
		logger.info("CabServiceController : updateCabDetails : Started");
		try {
		cabService.updateCabDetails(uid,cabDetailsBO);
		logger.info("CabServiceController : updateCabDetails : Ended");
		} catch (TravelServiceException ex) {
			logger.error("CabServiceController : updateCabDetails : TravelServiceException Caught : " + ex);
			return TravelConstants.RESULT_FAIL;
		}
		return TravelConstants.RESULT_SUCCESS;
	}
}