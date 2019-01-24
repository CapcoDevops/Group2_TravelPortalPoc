package com.capco.travel.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capco.travel.custom.exception.ForexNotFoundException;
import com.capco.travel.custom.exception.ForexServiceException;
import com.capco.travel.dao.ForexDAO;
import com.capco.travel.model.ForexDetailsBO;

@Transactional
@Service
public class ForexServiceImpl implements ForexService {
	private static final Logger logger = Logger.getLogger(ForexServiceImpl.class);
	
	@Autowired ForexDAO forexDao;

	@Override
	public ForexDetailsBO getForexDetails(Integer requestId) throws ForexServiceException, ForexNotFoundException {
		
		logger.info("ForexServiceImpl : getForexDetails: Started");
		ForexDetailsBO forexDetailsBO = null;
		try {
			forexDetailsBO = forexDao.findByRequestId(requestId);
			if (forexDetailsBO == null || !forexDetailsBO.getIsActive()) 
				throw new ForexNotFoundException("No forex details found for the requested ID.");
				
			logger.info("ForexServiceImpl : getForexDetails: Ended");
			
		} catch (ForexNotFoundException ex) {
			ex.printStackTrace();
			logger.error("ForexServiceImpl : getForexDetails: ForexNotFoundException Caught: " + ex);
			throw ex;
			
		} catch (Exception ex) {
			
			logger.error("ForexServiceImpl : getForexDetails: DAOException Caught: " + ex);
			
			throw new ForexServiceException(ex);
		}
		return forexDetailsBO;
	}

	@Override
	public void insertForexDetails(ForexDetailsBO forexDetails) throws ForexServiceException {
		
		logger.info("ForexServiceImpl : insertForexDetails: Started");
		try {
			
			forexDetails.setCreatedOn(new Date());
			forexDao.save(forexDetails);
			
			logger.info("ForexServiceImpl : insertForexDetails: Ended");
			
			
		} catch (Exception ex) {
			
			logger.error("ForexServiceImpl : insertForexDetails: DAOException Caught: " + ex);
			throw new ForexServiceException(ex);
		}
	}
	
	@Override
	public void updateForexDetails(ForexDetailsBO forexDetailsBO) throws ForexServiceException, ForexNotFoundException {
		
		logger.info("ForexServiceImpl : updateForexDetails: Started");
		try {
			
			ForexDetailsBO forex = forexDao.findOne(forexDetailsBO.getRequestId());
			
			if(forex==null || !forex.getIsActive())
				throw new ForexNotFoundException("No forexdetails found matching to the requested ID.");
			forexDetailsBO.setModifiedOn(new Date());
			forexDetailsBO.setCreatedOn(forex.getCreatedOn());
			forexDao.save(forexDetailsBO);
			
			logger.info("ForexServiceImpl : updateForexDetails: Ended");
			
		} catch (ForexNotFoundException ex) {
			logger.error("ForexServiceImpl : updateForexDetails: ForexNotFoundException Caught: " + ex);
			throw ex;
		} catch (Exception ex) {
			logger.error("ForexServiceImpl : updateForexDetails: DAOException Caught: " + ex);
			throw new ForexServiceException(ex);
		}
	}

	@Override
	public void deleteForexDetails(Integer requestId) throws ForexServiceException, ForexNotFoundException {
		
		logger.info("ForexServiceImpl : deleteForexDetails: Started");
		try {
			ForexDetailsBO forexDetailsBO = forexDao.findOne(requestId);
			
			if(forexDetailsBO==null || !forexDetailsBO.getIsActive())
				throw new ForexNotFoundException("No forex details found for the requested ID.");
			else
			{
				forexDetailsBO.setIsActive(false);
				forexDao.save(forexDetailsBO);
			}
			
			logger.info("ForexServiceImpl : deleteForexDetails: Ended");
			
		} catch (ForexNotFoundException ex) {
			
			logger.error("ForexServiceImpl : deleteForexDetails: ForexNotFoundException Caught: " + ex);
			throw ex;
			
		} catch (Exception ex) {
			logger.error("ForexServiceImpl : deleteForexDetails: DAOException Caught: " + ex);
			throw new ForexServiceException(ex);
		}
	}

	@Override
	public List<ForexDetailsBO> getAllForexDetails() throws ForexServiceException, ForexNotFoundException {
		
		logger.info("ForexServiceImpl : getAllForexDetails: Started");
		
		List<ForexDetailsBO> forexDetailsBOList = null;
		try {
			
			forexDetailsBOList = forexDao.findAll();
			if (forexDetailsBOList.isEmpty()) 
				throw new ForexNotFoundException("No records found.");
			
			logger.info("ForexServiceImpl : getAllForexDetails: Ended");
			
		} catch (ForexNotFoundException ex) {
			
			logger.error("ForexServiceImpl : getAllForexDetails: ForexNotFoundException Caught: " + ex);
			throw ex;
			
		} catch (Exception ex) {
			
			logger.error("ForexServiceImpl : getAllForexDetails: DAOException Caught: " + ex);
			throw new ForexServiceException(ex);
		}
		return forexDetailsBOList;
	}

	/*@Override
	public List<ForexDetailsBO> getForexDetailsByRequestedBy(Integer requestedBy) throws ForexServiceException, ForexNotFoundException {
		
		logger.info("ForexServiceImpl : getAllForexDetails: Started");
		
		List<ForexDetailsBO> forexDetailsBOList = null;
		try {
			
			forexDetailsBOList = forexDao.findByRequestedBy(requestedBy);
			if (forexDetailsBOList.isEmpty()) 
				throw new ForexNotFoundException("No records found.");
			
			logger.info("ForexServiceImpl : getForexDetailsByRequestedBy: Ended");
			
		} catch (ForexNotFoundException ex) {
			
			logger.error("ForexServiceImpl : getAllForexDetails: ForexNotFoundException Caught: " + ex);
			throw ex;
			
		} catch (Exception ex) {
			
			logger.error("ForexServiceImpl : getAllForexDetails: DAOException Caught: " + ex);
			throw new ForexServiceException(ex);
		}
		return forexDetailsBOList;
	}
*/
}
