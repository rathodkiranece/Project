package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CoDecUtil codecUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	

	@RequestMapping("/showCust")
	public String showPage(){
		return "CustomerReg";
	}
	@RequestMapping(value="/insertCust",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer")Customer cust,ModelMap map){
		//generate pwd,token using codeUtil
		String pwd=codeUtil.genPwd();
		String token=codeUtil.genToken();
		//encode values
		String ePwd=codecUtil.doEncode(pwd);
		String eToken=codecUtil.doEncode(token);
		//set encoded data to object 
		cust.setAccToken(eToken);
		cust.setPassword(ePwd);
		
		
		//save data to DB using service 
		int custId=service.saveCustomer(cust);
		//send email
				String text="UserName:"+cust.getCustEmail()+"("+cust.getCustType()+"),"
				+" your password is: "+pwd+" and token is :"+token;
				commonUtil.sendEmail(cust.getCustEmail(),"Welcome to Customer ..",text);
		//const message
		String m="Customer saved with Id:" +custId;
		//send message to UI
		map.addAttribute("msg",m);
		return "CustomerReg";
	}
	
	/**
	 * 3. THis method is used to
	 * fetch Data from DB using
	 * service-DAL layers.
	 *  Send this data to UI using
	 *  ModelMap
	 * It will be called on click
	 * hyper link in Customer Reg Page
	 */
	@RequestMapping("/viewAllCusts")
	public String showAllcusts(ModelMap map){
		//Read Data using Service
		List<Customer> custList=service.getAllCustomer();
		//Send data to UI
		map.addAttribute("custListObj",custList);
		return "CustomerData";
		
	}
	/**
	 * 4 Delete Location
	 */
	@RequestMapping("/deleteCust")
	public String deleteCust(@RequestParam("custId")int custId){
		//Call Service Layar Delete Method
		service.deleteCustById(custId);
		return "redirect:viewAllCusts";
		
	}

	/**
	 * 5.Show Edit Page
	 */
	@RequestMapping("/showEditCust")
	public String showCustEdit(@RequestParam("custId")int custId,ModelMap map){
		Customer cust=service.getCustomerById(custId);
		map.addAttribute("custObj", cust);
		
		return "CustomerDataEdit";
	}
	
	/**
	 * 6.Update Customer Data
	 */
	@RequestMapping(value="/updateCust",method=RequestMethod.POST)
	public String updateCust(@ModelAttribute("customer")Customer cust){
		service.updateCustomer(cust);
		return "redirect:viewAllCusts";
	}
	//7.ajax call
		@RequestMapping("/checkId")
		public @ResponseBody String checkIdData(@RequestParam("eid")int id){
			String msg="";
			Customer c=service.getCustomerById(id);
			if(c!=null){
				msg=id+"  already exist in DataBase";
			}
			return msg;
		}
		@RequestMapping("/showCustItem")
		public String getCustItems(@RequestParam("custId")int custId,ModelMap map){
			List<Item> itemList=service.getItemsOfCustomerbyId(custId);
			map.addAttribute("itemList", itemList);
			map.addAttribute("CustomerId", custId);
			return "CustomerItem";
			
}
}