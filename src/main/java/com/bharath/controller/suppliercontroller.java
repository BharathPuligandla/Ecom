package com.bharath.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bharath.Daoimpl.SupplierDaoImpl;
import com.bharath.model.Category;
import com.bharath.model.Supplier;

@Controller
public class suppliercontroller
{
    @Autowired
  SupplierDaoImpl supplierDaoImpl;
@RequestMapping("/AddSupplierDetails")
public ModelAndView goToSupplierform()
    {
		ModelAndView  mv=new ModelAndView("Supplier");
       mv.addObject("sup",new Supplier());
       mv.addObject("ButtonName","AddSupliers");
       return  mv;
    }
    @RequestMapping(value="/addsup",method=RequestMethod.POST)
    public ModelAndView recieveSupplierFormData(@ModelAttribute("sup") Supplier su)
    {
    	ModelAndView  mv=new ModelAndView("home");
        System.out.println(su.getSupplierId());
        System.out.println(su.getSupplierName());
        System.out.println(su.getSupplierDetails());
        supplierDaoImpl.AddSupplier(su);
        return mv ;
    }
   
    @RequestMapping("/ShowSupplierDetails")
    public ModelAndView RetriveCategorydata()
    {
    	  	 ModelAndView mv=new ModelAndView("ShowSupplier");
    	  	List<Supplier> list=(List<Supplier>) supplierDaoImpl.getSupplier();
    	  	mv.addObject("supr",list);
  	  return mv;
    }
    @RequestMapping("/deletesup")
    public ModelAndView deleteCategorydata(@RequestParam("supid")int supplierId)
    {
    	ModelAndView mv=new ModelAndView("ShowSupplier");
    	Supplier supplier=supplierDaoImpl.getSupplier(supplierId);
    	supplierDaoImpl.deletesupplierData(supplier);
    	List<Supplier> list=supplierDaoImpl.getSupplier();
    	mv.addObject("supr",list);
    	return mv;
    }
    @RequestMapping("/editsup")
    public ModelAndView editCategorydata(@RequestParam("supid")int supplierId)
    {
    	ModelAndView mv=new ModelAndView("Supplier");
    	Supplier supplier=supplierDaoImpl.getSupplier(supplierId);
    	supplierDaoImpl.editsupplierData(supplier);
    	mv.addObject("sup",supplier);
    	mv.addObject("ButtonName","UpdateSupplier");

    	return mv;
    }

}