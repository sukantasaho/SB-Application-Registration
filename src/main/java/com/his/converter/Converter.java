package com.his.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import com.his.dto.RequestDTO;
import com.his.dto.ResponseDTO;
import com.his.entity.ApplicationRegistration;

public class Converter {
	
	public static ApplicationRegistration convertDTOToDBO(RequestDTO reqDTO){
		
			ApplicationRegistration dbo = null;
			try
			{
				if(reqDTO!=null)
				{
					dbo = new ApplicationRegistration();
					BeanUtils.copyProperties(reqDTO, dbo);
					dbo.setCreatedBy(reqDTO.getFullName());
					dbo.setModifiedBy(reqDTO.getFullName());
				}
			}
			catch (Exception e) {
				 System.out.println("Exception Occured");
			}
			return dbo;
		}
		
		public static List<ApplicationRegistration> convertDTOListToDBOList(List<RequestDTO> dtoList)
		{
			List<ApplicationRegistration> dboList = null;
			try
			{
				if(dtoList!=null)
				{
					dboList = dtoList.stream()
		                    .map(Converter::convertDTOToDBO)
		                    .collect(Collectors.toList()); 
				}
			}
			catch (Exception e) {
				 
			}
			
			return dboList;
		}
		
		public static List<ResponseDTO> convertDBOListToDTOList(List<ApplicationRegistration> dboList)
		{
			List<ResponseDTO> dtoList = null;
			try
			{
			    if(dboList!=null)
			    {
				     dtoList = dboList.stream()
	                          .map(Converter::convertDBOToDTO)
	                          .collect(Collectors.toList()); 
			    }
			}
			catch (Exception e) {
				 
			}
			return dtoList;
		}
		public static ResponseDTO convertDBOToDTO(ApplicationRegistration dbo)
		{
			ResponseDTO dto = null;
			try
			{
				if(dbo!=null)
				{
					dto = new ResponseDTO();
					BeanUtils.copyProperties(dbo, dto);
				}
			}
			catch (Exception e) {
				 
			}
			return dto;
		}
}

