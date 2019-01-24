package com.capco.travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.travel.model.ForexDetailsBO;

/*
 * JPA repository to perform all crud operations in the database
 */

@Repository
public interface ForexDAO extends JpaRepository<ForexDetailsBO, Integer>{
	
	//public List<ForexDetailsBO> findByRequestedBy(Integer requestedBy);
	public ForexDetailsBO findByRequestId(Integer requestId);
}
