package com.capco.travel.service;

import com.capco.travel.exception.CustomException;
import com.capco.travel.model.EmployeeDetailsBO;

public interface EmployeeDetailsService {
	 public EmployeeDetailsBO getPersonalDetailsById( String capcoUserId) throws CustomException;
}
