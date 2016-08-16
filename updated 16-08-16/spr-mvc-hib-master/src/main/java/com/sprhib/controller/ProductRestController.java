package com.sprhib.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.sprhib.model.Product;
import com.sprhib.service.ProductService;
import com.sprhib.service.UserService;

@Controller
public class ProductRestController {

	@Autowired
	ProductService productService; 
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value = "/productslist", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> users = productService.getTeams();
		if(users.isEmpty()){
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		
		return new ResponseEntity<List<Product>>(users, HttpStatus.OK);
	}

	/*@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public ResponseEntity checkLogin(@ModelAttribute Users loginBean) 
	{
		boolean status = userService.checkLoginInf(loginBean.getUsername(), loginBean.getPassword());
		if(!status){
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity("login fail", HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity("login success :Login user :"+loginBean.getUsername(), HttpStatus.OK);
		}
	}*/
	
	@RequestMapping(value = "/logins", method = RequestMethod.GET)
	public void checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse res) 
	{
		boolean status = userService.checkLoginInf(username, password);
		PrintWriter out=null;
		try {
			out=res.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(!status){
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			/*return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);*/
			out.println("fail");
		}
		else
		{
		/*return new ResponseEntity<String>("success", HttpStatus.OK);*/
			out.print("success");
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

	@RequestMapping(value = "/addproducts", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Product> addProducts(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/updateproduct", method = RequestMethod.PUT, headers = "Accept=application/json")
	public  ResponseEntity<Product>  updateProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteproduct/{productid}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productid") int productid) {
		return new ResponseEntity<Void>(HttpStatus.OK);

	}	
	
	@RequestMapping(value = "/searchproduct/{brand}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Product>> getProductByBrand(@PathVariable String brand) {
		return new ResponseEntity<List<Product>>(productService.searchProduct(brand), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getbrands", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<String>> getBrands() {
		return new ResponseEntity<List<String>>(productService.getBrands(), HttpStatus.OK);
	}
}

