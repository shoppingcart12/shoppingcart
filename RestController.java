package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprhib.model.Product;
import com.sprhib.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class RestController {

	@Autowired
	private ProductService productService;
	@RequestMapping(value = "/lists", method = RequestMethod.GET,consumes ="application/json")  
	 public @ResponseBody List<Product> getProducts()  
	 {  
	  List<Product> listOfCountries = new ArrayList<Product>();  
	  listOfCountries=productService.getTeams(); 
	  return listOfCountries;  
	 }  
}
