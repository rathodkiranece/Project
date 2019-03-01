package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Location;
import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private LocationUtil locUtil;
	@Autowired
	private CommonUtil commonUtil;

	//1.show Reg Page(GET)
	@RequestMapping("/venReg")
	public String showPage(ModelMap map){
		List<Location> loc=locUtil.getAllLocation();

		map.addAttribute("locObj", loc);
		return "VendorReg";
	}

	//2.insert data(POST)
	@RequestMapping(value="/insertVen",method=RequestMethod.POST)
	public String insertVen(@ModelAttribute("vendor")Vendor ven,ModelMap map,
			@RequestParam("attachment")CommonsMultipartFile file){
		int venId=service.saveVendor(ven);
		String msg="Record Inserted Successfully with ID: "+venId;
		map.addAttribute("msg", "Vendor saved with Id:"+venId);
		commonUtil.sendEmail(ven.getVenMail(), "Test-Mail", 
				"Hey you have Registered with ID:"+venId,file);
		return "VendorReg";
	}

	//3.display data(GET)
	@RequestMapping("/viewAllVens")
	public String showVendors(ModelMap map){
		List<Vendor> venList=service.getAllVendors();
		map.addAttribute("venListObj", venList);
		return "VendorData";
	}

	//4.delete data(GET)
	@RequestMapping("/deleteVen")
	public String deleteVen(@RequestParam("venId")int venId){
		service.deleteVendor(venId);
		return "redirect:viewAllVens";
	}

	//5.show edit(GET)
	@RequestMapping("/showEditVen")
	public String showEditPage(@RequestParam("venId")int venId,ModelMap map){
		Vendor ven=service.getVendorById(venId);
		map.addAttribute("venObj",ven);
		//all Locations
		List<Location> list=locUtil.getAllLocation();
		map.addAttribute("locListObj",list);

		return "VendorDataEdit";
	}

	//6.update data(POST)
	@RequestMapping(value="/updateVen",method=RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor")Vendor ven){
		service.updateVendor(ven);
		return "redirect:viewAllVens";
	}

}
