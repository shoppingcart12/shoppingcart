package com.sprhib.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprhib.model.Product;

public interface ProductService {
	public Product addProduct(Product team);
	public Product updateProduct(Product team);
	public Product getProduct(int id);
	public void deleteProduct(int id);
	public List<Product> getTeams();
	public List<Product> searchProduct(String brand);
	public List<String> getBrands();
}
