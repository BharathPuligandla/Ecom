package com.bharath.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bharath.Daoimpl.AddToCartDaoImpl;
import com.bharath.Daoimpl.ProductDaoImpl;
import com.bharath.model.AddToCart;
import com.bharath.model.Product;

@Controller
public class CartController {
	@Autowired 
	ProductDaoImpl productDaoImpl;
	@Autowired
	AddToCartDaoImpl addToCartDaoImpl;
	@RequestMapping("/AddToCart")
	public String addToCart(HttpServletRequest httpServletRequest)
	{
		int productId=Integer.parseInt(httpServletRequest.getParameter("id"));
		int quantity=Integer.parseInt(httpServletRequest.getParameter("Quantity"));
		Product product=productDaoImpl.getProduct(productId);
		AddToCart addToCart=addToCartDaoImpl.getCart(product,quantity);
		return null;
	}
	
	@RequestMapping("/displaycart")
    public ModelAndView RetrieveAllCartData()
      {
		ModelAndView  mv=new ModelAndView("DisplayCart");
           List<AddToCart> cartdata=(List<AddToCart>)addToCartDaoImpl.getCartData();
          mv.addObject("cartlist",cartdata);
          return  mv;
          }

}
