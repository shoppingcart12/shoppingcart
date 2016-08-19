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

	public boolean addProduct(Product product) {
		try{
		getCurrentSession().save(product);
		return true;
		}catch(Exception e){
			return false;
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
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductByBrand(String brand) {
		List<Product> productList=null;
		try{
			String SQL_QUERY =" from Product as p where p.brand=?";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,brand);
			productList = query.list();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<String> getBrands() {
		List<String> brands=null;
		try{
			String SQL_QUERY =" select distinct p.brand from Product as p";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(SQL_QUERY);
			brands = query.list();
			System.out.println(brands);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return brands;
	}
}
