package com.capco.travel.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.travel.model.MainRequestBO;

@Repository
public interface mainRequestRepo extends JpaRepository<MainRequestBO, Integer>{

	List<MainRequestBO> findByRequestedBy(int requestedBy);
	MainRequestBO findByRequestId(int requestId);
}
