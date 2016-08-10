package com.sprhib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Users;
import com.sprhib.service.IUserService;


@Controller
public class LoginController {
    /*@RequestMapping(value = "/",method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login2";
    }*/
	
	@Autowired
	private IUserService userService;
	

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView submit(Model model, @ModelAttribute("loginBean") Users loginBean,HttpSession httpSession) {
    	
    	
    	if(!userService.checkUsername(loginBean.getUsername())){
            model.addAttribute("msg", "User doesnot exist");
    		ModelAndView modelAndView = new ModelAndView("login");
    		return modelAndView;
    	}    		
    	else if(!userService.checkLogin(loginBean.getUsername(), loginBean.getPassword())){
    		
    		 model.addAttribute("msg", "Invalid Credentials");
     		ModelAndView modelAndView = new ModelAndView("login");
     		return modelAndView;
    	}
    	else{
    		
    	userService.checkLogin(loginBean.getUsername(), loginBean.getPassword());
    	Integer UserRole = userService.getUserRole(loginBean.getUsername());
    	if(UserRole==1){
		ModelAndView modelAndView = new ModelAndView("login2");
		return modelAndView;
    	}
    	else{
    		ModelAndView modelAndView = new ModelAndView("userhome");
    		return modelAndView;

    	}
    	}    	
      
    }

    @RequestMapping(value="/forgot",method = RequestMethod.GET)
    public ModelAndView forgot(Model model,@ModelAttribute("newpwdBean") Users user) {
    	    ModelAndView modelAndView = new ModelAndView("forgot");
    		return modelAndView;
    	
    }
    
    
    @RequestMapping(value="/newpwd/{username}",method = RequestMethod.POST)
    public ModelAndView newPwd(Model model,@ModelAttribute("newpwdBean") Users usersBean,@PathVariable String username) {
    	
    	if(!userService.checkUsername(usersBean.getUsername())){
            model.addAttribute("msg", "User doesnot exist");
    		ModelAndView modelAndView = new ModelAndView("login");
    		return modelAndView;
    	}    		
    	else
    	{   userService.updatePwd(usersBean);
    		model.addAttribute("msg", "Password updated successfully");
    		ModelAndView modelAndView = new ModelAndView("login");
    		return modelAndView;
    		
    	}
    	
    }
    
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
}