package com.sprhib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addProduct(Product product) {
		try{
		getCurrentSession().save(product);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateProduct(Product product) {
		try{
		Product productToUpdate = getProduct(product.getProductid());
		productToUpdate.setProductname(product.getProductname());
		productToUpdate.setPrice(product.getPrice());
		getCurrentSession().update(productToUpdate);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Product getProduct(int  productid) {
		Product product=null;
		try{
		product = (Product) getCurrentSession().get(Product.class, productid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}

	public void deleteProduct(int productid) {
		try{
		Product product = getProduct(productid);
		if (product != null)
			getCurrentSession().delete(product);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		List<Product> productList=null;
		try{
			productList=getCurrentSession().createQuery("from Product").list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return productList;
	}
}
