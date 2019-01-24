package com.capco.travel.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class mainRequestService implements MainRequestServiceInterface{
	
	@Override
	public int generateRandomRequestId() {
		
		//Integer requestId = (int) (Math.random() * 100000);
			//Integer requestId=Integer.parseInt(UUID.randomUUID().toString());
			UUID myuuid = UUID.randomUUID();
			long highbits = myuuid.getMostSignificantBits();
			String uid=String.valueOf(highbits);
			Integer requestId=Integer.parseInt(uid.substring(0,6).replace("-", "1"));
			return requestId;
		
	}

}
