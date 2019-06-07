package com.bway.twotier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.twotier.dao.Patientdao;

import com.bway.twotier.model.Patient;




@Controller
public class SignupController {
	
	@Autowired
	private Patientdao pdao;

	
	
	@RequestMapping(value="/patientsignup" ,method=RequestMethod.POST)
	public String signup(@ModelAttribute  Patient p)
	{
		pdao.signup(p);
		return "patientLogin";
	}

}
