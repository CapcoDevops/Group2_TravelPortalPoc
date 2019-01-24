package com.capco.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.travel.model.LoginDetailsBO;
import com.capco.travel.repo.LoginRepo;

@RestController
public class RegistrationController {
   @Autowired
   private LoginRepo loginRepo;
    @RequestMapping(value="/activateUser", method= RequestMethod.POST, produces="application/json")
    public String registration(@RequestBody LoginDetailsBO loginDetailsBO) {
       System.out.println("in registration contoller.....");
    		LoginDetailsBO detailsBO = loginRepo.findByEmailId(loginDetailsBO.getEmailId());
    		System.out.println("Before"+detailsBO.getIsActive());
    		
    		if(detailsBO.getEmailId().equals(loginDetailsBO.getEmailId()) && detailsBO.getContactNumber().equals(loginDetailsBO.getContactNumber())) {
    			if(detailsBO.getIsActive()!=true) {
    				 detailsBO.setIsActive(true);
    				  loginRepo.save(detailsBO);
    				 Boolean st=detailsBO.getIsActive();
    				 System.out.println("Active Statrus......."+st);
    			
    			}
    			return "Registration Succesful";
    	}
    		else {
    		return "Registration Failed";
    	}
    
    		}
}
