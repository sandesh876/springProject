package com.bway.twotier.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.twotier.model.User;

@Repository
public class Userdaoimpl implements Userdao {
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void Usersignup(User u) {
		
		Session session=sessionFactory.getCurrentSession();
		session.save(u);
		
	}

	@Override
	@Transactional
	public boolean Userlogin(String un, String pw) {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria crt= session.createCriteria(User.class);
		crt.add(Restrictions.eq("username", un)).add(Restrictions.eq("password",pw));
		User u= (User) crt.uniqueResult();
		
		if(u!=null)
		{
			return true;
		}
		return false;
	}

}
