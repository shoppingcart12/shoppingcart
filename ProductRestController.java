package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.sprhib.model.Product;
import com.sprhib.model.Users;
import com.sprhib.service.ProductService;
import com.sprhib.service.UserService;

@Controller
public class ProductRestController {

	@Autowired
	ProductService productService; 
	UserService userService;
	
	@RequestMapping(value = "/productslist", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> users = productService.getTeams();
		if(users.isEmpty()){
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		
		return new ResponseEntity<List<Product>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public ResponseEntity checkLogin(@ModelAttribute Users loginBean) {
		boolean status = userService.checkLoginInf(loginBean.getUsername(), loginBean.getPassword());
		if(!status){
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity("login fail", HttpStatus.OK);
		}else{
		return new ResponseEntity("login success :Login user :"+loginBean.getUsername(), HttpStatus.OK);
		}
	}
	
	//-------------------Create a User--------------------------------------------------------
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST,produces ="application/json")
	public ResponseEntity<Void> addProduct(@ModelAttribute Product product, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + product.getProductname());

		productService.addProduct(product);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/product/{productid}").buildAndExpand(product.getProductid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
}
