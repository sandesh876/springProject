package com.bway.twotier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.twotier.dao.Patientdao;
import com.bway.twotier.dao.Userdao;
import com.bway.twotier.model.Patient;
import com.bway.twotier.model.User;

@Controller
public class LoginController {
	
	@Autowired
	private Userdao udao;
	
	@Autowired
	private Patientdao pdao;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getloginform()
	{
		
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute Patient u,Model model)
	{
		if (pdao.login(u.getUsername(), u.getPassword()))
		{
			model.addAttribute("user",u.getUsername());
			return "hello";
		}
		model.addAttribute("error","user doesnot exists!!!");
			
		return "login";
	}
	
	@RequestMapping(value="/patientlogin", method=RequestMethod.GET)
	public String getpatientloginform()
	{
		
		return "patientLogin";
	}

	
	
	@RequestMapping(value="/patientlogin",method=RequestMethod.POST)
	public String login(@ModelAttribute User u,Model model)
	{
		if (udao.Userlogin(u.getUsername(), u.getPassword()))
		{
			model.addAttribute("user",u.getUsername());
			return "hello";
		}
		model.addAttribute("error","user doesnot exists!!!");
			
		return "login";
	}
	
	
	
	
}
