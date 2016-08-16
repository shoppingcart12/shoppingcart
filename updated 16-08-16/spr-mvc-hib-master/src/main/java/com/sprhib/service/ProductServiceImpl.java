package com.sprhib.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.ProductDAO;
import com.sprhib.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }

	
	@Autowired
	private ProductDAO productDAO;

	public Product addProduct(Product product) {
		try{
		productDAO.addProduct(product);		
		}catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}

	public Product updateProduct(Product product) {
		try{
		productDAO.updateProduct(product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return product;
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
			return null;

		}
		return products;
	}

	@Override
	public List<Product> searchProduct(String brand) {
		List<Product> list=null;
		try{
			list = productDAO.getProductByBrand(brand);
		
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}
		
		return list;
	}
	@Override
	public List<String> getBrands() {
	
		return productDAO.getBrands();
	}
}
