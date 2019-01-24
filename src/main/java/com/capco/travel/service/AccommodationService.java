package com.capco.travel.service;

import java.util.List;

import com.capco.travel.exceptions.BaseException;
import com.capco.travel.model.AccomodationDetailsBO;

public interface AccommodationService {
	public AccomodationDetailsBO getAccomodationDetails( int requestId) throws BaseException;
	
	public AccomodationDetailsBO addAccomodationDetails(AccomodationDetailsBO accomodationDetails) throws BaseException;

	public AccomodationDetailsBO updateAccomodationDetails( int requestId,AccomodationDetailsBO newaccomodationDetailsBO) throws BaseException;

	public List<AccomodationDetailsBO> getAllAccomodationDetails() throws BaseException;
	
	public AccomodationDetailsBO deleteAccomodationDetails(int requestId) throws BaseException;
}
