package com.capco.travel.visa.service;

import org.springframework.stereotype.Service;

import com.capco.travel.visa.model.VisaRequestBO;


@Service
public interface VisaService {

	public Boolean updateVisaDetails(int uid, VisaRequestBO newVisaDetails);
	
}
