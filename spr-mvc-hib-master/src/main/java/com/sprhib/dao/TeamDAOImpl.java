package com.sprhib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Product;

@Repository
public class TeamDAOImpl implements TeamDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTeam(Product team) {
		getCurrentSession().save(team);
	}

	public void updateTeam(Product team) {
		Product teamToUpdate = getTeam(team.getProductid());
		teamToUpdate.setProductname(team.getProductname());
		teamToUpdate.setPrice(team.getPrice());
		getCurrentSession().update(teamToUpdate);
		
	}

	public Product getTeam(int  productid) {
		Product team = (Product) getCurrentSession().get(Product.class, productid);
		return team;
	}

	public void deleteTeam(int productid) {
		Product team = getTeam(productid);
		if (team != null)
			getCurrentSession().delete(team);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getTeams() {
		return getCurrentSession().createQuery("from Product").list();
	}

}
