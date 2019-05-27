package com.bharath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class c1
{
c1()
{
System.out.println("C2 is loading ");
}
@RequestMapping("/bbc")
 ModelAndView m2()
{
	ModelAndView modelAndView=new ModelAndView("hello");
	modelAndView.addObject("nm",120);
return modelAndView;
}
}
