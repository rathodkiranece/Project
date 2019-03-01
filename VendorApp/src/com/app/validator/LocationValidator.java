package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.service.ILocationService;
@Component
public class LocationValidator {
	@Autowired
	private ILocationService service;
	public String ValidateName(String locName){
		String msg="";
		if(service.isLocNameExist(locName))
			msg="'"+locName+"' already exist";
		return msg;
		}
	public String ValidateLocDelete(int locId){
		String msg="";
		if(service.isLocationUsedByVendor(locId))
			msg="'"+locId+"' can not be delete";
		return msg;
		
	}

}
