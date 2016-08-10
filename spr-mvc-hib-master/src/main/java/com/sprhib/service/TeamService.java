package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Product;

public interface TeamService {
	
	public void addTeam(Product team);
	public void updateTeam(Product team);
	public Product getTeam(int id);
	public void deleteTeam(int id);
	public List<Product> getTeams();

}
