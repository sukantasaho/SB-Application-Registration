package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.his.dto.RequestDTO;
import com.his.restCall.Template;
import com.his.service.IARService;

@RestController
@RequestMapping("/applicationRegistration")
public class ARController {

	@Autowired
	private IARService service;
	
	@PostMapping("/userOnBoarding")
	public ResponseEntity<String> save(@RequestBody RequestDTO requestDTO)
	{
		String status = null;
		try
		{
			if(requestDTO!=null)
			{
				RestTemplate  restTemplate = Template.getRestTemplate();
				String baseUrl = "http://localhost:2024/us/citizen/getStateNameBySSNID";
				String paramKey = "Id";
		        Long paramValue = requestDTO.getSsn();
		        
		        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
		                .queryParam(paramKey, paramValue)
		                .toUriString();
		        String response = restTemplate.getForObject(url, String.class);
		        
		        if(response.equalsIgnoreCase("new jersy"))
		        {
		        	status = service.save(requestDTO);
		        }
		        else
		        {
		        	status = "User Onboarding Failed";
		        }
			}
		}
		catch (Exception e) {
			 System.out.println("Exception Occurred In ARController:save method");
		}
		
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
}
