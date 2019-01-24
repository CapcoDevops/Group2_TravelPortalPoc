package com.capco.travel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.travel.exception.CustomException;
import com.capco.travel.jpaRepo.EmployeeDetailsRepo;
import com.capco.travel.model.EmployeeDetailsBO;
import com.capco.travel.service.EmployeeDetailsService;
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	@Autowired
	private EmployeeDetailsRepo employeeDetailsRepo;

	@Override
	public EmployeeDetailsBO getPersonalDetailsById(String capcoUserId) throws CustomException {
		EmployeeDetailsBO employeeDetailsBO = employeeDetailsRepo.findOne(capcoUserId);
		if (employeeDetailsBO != null) {
			return employeeDetailsBO;
		}
		else {
			throw new CustomException("Employee does not exist.");
		}
		
	}

}
