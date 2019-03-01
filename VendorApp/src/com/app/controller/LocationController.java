package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;

@Controller
public class LocationController {
	@Autowired
	public ServletContext Context;
	@Autowired
	private LocationUtil util;
	@Autowired
	private ILocationService serv;
	@Autowired
	private LocationValidator validator;
	
	/**
	 * 1.This method is used to
	 * display the Location Register page
	 * on Entering URL '/locReg' in browser at last
	 *  
	 */
	
	@RequestMapping("/locReg")
	public String showPage(){
		return "LocationReg";
	}
	
	/**
	 * 2. This method is used to
	 * fetch data from UI as Object 
	 * using ModelAttribute.
	 * 
	 * Send this data to SL using
	 * service saveMethod.
	 * 
	 *  After Saving data it returns
	 *  primary key value as int type
	 * 
	 * Send success message to UI
	 * using ModelMap
	 */
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location")Location loc,ModelMap map){
		String  msg=validator.ValidateName(loc.getLocName());
		if(!msg.equals(""))
		{
			map.addAttribute("msg", msg);
			return "LocationReg";
		}
		else
		{
		//call service layer method
		int locId=serv.saveLocation(loc);
		
		//const message
		String m="Location saved with Id:"+locId;
		//send message to UI
		map.addAttribute("msg", m);
		
		return "LocationReg";
	}
	}
	/**
	 * 3. THis method is used to
	 * fetch Data from DB using
	 * service-DAL layers.
	 *  Send this data to UI using
	 *  ModelMap
	 * It will be called on click
	 * hyper link in Location Reg Page
	 */
	@RequestMapping("/viewAllLocs")
	public String showAllLocs(ModelMap map){
		//read data using service
		List<Location> locList=serv.getAllLocations();
		//send data to UI
		map.addAttribute("locListObj", locList);
		return "LocationData";
	}
	
	/**
	 * 4 Delete Location
	 */
	@RequestMapping("/deleteLoc")
	public String deleteLoc(@RequestParam("locId")int locId,ModelMap map){
		String msg=validator.ValidateLocDelete(locId);
		if(!msg.equals(""))
		{
			List<Location> llist=serv.getAllLocations();
			map.addAttribute("locobj", llist);
			map.addAttribute("msg",llist);
			return "LocationData";
		}
		
		else
		{
		//call service layer delete method
		serv.deleteLocById(locId);
		return "redirect:viewAllLocs";
	}
	}
	
	/**
	 * 5.Show Edit Page
	 */
	@RequestMapping("/showEditLoc")
	public String showLocEdit(@RequestParam("locId")int locId,ModelMap map){
		Location loc=serv.getLocationById(locId);
		map.addAttribute("locObj", loc);
		
		return "LocationDataEdit";
	}
	
	/**
	 * 6.Update Location Data
	 */
	@RequestMapping(value="/updateLoc",method=RequestMethod.POST)
	public String updateLoc(@ModelAttribute("location")Location loc){
		serv.updateLocation(loc);
		return "redirect:viewAllLocs";
		
	}
	/**
	 * 7.
	 */
	@RequestMapping("/exportLocToExcel")
	public String exportDatatoExcelFile(ModelMap map){
		map.addAttribute("LocationListObj", serv.getAllLocations());
		return "LocationExcelView";
	}
		@RequestMapping("/exportLocToPdf")
	public String exportDatatoPdfFile(ModelMap map){
			map.addAttribute("locationListObj", serv.getAllLocations());
		return "LocationPdfView";
	}
		@RequestMapping("/ViewLocReport")
	public String generatechart(){
		List<Object[]> list=serv.getLocTypeWiseCount();
		String Path=Context.getRealPath("/");
		util.generatePie(Path,list);
		util.generateBar(Path,list);
		return "LocationReport";
		
		
	}
		//4.ajax call
		@RequestMapping("/checkid")
		public @ResponseBody String checkIdData(@RequestParam("eid")int id){
			String msg="";
			Location l=serv.getLocationById(id);
			if(l!=null){
				msg=id+"  already exist in DB.";
			}
			return msg;
		}
		
	}
