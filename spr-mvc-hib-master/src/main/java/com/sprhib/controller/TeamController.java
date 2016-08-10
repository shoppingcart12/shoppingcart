package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Product;
import com.sprhib.service.TeamService;

@Controller
@RequestMapping(value="/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("team", new Product());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Product team) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		teamService.addTeam(team);
		
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		
		List<Product> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{productid}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer productid) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		Product team = teamService.getTeam(productid);
		modelAndView.addObject("team",team);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{productid}", method=RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Product team, @PathVariable Integer productid) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		teamService.updateTeam(team);
		
		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{productid}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer productid) {
		ModelAndView modelAndView = new ModelAndView("home");
		teamService.deleteTeam(productid);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	@RequestMapping(value="/productlist", method=RequestMethod.GET)
	public ModelAndView productList() {
		ModelAndView modelAndView = new ModelAndView("productlist");
		List<Product> teams = teamService.getTeams();
		modelAndView.addObject("products", teams);
		return modelAndView;
	}

}
