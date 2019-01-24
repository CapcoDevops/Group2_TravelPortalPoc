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
import com.capco.travel.client.AccomodationClient;
import com.capco.travel.client.AccountClient;
import com.capco.travel.client.CabClient;
import com.capco.travel.client.FlightClient;
import com.capco.travel.client.ForexClient;
import com.capco.travel.client.VisaClient;
import com.capco.travel.model.AccomodationDetailsBO;
import com.capco.travel.model.Account;
import com.capco.travel.model.CabDetailsBO;
import com.capco.travel.model.FlightDetailsBO;
import com.capco.travel.model.ForexDetailsBO;
import com.capco.travel.model.MainRequestBO;
import com.capco.travel.model.ResponseObject;
import com.capco.travel.model.VisaRequestBO;
import com.capco.travel.repository.mainRequestRepo;
import com.capco.travel.service.MainRequestServiceInterface;

/*This is a main Controller
Class name MainRequestController
created by Rafik Pinjari*/

@RestController
public class MainRequestController {
	
	private static final Logger logger = Logger.getLogger(MainRequestController.class);

	@Autowired
	private AccountClient accountClient;
	
	@Autowired
	private VisaClient visaClient;
	
	@Autowired
	private FlightClient flightClient;
	
	@Autowired
	private AccomodationClient accommodationClient;
	
	@Autowired
	private CabClient cabClient;
	
	@Autowired
	private ForexClient forexClient;
	
	
	@Autowired
	private mainRequestRepo mainRequestRepo;
	
	@Autowired
	private MainRequestServiceInterface mainServiceInterface;
	
	
	/*account client services*/
	
	@RequestMapping("/getAllAccounts")
	public List<Account> getAllAccounts(){
		return accountClient.getAllAccounts();
	}
	
/*	This is used to raise a new request 
	Method name addMainRequest
	Method Type : Post
	return ResponseObject
	created by Rafik Pinjari
	*/
	
