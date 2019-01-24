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
import com.capco.travel.custom.exception.ForexControllerException;
import com.capco.travel.custom.exception.ForexNotFoundException;
import com.capco.travel.custom.exception.ForexServiceException;
import com.capco.travel.model.ForexDetailsBO;
import com.capco.travel.service.ForexService;

@RestController
public class ForexController {
	
	private static final Logger logger = Logger.getLogger(ForexController.class);
	
	@Autowired private ForexService forexService;
	
	HttpStatus statusCode;
	private static final String ERROR_MESSAGE = "Some error occurred.";

	@RequestMapping("/hello")
	public String sayhello() {
		return "hello";
	}
	
	/*@RequestMapping(value = "/getForexDetails/{requestId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ForexDetailsBO getForexDetails(@PathVariable Integer requestId) throws Exception {
		
		logger.info("ForexController : getForexDetails : Started");
		
		ForexDetailsBO forexsDetails = new ForexDetailsBO();
		try {
			
			if(requestId == null)
				throw new ForexControllerException("RequestId cannot be null.");
			forexsDetails = forexService.getForexDetails(requestId);
			
			statusCode = HttpStatus.OK;
			
		} catch(Exception e) {
			
			throw e;
		}
		catch (ForexNotFoundException e) {
			
			statusCode = HttpStatus.NOT_FOUND;
			
		} catch (ForexServiceException ex) {
			
			logger.error("ForexController : getForexDetails : ForexServiceException Caught : " + ex);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
		} catch(ForexControllerException e) {
			
			logger.error("ForexController : getAllForexDetails : Null Exception Caught : " + e);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		logger.info("ForexController : getForexDetails : Ended");
		
		return forexsDetails;
	}*/

	@RequestMapping(value = "/addForexDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addForex(@RequestBody ForexDetailsBO forexDetails) {
		
		logger.info("ForexController : addForex : Started");
		String message = "";
		
		try {
			if(forexDetails == null)
				throw new ForexControllerException("RequestId and forex details cannot be null.");
			forexService.insertForexDetails(forexDetails);
			statusCode = HttpStatus.OK;
			message = "Details saved successfully.";
			
		} catch (ForexServiceException ex) {
			
			logger.error("ForexController : addForex : ForexServiceException Caught : " + ex);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			message = ERROR_MESSAGE;
			
		} catch(ForexControllerException e) {
			
			logger.error("ForexController : addForex : Null Exception Caught : " + e);
			statusCode = HttpStatus.OK;
			message = e.getMessage();
		}
		
		logger.info("ForexController : addForex : Ended");
		
	}

	/*@RequestMapping(value = "/updateForexDetails", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<String> updateForexDetails(@RequestBody ForexDetailsBO forexDetailsBO) {
		
		logger.info("ForexController : updateForexDetails : Started");
		
		String message = "";
		
		try {
			if(forexDetailsBO == null)
				throw new ForexControllerException("RequestId and forex details cannot be null.");
			forexService.updateForexDetails(forexDetailsBO);
			statusCode = HttpStatus.OK;
			message = "details updated successfully";
			
		} catch (ForexNotFoundException e) {
			
			statusCode = HttpStatus.OK;
			message = e.getMessage();
			
		} catch (ForexServiceException ex) {
			
			logger.error("ForexController : updateForexDetails : ForexServiceException Caught : " + ex);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			message = ERROR_MESSAGE;
			
		} catch (ForexControllerException e) {
			
			logger.error("ForexController : updateForexDetails : Null Exception Caught : " + e);
			statusCode = HttpStatus.OK;
			message = e.getMessage();
		}
		
		logger.info("ForexController : updateForexDetails : Ended");
		return new ResponseEntity<>(message, statusCode);
	}
*/
	//@HystrixCommand(fallbackMethod = "reliable")
	/*@RequestMapping(value = "/deleteForexDetails/{requestId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteForexDetails(@PathVariable Integer requestId) {
		
		logger.info("ForexController : deleteForexDetails : Started");
		String message ="";
		try {
			if(requestId == null)
				throw new ForexControllerException("RequestId cannot be null.");
			forexService.deleteForexDetails(requestId);
			statusCode = HttpStatus.OK;
			message = "Request deleted successfully.";
			
			
		} catch (ForexNotFoundException e) {
			
			statusCode = HttpStatus.OK;
			message = e.getMessage();
			
		} catch (ForexServiceException ex) {
			
			logger.error("ForexController : deleteForexDetails : ForexServiceException Caught : " + ex);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			message = ERROR_MESSAGE;
			
		} catch (ForexControllerException e) {
			
			logger.error("ForexController : deleteForexDetails : Null Exception Caught : " + e);
			statusCode = HttpStatus.OK;
			message = e.getMessage();
		}
		
		logger.info("ForexController : deleteForexDetails : Ended");
		return new ResponseEntity<>(message, statusCode);
	}*/
	
	/*@RequestMapping(value = "/getForexDetailsByEmpId/{requestedBy}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Object> getForexDetailsByRequestedBy(@PathVariable Integer requestedBy) {
		
		logger.info("ForexController : getAllForexDetails : Started");
		
		
		List<ForexDetailsBO> forexList = null;
		String message = "";
		try {
			
			forexList = forexService.getForexDetailsByRequestedBy(requestedBy);
			statusCode = HttpStatus.OK;
			
			logger.info("ForexController : getForexDetailsByRequestedBy : Ended");
			
			return new ResponseEntity<>(forexList,statusCode);
			
		} catch (ForexNotFoundException e) {
			
			message = e.getMessage();
			statusCode = HttpStatus.OK;
			return new ResponseEntity<>(message,statusCode);
			
		} catch (ForexServiceException ex) {
			
			logger.error("ForexController : getForexDetailsByRequestedBy : ForexServiceException Caught : " + ex);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			message = "some error occurred";
			
			return new ResponseEntity<>(message,statusCode);
			
		} 
		
	}*/
	
	@RequestMapping(value = "/getAllForexDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Object> getAllForexDetails() {
		
		logger.info("ForexController : getAllForexDetails : Started");
		
		
		List<ForexDetailsBO> forexList = null;
		String message = "";
		try {
			
			forexList = forexService.getAllForexDetails();
			statusCode = HttpStatus.OK;
			
			logger.info("ForexController : getAllForexDetails : Ended");
			
			return new ResponseEntity<>(forexList,statusCode);
			
		} catch (ForexNotFoundException e) {
			
			message = e.getMessage();
			statusCode = HttpStatus.OK;
			return new ResponseEntity<>(message,statusCode);
			
		} catch (ForexServiceException ex) {
			
			logger.error("ForexController : getAllForexDetails : ForexServiceException Caught : " + ex);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			message = "some error occurred";
			
			return new ResponseEntity<>(message,statusCode);
			
		} 
		
	}
	
}
