package com.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView product() {
		return new ModelAndView("product");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/logintest", method=RequestMethod.GET)
	public ModelAndView login2()
	{
		return new ModelAndView("logintest");
	}
	
	@RequestMapping(value="/hometest", method=RequestMethod.GET)
	public ModelAndView home2()
	{
		return new ModelAndView("hometest");
	}
	
	@RequestMapping(value="/registest", method=RequestMethod.GET)
	public ModelAndView regi2()
	{
		return new ModelAndView("registest");
	}
	@RequestMapping(value="/forgot", method=RequestMethod.GET)
	public ModelAndView forgot()
	{
		return new ModelAndView("forgot");
	}
	@RequestMapping(value="/reset", method=RequestMethod.GET)
	public ModelAndView reset()
	{
		return new ModelAndView("reset");
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout()
	{
		return new ModelAndView("logout");
	}
	
	@RequestMapping(value="/jtest", method=RequestMethod.GET)
	public ModelAndView jtest()
	{
		return new ModelAndView("jtest");
	}
	
	
}
