package com.capco.travel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capco.travel.model.FlightDetailsBO;

@Repository
public interface FlightDetailsRepository extends CrudRepository<FlightDetailsBO, Integer> {
	
	public FlightDetailsBO findByRequestId(int requestId);
	

}
