package com.bharath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroller {
	@RequestMapping("/home")
	public String gotohome()
	{
		return "home";
	}
	@RequestMapping("/Aboutus")
	public String gotoAboutus()
	{
		return "AboutUs";
	}
	@RequestMapping("/Contactus")
	public String gotoContactus()
	{
		return "ContactUS";
	}
	@RequestMapping("/Userhome")
	public String gotoUserhome()
	{
		
		return "Userhome";
	}

}
