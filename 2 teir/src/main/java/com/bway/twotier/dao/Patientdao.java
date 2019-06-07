package com.bway.twotier.dao;

import com.bway.twotier.model.Patient;

public interface Patientdao {
	
	void signup(Patient p);
	
	boolean login(String un,String psw);

	

}
