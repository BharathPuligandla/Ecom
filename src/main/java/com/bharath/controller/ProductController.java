package com.bharath.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bharath.Daoimpl.CategoryDaoImpl;
import com.bharath.Daoimpl.ProductDaoImpl;
import com.bharath.Daoimpl.SupplierDaoImpl;
import com.bharath.model.AddToCart;
import com.bharath.model.Category;
import com.bharath.model.Product;
import com.bharath.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	ProductDaoImpl productDaoImpl;
	@Autowired
	CategoryDaoImpl categorydaoimpl;
	@Autowired
	SupplierDaoImpl supplierdaoimpl;
@RequestMapping("/AddProductDetails")
public ModelAndView gotoProductForm()
{
	ModelAndView mv=new ModelAndView("AddProduct");
	List<Category> categorylist =categorydaoimpl.getCategoryData();
List<Supplier> supplierlist=supplierdaoimpl.getSupplier();
Product product=new Product();
int id=(int)(Math.random()*10000);
product.setProductId(id);

	mv.addObject("pro",product);
	mv.addObject("cat",categorylist);
	mv.addObject("sup",supplierlist);
	mv.addObject("ButtonName","AddProducts");
	return mv;
}
@RequestMapping(value="/addPro",method=RequestMethod.POST)
public ModelAndView reciveProductFromData(@ModelAttribute("pro") Product product)
{
	ModelAndView mv=new ModelAndView("home");
	MultipartFile image=product.getProductImage();
	System.out.println("testing image---"+image);
	try {
		byte byteArray[]=image.getBytes();
		FileOutputStream fos=new FileOutputStream("E:/Project/spm/src/main/webapp/resources/project-images/"+product.getProductId()+".jpg");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write(byteArray);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	productDaoImpl.productDao(product);
	return mv;
}
@RequestMapping(value="/ShowProductsDetails", method=RequestMethod.GET)
public ModelAndView retriveProductdata()
{
	List<Product> list=productDaoImpl.getProductData();
	 ModelAndView mv=new ModelAndView("ShowProduct");
	 mv.addObject("prod",list);
	  return mv;
}
@RequestMapping("/deletepro")
public String deleteProductData(@RequestParam("proid") int productId)
{
	Product product=productDaoImpl.getProduct(productId);
	productDaoImpl.deleteProductData(product);
	File file=new File("E:/Project/spm/src/main/webapp/Resources/Project-images/"+product.getProductId()+".jpg");
	file.delete();
	return "redirect:ShowProductsDetails";
}
@RequestMapping("/editpro")
public ModelAndView editProductData(@RequestParam("proid") int productId)
{

	ModelAndView mv=new ModelAndView("AddProduct");
	Product product=productDaoImpl.getProduct(productId);
	productDaoImpl.editProductData(product);
	List<Category> categorylist =categorydaoimpl.getCategoryData();
	List<Supplier> supplierlist=supplierdaoimpl.getSupplier();
		mv.addObject("cat",categorylist);
		mv.addObject("sup",supplierlist);
	mv.addObject("pro",product);
	mv.addObject("ButtonName","UpdateProducts");
	return mv;
}
@RequestMapping(value="/userProducts", method=RequestMethod.GET)
public ModelAndView userProductdata()
{
	List<Product> list=productDaoImpl.getProductData();
	 ModelAndView mv=new ModelAndView("UserProducts");
	 mv.addObject("prod",list);
	  return mv;
}
@RequestMapping("/userSupplierDetails")
public ModelAndView userSupplierDetails(@RequestParam("proid") int productId)
{
	ModelAndView mv=new ModelAndView("OneProductSupplierDetails");
	Product product=productDaoImpl.getProduct(productId);
	mv.addObject("prod",product);
	return mv;
}
}
