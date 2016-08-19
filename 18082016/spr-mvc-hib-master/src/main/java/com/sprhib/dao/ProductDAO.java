package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Product;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public void updateProduct(Product product);
	public Product getProduct(int pid);
	public void deleteProduct(int pid);
	public List<Product> getProducts();
	public List<Product> getProductByBrand(String brand);
	public List<String> getBrands();
	
}
