package com.sprhib.dao;

import java.util.List;
import com.sprhib.model.Product;

public interface ProductDAO {
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public Product getProduct(int pid);
	public void deleteProduct(int pid);
	public List<Product> getProducts();
}
