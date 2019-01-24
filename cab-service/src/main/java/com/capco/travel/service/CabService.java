package com.capco.travel.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capco.travel.custom.exception.TravelException.TravelServiceException;
import com.capco.travel.model.CabDetailsBO;
import com.capco.travel.repo.CabServiceRepository;

@Service
public class CabService {
	private static final Logger logger = Logger.getLogger(CabService.class);
	
	@Autowired
	CabServiceRepository cabServiceRepository;
	
	/**
	 * This method to add Cab Details into database*
	 * 
	 * @methodName addCabDetails
	 * @param com.capco.travel.model.CabDetailsBO
	 * @throws com.capco.travel.custom.exception.TravelException.TravelException
	 */
	
	
	public void addCabDetails(CabDetailsBO cabDetailsBO) throws TravelServiceException {
		logger.info("CabService : addCabDetails: Started");
		try {
		cabServiceRepository.save(cabDetailsBO);
		logger.info("CabService : addCabDetails: Ended");
		} catch (Exception e) {
			logger.error("CabSerice : addCabDetails: Exception Caught: " + e);
			throw new TravelServiceException(e);
		}
	}
	
	/**
	 * This method to get Cab Details into database*
	 * 
	 * @methodName getCabDetails
	 * @param com.capco.travel.model.CabDetailsBO
	 * @throws com.capco.travel.custom.exception.TravelException.TravelException
	 */
	
	public List<CabDetailsBO> getCabDetails() throws TravelServiceException{
		logger.info("CabService : getCabDetails: Started");
		List<CabDetailsBO> cabDetailsList = null;
		try {
		cabDetailsList = new ArrayList<>();
		cabServiceRepository.findAll().forEach(cabDetailsList::add);
		logger.info("CabService : getCabDetails: Ended");
		} catch (Exception e) {
			logger.error("CabService : getCabDetails: Exception Caught: " + e);
			throw new TravelServiceException(e);
		}
		return cabDetailsList;
	}
	
	/**
	 * This method to delete Cab Details into database*
	 * 
	 * @methodName deleteCabDetails
	 * @param com.capco.travel.model.CabDetailsBO
	 * @throws com.capco.travel.custom.exception.TravelException.TravelException
	 */

	public void deleteCabDetails(int uid) throws TravelServiceException {
		logger.info("CabService : deleteCabDetails: Started");
		try {
			cabServiceRepository.delete(uid);
			logger.info("CabService : deleteCabDetails: Ended");
		} catch (Exception e) {
			logger.error("CabService : deleteCabDetails: Exception Caught: " + e);
			throw new TravelServiceException(e);
		}
		
	}

	public void updateCabDetails(int uid, CabDetailsBO cabDetailsBO) throws TravelServiceException {
		
		logger.info("CabService : updateCabDetails: Started");
		try {
			cabServiceRepository.save(cabDetailsBO);
			logger.info("CabService : updateCabDetails: Ended");
		} catch (Exception e) {
			logger.error("CabService : updateCabDetails: Exception Caught: " + e);
			throw new TravelServiceException(e);
		}
		
	}
	
	public CabDetailsBO getCabDetails(int requestId) throws TravelServiceException {
		logger.info("CabService : updateCabDetails: Started");
		CabDetailsBO cabDetails = null;
		try {
			cabDetails=cabServiceRepository.findOne(requestId);
			logger.info("CabService : getCabDetails: Ended");
		}catch(Exception e) {
			logger.error("CabService : getCabDetails: Exception Caught: " + e);
			throw new TravelServiceException(e);
		}
		return cabDetails;
	}
	

}
