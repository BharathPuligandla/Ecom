package com.bharath.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bharath.Daoimpl.CategoryDaoImpl;
import com.bharath.Daoimpl.SupplierDaoImpl;
import com.bharath.Daoimpl.TestSessionFactory;
import com.bharath.model.Category;
import com.bharath.model.Product;
@Controller
public class CategoryController
{ 
	@Autowired
	TestSessionFactory test;
	@Autowired
	SupplierDaoImpl SupplierdaoImpl;
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
		CategoryController()
	{
		System.out.println("helloooooooooooooooooo");
	}
//@RequestMapping("/category")
    @RequestMapping(value="/addproducts", method=RequestMethod.GET)
    public ModelAndView goToCategoryForm()
    {
    	//test.Testsession();
    	System.out.println("helloo123");
        ModelAndView  mv=new ModelAndView("Category");
        mv.addObject("cat",new Category());
        mv.addObject("ButtonName","AddCategory");
        return  mv;
    }
    
    @RequestMapping(value="/addCat",method=RequestMethod.POST)
    public ModelAndView getCategoryData(@ModelAttribute ("cat") Category ca)
    {
    	 ModelAndView  mv=new ModelAndView("home");
        System.out.println(ca.getCategoryName());
        System.out.println(ca.getCategoryDiscription());
        categoryDaoImpl.CategoryDao(ca);
        return mv;
    }
    @RequestMapping("/show")
    public ModelAndView RetriveCategoryData()
    {
    	List<Category> list=categoryDaoImpl.getCategoryData();
  	 ModelAndView mv=new ModelAndView("ShowCategory");
     mv.addObject("cate",list);
  	  return mv;
    }
    @RequestMapping("/deletecat")
    public ModelAndView deleteCategoryData(@RequestParam("catid")int categoryid)
    {
    	ModelAndView mv=new ModelAndView("ShowCategory");
    	Category category=categoryDaoImpl.getCategory(categoryid);
    	categoryDaoImpl.deleteCategoryData(category);
    	List<Category> list=categoryDaoImpl.getCategoryData();
    	mv.addObject("cate",list);
    	return mv;
    }
    @RequestMapping("/editcat")
    public ModelAndView editCategoryData(@RequestParam("catid")int categoryid)
    {
    	ModelAndView mv=new ModelAndView("Category");
    	Category category=categoryDaoImpl.getCategory(categoryid);
    	categoryDaoImpl.editCategoryData(category);
    	mv.addObject("cat",category);
    	mv.addObject("ButtonName","UpdateCategory");
    	return mv;
    }
}

