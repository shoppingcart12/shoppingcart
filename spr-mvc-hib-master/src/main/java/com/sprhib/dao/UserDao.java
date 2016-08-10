package com.sprhib.dao;

import java.util.List;

import javax.annotation.Resource;










import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Product;
import com.sprhib.model.Users;


@Repository
public class UserDao implements IUserDao{
	
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

    public boolean checkLogin(String username, String password){
			System.out.println("In Check login"+username +password);
			
			
			Session session = sessionFactory.getCurrentSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Users as o where o.username=? and o.password=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,username);
			query.setParameter(1,password);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			return userFound;              
    }
    
    
    public boolean checkuser(String username){
    	
    	System.out.println("In Check user"+username);
		
		
		Session session = sessionFactory.getCurrentSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from Users as o where o.username=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,username);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		System.out.println("Boolean value : "+userFound);
		return userFound;              
    	
    }

	@Override
	public boolean updatePwd(Users user) {
		/*Users userToUpdate = getUser(user.getUsername());
		userToUpdate.setPassword(user.getPassword());
		System.out.println(userToUpdate.getUsername());
		System.out.println(userToUpdate.getPassword());
		getCurrentSession().update(userToUpdate);*/
	String hql = "UPDATE Users set password = :password "  + 
	             "WHERE username = :username";
	Query query = getCurrentSession().createQuery(hql);
	query.setParameter("password", user.getPassword());
	query.setParameter("username", user.getUsername());
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
		return false;
	}
	
	public Users getUser(String username) {
		Users team = (Users) getCurrentSession().get(Users.class, username);
		return team;
	}
	
	//select empMaster.name from EmployeeMaster empMaster where empMaster.id = :id
	@Override
	public Integer getRole(String username) {
		Integer id=0;
		String hql = "select roleid from Users " +
	             "WHERE username = :username";
	Query query = getCurrentSession().createQuery(hql);
	query.setParameter("username", username);
	List<Integer> result = query.list();
	for(Integer u:result){
		id=u;
	}
	return id;
	}
}
    
	
