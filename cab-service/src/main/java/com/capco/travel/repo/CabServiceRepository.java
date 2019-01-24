package com.capco.travel.repo;

import org.springframework.data.repository.CrudRepository;

import com.capco.travel.model.CabDetailsBO;

public interface CabServiceRepository extends CrudRepository<CabDetailsBO, Integer> {

}
