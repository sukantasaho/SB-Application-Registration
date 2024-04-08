package com.his.restCall;

import org.springframework.web.client.RestTemplate;

public class Template {
	
     private static RestTemplate template = null;

     private Template(){}
     
     public static RestTemplate getRestTemplate()
     {
	      if(template == null)
	      {
		      template = new RestTemplate();
	      }
		
	     return template;
     }
}
