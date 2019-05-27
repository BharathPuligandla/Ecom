package com.bharath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Categories {
	Categories()
	{
		System.out.println("Categories is loading ");
	}
	@RequestMapping("/addproducts")
	 String m2()
	{
	return "addproducts";
	}
	@RequestMapping("/showproducts")
	String m3()
	{
		return "showproducts";
	}

}