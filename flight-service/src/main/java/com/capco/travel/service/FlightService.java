package com.capco.travel.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.travel.custom.exception.TravelException.TravelServiceException;
import com.capco.travel.model.FlightDetailsBO;
import com.capco.travel.repository.FlightDetailsRepository;

@Service
public class FlightService {

	private static final Logger logger = Logger.getLogger(FlightService.class);
	@Autowired
	FlightDetailsRepository flightRepo;

	/**
	 * This method to add flight Details into database*
	 * 
	 * @methodName insertFlightDetails
	 * @param com.capco.travel.model.FlightDetailsVO
	 * @throws com.capco.travel.custom.exception.TravelException.TravelServiceException
	 */
	public void insertFlightDetails(FlightDetailsBO flightDetailsBO) throws TravelServiceException {

		logger.info("FlightService : insertFlightDetails: Started");

		try {
			flightRepo.save(flightDetailsBO);
			logger.info("FlightService : insertFlightDetails: Ended");
		} catch (Exception ex) {
			logger.error("FlightService : insertFlightDetails: Exception Caught: " + ex);
			throw new TravelServiceException(ex);
		}

	}

	/**
	 * This method to get all flight Details from database*
	 * 
	 * @methodName getAllFlightsDetails
	 * @throws com.capco.travel.custom.exception.TravelException.TravelServiceException
	 */
	public List<FlightDetailsBO> getAllFlightsDetails() throws TravelServiceException {

		logger.info("FlightServiceImpl : getAllFlightsDetails: Started");
		List<FlightDetailsBO> flightList = new ArrayList<>();
		try {

			flightRepo.findAll().forEach(flightList::add);
		} catch (Exception ex) {
			logger.error("FlightService : getAllFlightsDetails: Exception Caught: " + ex);
			throw new TravelServiceException(ex);
		}

		return flightList;
	}

	/**
	 * This method to update flight Details *
	 * 
	 * @methodName updateFlightDetails
	 * @param com.capco.travel.model.FlightDetailsVO
	 * @throws com.capco.travel.custom.exception.TravelException.TravelServiceException
	 */

	public void updateFlightDetails(int uid, FlightDetailsBO flightDetailsBO) throws TravelServiceException {
		logger.info("FlightService : deleteFlightDetails: Started");
		try {
			flightRepo.save(flightDetailsBO);
			logger.info("FlightService : deletFlightDetails: Ended");
		} catch (Exception ex) {
			logger.error("FlightService : getAllFlightsDetails: Exception Caught: " + ex);
			throw new TravelServiceException(ex);
		}

	}

	/**
	 * This method to delete flight Details *
	 * 
	 * @methodName deletFlightDetails
	 * @param int
	 *            requestId
	 * @throws com.capco.travel.custom.exception.TravelException.TravelServiceException
	 */
	public void deletFlightDetails(int uid) throws TravelServiceException {

		logger.info("FlightServiceImpl : deletFlightDetails: Started");
		try {
			flightRepo.delete(uid);
			logger.info("FlightService : deletFlightDetails: Ended");
		} catch (Exception ex) {
			logger.error("FlightService : deletFlightDetails: Exception Caught: " + ex);
			throw new TravelServiceException(ex);
		}

	}

	/**
	 * This method to getRequestById flight Details *
	 * 
	 * @methodName deletFlightDetails
	 * @param int
	 *            requestId
	 * @throws com.capco.travel.custom.exception.TravelException.TravelServiceException
	 */
	public FlightDetailsBO getRequestById(int requestId) throws TravelServiceException
	{
		FlightDetailsBO flightDetailsBO=null;
		logger.info("FlightServiceImpl : deletFlightDetails: Started");
		try {
				 flightDetailsBO=flightRepo.findByRequestId(requestId);
			logger.info("FlightService : deletFlightDetails: Ended");
		} catch (Exception ex) {
			logger.error("FlightService : deletFlightDetails: Exception Caught: " + ex);
			throw new TravelServiceException(ex);
		}
		return flightDetailsBO;
	}
}
