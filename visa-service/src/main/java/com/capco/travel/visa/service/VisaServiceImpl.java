package com.capco.travel.visa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.travel.visa.model.VisaRequestBO;
import com.capco.travel.visa.repository.VisaRepository;

@Service
public class VisaServiceImpl implements VisaService{

	
	VisaRequestBO visa;
	
	@Autowired
	VisaRepository visaRepo;

	@Override
	public Boolean updateVisaDetails(int uid, VisaRequestBO newVisaDetails) {
		
		visa = visaRepo.findByRequestId(uid);
		if(visa==null) {
			return false;
		}
		
		//visa.setUid(newVisaDetails.getUid());
		visa.setBusinessPurpose(newVisaDetails.getBusinessPurpose());
		visa.setCollectionDesk(newVisaDetails.getCollectionDesk());
		visa.setCreatedOn(newVisaDetails.getCreatedOn());
		visa.setIsActive(newVisaDetails.getIsActive());
		visa.setModifiedOn(newVisaDetails.getModifiedOn());
		visa.setTravelDestination(newVisaDetails.getTravelDestination());
		visa.setTypeOfVisit(newVisaDetails.getTypeOfVisit());
		visa.setVisaRemarks(newVisaDetails.getVisaRemarks());
		visa.setVisaType(newVisaDetails.getVisaType());
		
		visaRepo.save(visa);
		
		return true;
	}

	
}
