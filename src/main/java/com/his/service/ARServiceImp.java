package com.his.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.converter.Converter;
import com.his.dto.RequestDTO;
import com.his.entity.ApplicationRegistration;
import com.his.repository.IApplicationRegistrationRepo;

@Service
public class ARServiceImp implements IARService {

	@Autowired
	private IApplicationRegistrationRepo repo;
	
	@Override
	public String save(RequestDTO requestDTO) {
		 
		String status = null;
		try
		{
			ApplicationRegistration dbo = Converter.convertDTOToDBO(requestDTO);
			if(dbo!=null)
			{
				repo.save(dbo);
				status = "User OnBoarding Success";
			}
			else
			{
			   status = "User OnBoarding Failed";
			}
		}
		catch (Exception e) {
			 System.out.println("Exception Occurred ARServiceImp-save method");
		}
		
		return status;
	}

	
}
