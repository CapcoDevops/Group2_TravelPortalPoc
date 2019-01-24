package com.capco.travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.travel.exceptions.BaseException;
import com.capco.travel.model.AccomodationDetailsBO;
import com.capco.travel.repository.AccomodationRepository;
import com.capco.travel.service.AccommodationService;
@Service
public class AccommodationServiceImpl implements AccommodationService
{
	@Autowired
    private AccomodationRepository accomodationRepo;
	@Override
	public AccomodationDetailsBO getAccomodationDetails(int requestId) throws BaseException {
		 AccomodationDetailsBO accomodationDetails=accomodationRepo.findByUid(requestId);
		 if(accomodationDetails!=null) {
			 return accomodationDetails;
		 }else {
			 throw new BaseException("Accomodation Details does not exist.");
		 }
	}
	@Override
	public AccomodationDetailsBO addAccomodationDetails(AccomodationDetailsBO accomodationDetails) throws BaseException {
		AccomodationDetailsBO accomodationInsert = accomodationRepo.save(accomodationDetails);
		if(accomodationInsert!=null)
		{
		return accomodationInsert;
	}else{
		throw new BaseException("Cannot Insert Accomodation data.");
	}
	}
	@Override
	public AccomodationDetailsBO updateAccomodationDetails(int requestId,AccomodationDetailsBO newaccomodationDetailsBO) throws BaseException {
		 AccomodationDetailsBO accomodationDetailsBO=accomodationRepo.findByUid(requestId);
		 accomodationDetailsBO.setBudget(newaccomodationDetailsBO.getBudget());
		 accomodationDetailsBO.setBusinessPurpose(newaccomodationDetailsBO.getBudget());
		 accomodationDetailsBO.setCategory(newaccomodationDetailsBO.getCategory());
		 accomodationDetailsBO.setCheckIn(newaccomodationDetailsBO.getCheckIn());
		 accomodationDetailsBO.setCheckOut(newaccomodationDetailsBO.getCheckOut());
		 accomodationDetailsBO.setCity(newaccomodationDetailsBO.getCity());
		 accomodationDetailsBO.setCountry(newaccomodationDetailsBO.getCountry());
		 accomodationDetailsBO.setCreatedOn(newaccomodationDetailsBO.getCreatedOn());
		 accomodationDetailsBO.setCurrency(newaccomodationDetailsBO.getCurrency());
		 accomodationDetailsBO.setIsActive(newaccomodationDetailsBO.getIsActive());
		 accomodationDetailsBO.setRemarks(newaccomodationDetailsBO.getRemarks());
		 accomodationDetailsBO.setModifiedOn(newaccomodationDetailsBO.getModifiedOn());
		 AccomodationDetailsBO accomodationInsert = accomodationRepo.save(accomodationDetailsBO);
		 if(accomodationInsert!=null)
			{
			return accomodationInsert;
		}else{
			throw new BaseException("Cannot Insert Accomodation data.");
		}
	
	}
	@Override
	public List<AccomodationDetailsBO> getAllAccomodationDetails() throws BaseException {
		List<AccomodationDetailsBO> accomodationDetails =accomodationDetails =  accomodationRepo.findAll();
		if(accomodationDetails!=null)
		{
		return accomodationDetails;
	}else{
		throw new BaseException("Cannot Insert Accomodation data.");
	}
		
		
	}
	@Override
	public AccomodationDetailsBO deleteAccomodationDetails(int requestId) throws BaseException {
		 AccomodationDetailsBO accomodationDetails=accomodationRepo.findByUid(requestId);
		 
		 accomodationRepo.delete(accomodationDetails);
		return accomodationDetails;
		
	}
}