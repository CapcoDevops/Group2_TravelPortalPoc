package com.capco.travel.service;

import java.util.List;

import com.capco.travel.custom.exception.ForexNotFoundException;
import com.capco.travel.custom.exception.ForexServiceException;
import com.capco.travel.model.ForexDetailsBO;

public interface ForexService {

	public void insertForexDetails(ForexDetailsBO frxDetails) throws ForexServiceException;

	public ForexDetailsBO getForexDetails(Integer requestId) throws ForexServiceException, ForexNotFoundException;

	public void updateForexDetails(ForexDetailsBO forexDetailsBO) throws ForexServiceException, ForexNotFoundException;

	public void deleteForexDetails(Integer requestId) throws ForexServiceException, ForexNotFoundException;

	public List<ForexDetailsBO> getAllForexDetails() throws ForexServiceException, ForexNotFoundException;
	
	//public List<ForexDetailsBO> getForexDetailsByRequestedBy(Integer requestedBy) throws ForexServiceException, ForexNotFoundException;
}
