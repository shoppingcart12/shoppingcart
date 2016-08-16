package com.java.controller;



import javax.servlet.http.HttpSession;
import com.java.service.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.bean.*;

@Controller
@Scope("session")
public class LoginController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean,HttpSession httpSession) {
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
        	UserService service=new UserService();
        	if(service.checkLogin(loginBean.getUserName(), loginBean.getPassword())){
            
        		//if (loginBean.getUserName().equals("sowjanya") && loginBean.getPassword().equals("sowjanya")) {
                
        			model.addAttribute("msg", "welcome" + loginBean.getUserName());
                httpSession.setAttribute("uname",loginBean.getUserName());
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
}