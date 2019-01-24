package com.capco.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.travel.client.PersonalDetailsClient;
import com.capco.travel.model.EmployeeDetailsBO;
import com.capco.travel.model.LoginDTO;
import com.capco.travel.model.LoginDetailsBO;
import com.capco.travel.model.Status;
import com.capco.travel.repo.LoginRepo;

@RestController
@ComponentScan("com.capco.travel.client")
public class LoginController {
	@Autowired
	 PersonalDetailsClient loginClient;
   @Autowired
   private LoginRepo loginRepo;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDetailsBO loginDetailsBO) 
	{
		System.out.println("login controller : login : started...");
		EmployeeDetailsBO empDetails=null;
		LoginDTO loginDTO=new LoginDTO();
		Status status=new Status();
		try
		{
			LoginDetailsBO loginDetailsBO2 = loginRepo.findBycapcoUserId(loginDetailsBO.getCapcoUserId());
			System.out.println("loginDetailsBO2 details ......"+loginDetailsBO2);
			Boolean userStatus=loginDetailsBO2.getIsActive();
			System.out.println("login status..."+userStatus);
			if(loginDetailsBO2!=null && userStatus!=false)
			{
				if(loginDetailsBO2.getPassword().equals(loginDetailsBO.getPassword()))
					try
					{
						 //empDetails=loginClient.getPersonalDetailsById(loginDetailsBO.getCapcoUserId());
						empDetails=loginClient.getPersonalDetailsById(loginDetailsBO.getCapcoUserId());
						
						loginDTO.setEmployeDetailsBO(empDetails);
						status.setMessage("login success");
						status.setCode("200");
						loginDTO.setStatus(status);
						return new ResponseEntity<LoginDTO>(loginDTO,HttpStatus.OK);
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				
			}
			else 
			{
				status.setMessage("Not registered user");
				status.setCode("404");
				loginDTO.setStatus(status);
				return new ResponseEntity<LoginDTO>(loginDTO,HttpStatus.NOT_FOUND);
			}
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		status.setMessage("login failed");
		status.setCode("400");
		loginDTO.setStatus(status);
		System.out.println("login controller : login : ended...");
		return new ResponseEntity<LoginDTO>(loginDTO,HttpStatus.BAD_REQUEST);
	}
}
