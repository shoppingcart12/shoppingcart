package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Product;
import com.sprhib.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addProductPage() {
		ModelAndView modelAndView=null;
		try{
		modelAndView = new ModelAndView("Add-Product-Form");
		modelAndView.addObject("product", new Product());
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingProduct(@ModelAttribute Product product) {
		ModelAndView modelAndView=null;
		try{
		modelAndView = new ModelAndView("AdminHome");
		productService.addProduct(product);
		String message = "Product was successfully added.";
		modelAndView.addObject("message", message);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/list")
	public ModelAndView listOfProducts() {
		ModelAndView modelAndView=null;
		try{
		modelAndView = new ModelAndView("List-Of-Products");
		List<Product> product = productService.getTeams();
		modelAndView.addObject("products", product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{productid}", method=RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable Integer productid) {
		ModelAndView modelAndView=null;
		try{
		modelAndView = new ModelAndView("Edit-Product-Form");
		Product product = productService.getProduct(productid);
		modelAndView.addObject("product",product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{productid}", method=RequestMethod.POST)
	public ModelAndView edditingProduct(@ModelAttribute Product team, @PathVariable Integer productid) {
		ModelAndView modelAndView=null;
		try{
		modelAndView = new ModelAndView("AdminHome");
		productService.updateProduct(team);
		String message = "Product was successfully edited.";
		modelAndView.addObject("message", message);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{productid}", method=RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable Integer productid) {
		ModelAndView modelAndView=null;
		try{
		modelAndView = new ModelAndView("AdminHome");
		productService.deleteProduct(productid);
		String message = "Product was successfully deleted.";
		modelAndView.addObject("message", message);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	@RequestMapping(value="/productlist", method=RequestMethod.GET)
	public ModelAndView productList() {
		ModelAndView modelAndView=null;
		try{
		modelAndView = new ModelAndView("ProductList");
		List<Product> product = productService.getTeams();
		modelAndView.addObject("products", product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	 @RequestMapping(value="/goUserHome",method = RequestMethod.GET)
	    public ModelAndView forgot(Model model) {
	    	ModelAndView modelAndView=null;
	    	try{
	    	    modelAndView = new ModelAndView("UserHome");	
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return modelAndView;
	    }
}
