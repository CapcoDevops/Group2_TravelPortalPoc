package com.capco.travel.visa.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capco.travel.visa.model.VisaRequestBO;


@Repository
public interface VisaRepository extends CrudRepository<VisaRequestBO, Integer>{
	
	public VisaRequestBO findByRequestId(int requestId);

}
