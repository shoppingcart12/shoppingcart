package com.sprhib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Users;


@Repository
public class UserDaoImpl implements UserDao{
	
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

    public boolean checkLoginInf(String username, String password){
    	boolean valid=false;
    	try{
			System.out.println("In Check login"+username +password);
			Session session = sessionFactory.getCurrentSession();
			String SQL_QUERY =" from Users as o where o.username=? and o.password=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,username);
			query.setParameter(1,password);
			List list = query.list();
			System.out.println(list);
			if ((list != null) && (list.size() > 0)) {
				valid= true;
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
			return valid;              
    }
    
    
    public boolean checkUserInf(String username){
    	boolean valid=false;
    	try{
    	System.out.println("In Check user"+username);
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY =" from Users as o where o.username=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,username);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			valid= true;
		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return valid;              
    	
    }

	@Override
	public boolean updatePwd(Users user) {
	boolean update=false;
	try{
	String hql = "UPDATE Users set password = :password "  + 
	             "WHERE username = :username";
	Query query = getCurrentSession().createQuery(hql);
	query.setParameter("password", user.getPassword());
	query.setParameter("username", user.getUsername());
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
	if(result>=1){
		update=true;
	}
	}catch(Exception e){
		e.printStackTrace();
	}
		return update;
	}
	
	public Users getUser(String username) {
		Users users=null;
		try{
		users = (Users) getCurrentSession().get(Users.class, username);
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public Integer getRole(String username) {
		Integer id=0;
		try{
		String hql = "select roleid from Users " +
	             "WHERE username = :username";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("username", username);
		List<Integer> result = query.list();
		        for(Integer u:result){
					id=u;
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	    return id;
	}
	@Override
	public void addUser(Users user) {
		try{
			getCurrentSession().save(user);
			}catch(Exception e){
				e.printStackTrace();
		}
	}
}
    
	
