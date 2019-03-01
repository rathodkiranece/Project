package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired 
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	//1.show Register page for USER
	@RequestMapping("/userReg")
	public String showPage(){
		return "UserReg";
		}
	//2.Save Data of User to DB
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user")User user ,ModelMap map){
		//generate PWD
		String pwd=codeUtil.genPwd();
		//set user type
		String userType = user.getUserType();
		//set to Model Attribute
		user.setUserPwd(pwd);
		
		if (userType.equalsIgnoreCase("user")) {
			user.setStatus(0);
		}
		if (userType.equalsIgnoreCase("admin")) {
			user.setStatus(null);
		}
		//save data to DB
		int userId=service.saveUser(user);
		map.addAttribute("msg", "User created with id:"+userId);
				String text = "Hi " + user.getUserName()
				+ " your Registered successfully, your Pwd: " + pwd
				+ " and UserName(email): " + user.getUserEmail()
				+ " or and UserName : " + user.getUserContact()
				+ " you can login after admin approval";
		commonUtil.sendEmail(user.getUserEmail(), "User Registration", text);
	map.addAttribute("msg", "User created with id:"+userId);
	return "UserReg";
}
// view all data
	@RequestMapping("/viewUsers")
	public String showAllUsers(ModelMap map) {
		List<User> userList = service.getAllUsers();
		map.addAttribute("userList", userList);
		return "UserDataPage";
	}
// delete data
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		service.deleteUserById(userId);
		return "redirect:viewUsers";

	}

	/**
	 * 3. To show User Login Page
	 */
	@RequestMapping("/showLogin")
	public String showLoginPage(){
		return "UserLogin";
	}
/**
 * 4.User Login Check
 */
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String userLogin(@RequestParam("userName") String userName,
			@RequestParam("pwd") String pwd, HttpServletRequest req,
			ModelMap map) {
		String dispalyPage = null;

		User user = service.getUserByUserNameAndPwd(userName, pwd);

		if (user != null) {
			if(user.getUserType().equalsIgnoreCase("admin")){
				HttpSession session = req.getSession(true);
				session.setAttribute("userName", user.getUserName());
				map.addAttribute("msg", "Hi " + user.getUserName() + " Admin loging successfully");
				dispalyPage = "AdminHomePage";    
				                                             }
			if(user.getUserType().equalsIgnoreCase("user")){
				if (user.getStatus() == 1 ) {
				HttpSession session = req.getSession(true);
				session.setAttribute("userName", user.getUserName());
				map.addAttribute("msg", "Hi " + user.getUserName() + " you have loging successfully");
				dispalyPage =  "LocationReg";
			                                 } 
				else {
				map.addAttribute("msg", "you have to wait untill admin approval");
				dispalyPage = "UserLogin";
			       }
			                                     
		            }
		            }
			
			else {
				map.addAttribute("msg", "login was failed, user not exist ");
				dispalyPage = "UserLogin";
				}
		return dispalyPage;

		}
	       @RequestMapping("/logoutUser")
			public String userLogout(HttpServletRequest req,ModelMap map){
				HttpSession ses=req.getSession(false);
				if(ses !=null){
				ses.setAttribute("userName", null);
				ses.invalidate();
				map.addAttribute("msg", "Logout successful");
				return "UserLogin";
			}else {
				map.addAttribute("msg", "you have to login");

				return "UserLogin";
			}
		}
	       
	       @RequestMapping("/viewUsersType")
	   	public String getUsersByType(ModelMap map) {
	   		List<User> userTypeList = service.getUsersType();
	   		if (userTypeList != null && userTypeList.size() > 0) {
	   			map.addAttribute("userTypeList", userTypeList);
	   			return "UserTypeDatapage";
	   		} else {
	   			map.addAttribute("msg", "users not available in Db");
	   			return "AdminHomePage";
	   		}
	   	}
	   	
	   	@RequestMapping("/makeActive")
	   	public String makeActiveToUser(@RequestParam("userId")int userId){
	   		service.makeUserToActive(service.getUserById(userId));
	   		return "redirect:viewUsersType";
	   	}
	   	
	   	@RequestMapping("/makeDeActive")
	   	public String makeDeActiveToUser(@RequestParam("userId")int userId){
	   		service.makeUserToDeActive(service.getUserById(userId));
	   		return "redirect:viewUsersType";
	   	}
		}
