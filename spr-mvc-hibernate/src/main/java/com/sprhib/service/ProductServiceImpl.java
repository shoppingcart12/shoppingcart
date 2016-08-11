package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.ProductDAO;
import com.sprhib.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	public void addProduct(Product product) {
		try{
		productDAO.addProduct(product);		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateProduct(Product product) {
		try{
		productDAO.updateProduct(product);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Product getProduct(int pid) {
		Product product=null;
		try{
		product = productDAO.getProduct(pid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}

	public void deleteProduct(int pid) {
		try{
		productDAO.deleteProduct(pid);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Product> getTeams() {
		List<Product> products=null;
		try{
			products=productDAO.getProducts();
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
	}
}
