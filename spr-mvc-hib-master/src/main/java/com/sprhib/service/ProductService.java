package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Product;

public interface ProductService {
	public void addProduct(Product team);
	public void updateProduct(Product team);
	public Product getProduct(int id);
	public void deleteProduct(int id);
	public List<Product> getTeams();
}
