package com.sprhib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.sprhib.model.Users;
import com.sprhib.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
    @RequestMapping(value="/login",method = RequestMethod.POST)
    
    public ModelAndView submit(Model model, @ModelAttribute("loginBean") Users loginBean,HttpSession httpSession) {
    	ModelAndView modelAndView=null;
     try{		
    	if(!userService.checkUserInf(loginBean.getUsername())){
            model.addAttribute("msg", "User doesnot exist");
    		modelAndView = new ModelAndView("Login");
    	}    		
    	else if(!userService.checkLoginInf(loginBean.getUsername(), loginBean.getPassword())){
    		
    		 model.addAttribute("msg", "Invalid Credentials");
     		modelAndView = new ModelAndView("Login");
    	}
    	else{	
    	userService.checkLoginInf(loginBean.getUsername(), loginBean.getPassword());
    	Integer UserRole = userService.getUserRole(loginBean.getUsername());
    	if(UserRole==1){
		modelAndView = new ModelAndView("AdminHome");
    	}
    	else{
    		modelAndView = new ModelAndView("UserHome");
    	}
    	}    	
     }catch(Exception e){
    	 e.printStackTrace();
     }
     return modelAndView;
    }

    @RequestMapping(value="/goLogin",method = RequestMethod.GET)
    public ModelAndView goLogin(Model model) {
    	ModelAndView modelAndView=null;
    	try{
    	    modelAndView = new ModelAndView("Login");	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return modelAndView;
    }
    
    @RequestMapping(value="/forgot",method = RequestMethod.GET)
    public ModelAndView forgot(Model model) {
    	ModelAndView modelAndView=null;
    	try{
    	    modelAndView = new ModelAndView("ForgotPwd");	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return modelAndView;
    }
    
    @RequestMapping(value="/plogin", method=RequestMethod.GET)
    public ModelAndView Plogin()
    {
    	return new ModelAndView("PLogin");
    }
    
    
    @RequestMapping(value="/goAdminHome",method = RequestMethod.GET)
    public ModelAndView goAdminHome(Model model) {
    	ModelAndView modelAndView=null;
    	try{
    	    modelAndView = new ModelAndView("AdminHome");	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return modelAndView;
    }
    
    @RequestMapping(value="/newpwd/{username}",method = RequestMethod.POST)
    public ModelAndView newPwd(Model model,@ModelAttribute("newpwdBean") Users usersBean,@PathVariable String username) {
    	ModelAndView modelAndView=null;
    	try{
    	if(!userService.checkUserInf(usersBean.getUsername())){
            model.addAttribute("msg", "User doesnot exist");
    		modelAndView = new ModelAndView("ForgotPwd");
    	}    		
    	else
    	{   userService.updatePwd(usersBean);
    		model.addAttribute("msg", "Password updated successfully");
    		modelAndView = new ModelAndView("ForgotPwd");
    		
    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return modelAndView;
    }
    
    @RequestMapping(value="/userSignUp",method = RequestMethod.GET)
    public ModelAndView userSignUp(Model model) {
    	ModelAndView modelAndView=null;
    	try{
    	    modelAndView = new ModelAndView("UserSignUp");	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return modelAndView;
    }
    
    @RequestMapping(value="/signUpUser", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Users user) {
		ModelAndView modelAndView=null;
			try{
			modelAndView = new ModelAndView("UserSignUp");
			if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")){
				user.setRoleid(1);
			}else{
				user.setRoleid(2);
			}
			userService.addUser(user);
			String message = "User Registered Successfully.";
			modelAndView.addObject("message", message);
			}catch(Exception e){
				e.printStackTrace();
			}
		return modelAndView;
	}
    
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}