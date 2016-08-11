package com.java.dao;

import java.util.List;

import javax.annotation.Resource;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.bean.User;

@Repository("loginDAO")
public class UserDao implements IUserDao{
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }

    public boolean checkLogin(String username, String password){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Users as o where o.uname=? and o.pwd=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,username);
			query.setParameter(1,password);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			session.close();
			return userFound;              
    }
}
    
	
