package com.capco.travel.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capco.travel.model.EmployeeDetailsBO;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetailsBO, String> {

	EmployeeDetailsBO findOne(String capcoUserId);
  
}
