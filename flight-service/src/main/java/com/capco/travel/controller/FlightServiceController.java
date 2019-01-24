package com.capco.travel.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.travel.custom.exception.TravelException.TravelServiceException;
import com.capco.travel.model.FlightDetailsBO;
import com.capco.travel.service.FlightService;
import com.capco.travel.util.TravelConstants;

@RestController

public class FlightServiceController {
	private static final Logger logger = Logger.getLogger(FlightServiceController.class);

	@Autowired
	FlightService flightServ;

	/**
	 * This method to add flight Details in database*
	 * 
	 * @methodName addFlightDetails
	 * @param com.capco.travel.model.FlightDetailsVO
	 */
	@RequestMapping(value = "/addFlightDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addFlightDetails(@RequestBody FlightDetailsBO flightDetailsBO) {
		logger.info("FlightServiceController : addFlightDetails : Started");

		try {
			flightServ.insertFlightDetails(flightDetailsBO);
		} catch (TravelServiceException ex) {
			logger.error("FlightServiceController : addFlightDetails : TravelServiceException Caught : " + ex);
			return TravelConstants.RESULT_FAIL;
		}
		return TravelConstants.RESULT_SUCCESS;

	}

	/**
	 * This method to get all flight Details from database*
	 * 
	 * @methodName getAllFlightDetails
	 * @param com.capco.travel.model.FlightDetailsVO
	 */
	@RequestMapping(value = "/getAllFlightDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<FlightDetailsBO> getEmpDetails() {
		logger.info("FlightServiceController : getAllProjectDetails : Started");
		List<FlightDetailsBO> flightListBO = new ArrayList<>();
		try {
			flightListBO = flightServ.getAllFlightsDetails();
			logger.info("FlightServiceController : getAllFlightDetails : Ended");
		} catch (TravelServiceException ex) {
			logger.error("FlightServiceController : getAllFlightDetails : TravelServiceException Caught : " + ex);
		}
		return flightListBO;
	}

	/**
	 * This method to get employee flight Details from database*
	 * 
	 * @methodName updateFlightDetails
	 * @param com.capco.travel.model.FlightDetailsVO
	 */
	/*@RequestMapping(value = "/updateFlightDetails/{uid}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateFlightDetails(@PathVariable int uid, @RequestBody FlightDetailsBO flightDetailsBO) {
		logger.info("FlightServiceController : updateFlightDetails : Started");
		try {
			flightServ.updateFlightDetails(uid, flightDetailsBO);
			logger.info("FlightServiceController : updateFlightDetails : Ended");
		} catch (TravelServiceException ex) {
			logger.error("FlightServiceController : updateFlightDetails : TravelServiceException Caught : " + ex);
			return TravelConstants.RESULT_FAIL;
		}
		return TravelConstants.RESULT_SUCCESS;
	}*/

	/**
	 * This method to get employee flight Details from database*
	 * 
	 * @methodName deleteFlightDetails
	 * @param int
	 *            id
	 */
	@RequestMapping(value = "/deleteFlightDetails/{requestId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteFlightDetails(@PathVariable int requestId) {

		logger.info("FlightServiceController : deleteFlightDetails : Started");
		try {
			flightServ.deletFlightDetails(requestId);
			logger.info("FlightServiceController : deleteFlightDetails : Ended");
		} catch (TravelServiceException ex) {
			logger.error("FlightServiceController : deleteFlightDetails : TravelServiceException Caught : " + ex);
			return TravelConstants.RESULT_FAIL;
		}
		return TravelConstants.RESULT_SUCCESS;

	}

	@RequestMapping(value="/getRequestById/{requestId}", method = RequestMethod.GET)
	public FlightDetailsBO getFlightRequestById(@PathVariable("requestId") int requestId) throws TravelServiceException
	{
		logger.info("FlightServiceController : deleteFlightDetails : Started");
		FlightDetailsBO flightDetailsBO = null;
		try {
			flightDetailsBO=flightServ.getRequestById(requestId);
			logger.info("FlightServiceController : deleteFlightDetails : Ended");
		} catch (TravelServiceException ex) {
			logger.error("FlightServiceController : deleteFlightDetails : TravelServiceException Caught : " + ex);
			throw new TravelServiceException(ex);
		}
		 return flightDetailsBO;
	}
}