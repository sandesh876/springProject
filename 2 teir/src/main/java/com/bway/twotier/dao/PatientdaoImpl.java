package com.bway.twotier.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.twotier.model.Patient;

@Repository
public class PatientdaoImpl implements Patientdao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void signup(Patient p) {
		Session session=sessionFactory.getCurrentSession();
		session.save(p);
		
	}

	@Override
	@Transactional
	public boolean login(String un, String psw) {
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(Patient.class);
		crt.add(Restrictions.eq("username", un))
		.add(Restrictions.eq("password",psw));
		
		Patient patient=(Patient) crt.uniqueResult();
		if(patient!=null)
		{
			return true;
		}
		return false;
	
		
	}

}