	@RequestMapping(value = "/request", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ResponseObject> addMainRequest(@RequestBody MainRequestBO mainRequestBO)
	{
		logger.info("MainRequestController : addMainRequest : started..");
				
			if(mainRequestBO!=null)
			{
				try
				{
					int requestId=mainServiceInterface.generateRandomRequestId();
					
					MainRequestBO mainTable=new MainRequestBO();
					
					mainTable.setRequestId(requestId);
					mainRequestBO.setRequestId(requestId);
				
					logger.info("MainRequestController : addMainRequest : request id "+requestId);
					
					
					if(mainRequestBO.getRequestedBy()!=null)
					{
						mainTable.setRequestedBy(mainRequestBO.getRequestedBy());
					}
					if(mainRequestBO.getRequestedFor()!=null)
					{
						mainTable.setRequestedFor(mainRequestBO.getRequestedFor());
					}
					if(mainRequestBO.getCurrentStatus()!=null)
					{
						mainTable.setCurrentStatus(mainRequestBO.getCurrentStatus());
					}
					if(mainRequestBO.getCreatedOn()!=null)
					{
						mainTable.setCreatedOn(mainRequestBO.getCreatedOn());
					}
					if(mainRequestBO.getModifiedOn()!=null)
					{
						mainTable.setModifiedOn(mainRequestBO.getModifiedOn());
					}
					if(mainRequestBO.getApproverId()!=null)
					{
						mainTable.setApproverId(mainRequestBO.getApproverId());
					}
					if(mainRequestBO.getBillable()!=null)
					{
						mainTable.setBillable(mainRequestBO.getBillable());
					}
					if(mainRequestBO.getRequestType()!=null)
					{
						mainTable.setRequestType(mainRequestBO.getRequestType());
					}
					if(mainRequestBO.getProjectCode()!=null)
					{
						mainTable.setProjectCode(mainRequestBO.getProjectCode());
					}
					if(mainRequestBO.getProjectName()!=null)
					{
						mainTable.setProjectName(mainRequestBO.getProjectName());
					}
					if(mainRequestBO.getRemark()!=null)
					{
						mainTable.setRemark(mainRequestBO.getRemark());
					}
					if(mainRequestBO.getCabDetailsBO()!=null)
					{
						mainTable.setCabStatus("YES");
						CabDetailsBO cabDetailsBO=mainRequestBO.getCabDetailsBO();
						cabDetailsBO.setRequestId(mainRequestBO.getRequestId());
						logger.info("MainRequestController : addMainRequest : getCabDetailsBO: "+cabDetailsBO.getRequestId());
						
						cabClient.addCabDetails(cabDetailsBO);		
					}
					else
					{
						mainTable.setCabStatus("NO");
					}
				   if(mainRequestBO.getFlightDetailsBO()!=null)
					{
					   mainTable.setFlightStatus("YES");
						FlightDetailsBO flight=mainRequestBO.getFlightDetailsBO();
						flight.setRequestId(mainRequestBO.getRequestId());
						logger.info("MainRequestController : addMainRequest : getFlightDetailsBO: "+flight.getRequestId());
						flightClient.addFlightDetails(flight);
					}    
					else
					{
						mainTable.setFlightStatus("NO");
				    }

				 
					if(mainRequestBO.getVisaRequestBO()!=null)
					{
						mainTable.setVisaStatus("YES");			
						VisaRequestBO visaRequestBO=mainRequestBO.getVisaRequestBO();
						visaRequestBO.setRequestId(mainRequestBO.getRequestId());
						logger.info("MainRequestController : addMainRequest : getVisaRequestBO: "+visaRequestBO.getRequestId());
						visaClient.addVisa(visaRequestBO);
					}
					else
					{
						mainTable.setVisaStatus("NO");
					}

					if(mainRequestBO.getAccomoDetailsBO()!=null)
					{
						mainTable.setAccommodationStatus("YES");
						AccomodationDetailsBO accomoDetailsBO=mainRequestBO.getAccomoDetailsBO();
						accomoDetailsBO.setRequestId(mainRequestBO.getRequestId());
						logger.info("MainRequestController : addMainRequest : getAccomoDetailsBO: "+accomoDetailsBO.getRequestId());
						accommodationClient.addAccomodationDetails(accomoDetailsBO);
						
					}
					else
					{
						mainTable.setAccommodationStatus("NO");
					}
					
					if(mainRequestBO.getForexDetailsBO()!=null)
					{
						mainTable.setForexStatus("Yes");
						ForexDetailsBO forexDetailsBO=mainRequestBO.getForexDetailsBO();
						forexDetailsBO.setRequestId(mainRequestBO.getRequestId());
						logger.info("MainRequestController : addMainRequest : getForexDetailsBO: "+forexDetailsBO.getRequestId());
						forexClient.addForex(forexDetailsBO);
						
					}
					else
					{
						mainTable.setForexStatus("NO");
					}
					
					mainRequestRepo.save(mainTable);
					ResponseObject res=new ResponseObject();
					res.setMessage("success");
					res.setStatusCode("200");
					return new ResponseEntity<ResponseObject>(res,HttpStatus.OK);
						
				}
				catch(Exception e)
				{
					logger.error("MainRequestController : addMainRequest : exception caught.."+ e);
				}
			}
			else
			{
				ResponseObject res=new ResponseObject();
				res.setStatusCode("400");
				res.setMessage("bad request");
				return new ResponseEntity<ResponseObject>(res,HttpStatus.BAD_REQUEST);
			}
			logger.info("MainRequestController : addMainRequest : ended..");	
		return new ResponseEntity<ResponseObject>(HttpStatus.BAD_REQUEST);
		
	}
	
	/*
	This is used to get all request by employee id 
	Method name : getAllRequestDetailsByEmployeeId 
	Method Type : Get
	Parameter : int requestedBy
	return : MainRequestBO
	created by Rafik Pinjari
	*/
	@RequestMapping(value="/getAllRequest/{requestedBy}",method=RequestMethod.GET)
	public ResponseEntity<List<MainRequestBO>> getAllRequestDetailsByEmployeeId(@PathVariable ("requestedBy") int requestedBy)
	{
		logger.info("MainRequestController : getAllRequestDetails : started..");
		List<MainRequestBO> mainRequestBO = null;
		try
		{
			mainRequestBO= mainRequestRepo.findByRequestedBy(requestedBy);
		}
		catch(Exception e)
		{
			logger.error("MainRequestController : getAllRequestDetails : exception caught.."+ e);
		}
		
		logger.info("MainRequestController : getAllRequestDetails : ended..");
		return new ResponseEntity<List<MainRequestBO>>(mainRequestBO,HttpStatus.OK);
		
	}
	
	/*
	This is used to get specific request by request id 
	Method name : getRequestByRequestId 
	Method Type : Get
	Parameter : int requestId
	return : MainRequestBO
	created by Rafik Pinjari
	*/
	@RequestMapping(value="/getRequestById/{requestId}",method=RequestMethod.GET)
	public ResponseEntity<MainRequestBO> getRequestByRequestId(@PathVariable("requestId") int requestId)
	{
		logger.error("MainRequestController : getAllRequestDetails : started..");
		
		
		MainRequestBO mainRequestBO=mainRequestRepo.findByRequestId(requestId);
		if(mainRequestBO!=null)
		{
			/*try
			{
				VisaRequestBO visaRequestBO=visaClient.getvisaDetails(requestId);
				System.out.println("visa request Bo -------------------"+visaRequestBO);
				mainRequestBO.setVisaRequestBO(visaRequestBO);
				
			}
			catch(Exception e)
			{
				System.out.println("visa exception  "+e);
			}
			
			try
			{
				CabDetailsBO cabDetailsBO=cabClient.getCabDetailsById(requestId);
				mainRequestBO.setCabDetailsBO(cabDetailsBO);
				System.out.println("forex request id9999999            "+requestId);
			}
			catch(Exception e)
			{
				System.out.println("cab ex"+e);
			}*/
			try
			{
				AccomodationDetailsBO accomodationDetailsBO=accommodationClient.getAccomodationDetails(requestId);
				mainRequestBO.setAccomoDetailsBO(accomodationDetailsBO);
			}
			catch(Exception e)
			{
				System.out.println("accommodation ex"+e);
			}
			
			/*try
			{
				FlightDetailsBO flightDetailsBO=flightClient.getFlightRequestById(requestId);
				mainRequestBO.setFlightDetailsBO(flightDetailsBO);
			}
			catch(Exception e)
			{
				System.out.println("flight ex"+e);
			}*/
			
			/*ForexDetailsBO forexDetailsBO=forexClient.getForexDetails(requestId);
			mainRequestBO.setForexDetailsBO(forexDetailsBO);*/
			
			
			
		}
		
		
		return new ResponseEntity<MainRequestBO>(mainRequestBO,HttpStatus.OK);
	}
	
	
	/*
	This is used to cancel the request 
	Method name : cancelMainRequest 
	Method Type : POST
	Parameter : int requestId
	created by Rafik Pinjari
	*/
	
	@RequestMapping(value="/cancel/{requestId}",method=RequestMethod.POST)
	public String cancelMainRequest(@PathVariable ("requestId") int requestId)
	{
		MainRequestBO mainRequestBO = null;
		mainRequestBO= mainRequestRepo.findByRequestId(requestId);
		
		mainRequestBO.setCurrentStatus("Cancelled");
		
		mainRequestRepo.save(mainRequestBO);
		
		return "";
	}
	
	/*@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateMainRequest(@RequestBody MainRequestBO mainRequestBO)
	{
		Integer requestId=mainRequestBO.getRequestId();
		if(mainRequestBO.getCabDetailsBO()!=null)
		{
				
		}
		if(mainRequestBO.getFlightDetailsBO()!=null)
		{
			FlightDetailsBO flight=mainRequestBO.getFlightDetailsBO();
			flightClient.updateFlightDetails(requestId, flight);
		}
		if(mainRequestBO.getVisaRequestBO()!=null)
		{
			VisaRequestBO visaRequestBO=mainRequestBO.getVisaRequestBO();
			visaClient.updatevisaDetails(visaRequestBO);
		}
		if(mainRequestBO.getAccomoDetailsBO()!=null)
		{
		
			AccomodationDetailsBO accommodation=mainRequestBO.getAccomoDetailsBO();
			accommodationClient.updateAccomodationDetails(requestId, accommodation);
		}
		
		if(mainRequestBO.getForexDetailsBO()!=null)
		{
			ForexDetailsVO vo
		}
		
		return "";
	}*/

	

}
