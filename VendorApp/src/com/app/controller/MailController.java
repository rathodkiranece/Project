package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.util.CommonUtil;

@Controller
public class MailController {
	@Autowired
	private CommonUtil commonUtil;
	@RequestMapping("/showMail")
	public String showMail()
	{
		return "Mail";
	}
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public String sendMail(@RequestParam("emailId")String emailId,@RequestParam("Subject")String subject,@RequestParam("text")String text,@RequestParam("attachment")CommonsMultipartFile file,ModelMap map)
	{
		commonUtil.sendEmail(emailId, subject,text,file);
		map.addAttribute("msg", "Mail sent successfully");
		return "Mail";
	}
}
