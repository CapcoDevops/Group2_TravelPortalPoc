package com.capco.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capco.travel.model.AccomodationDetailsBO;

public interface AccomodationRepository extends JpaRepository<AccomodationDetailsBO, Long> {

	AccomodationDetailsBO findByUid(int requestId);

	
	
	

}
