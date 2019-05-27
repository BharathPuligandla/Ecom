package com.bharath.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.model.Category;
import com.bharath.model.Product;

@Component
public class ProductDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
public void productDao(Product product)
{
	Session session=sessionFactory.openSession();
	
	session.saveOrUpdate(product);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}
public List<Product> getProductData()
{
    Session session=sessionFactory.openSession();
    Query query=session.createQuery("from Product");
    List<Product> productList=query.list();
    for(Product prod:productList)
    {
        System.out.println(prod.getProductName());
        System.out.println(prod.getProductPrice());
        System.out.println(prod.getProductSupplier());
        System.out.println(prod.getProductDiscription());
        System.out.println(prod.getProductCategory());
    }
    session.close();
    return productList;
    
}

public Product getProduct(int productId)
{
	Session session=sessionFactory.openSession();
	Product product=session.get(Product.class,productId);
	session.close();
	return product;
}
public void deleteProductData(Product product)
{
	Session session=sessionFactory.openSession();
	session.delete(product);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}
public List<Product> userProductData(Product product)
{
    Session session=sessionFactory.openSession();
    Query query=session.createQuery("from Product");
    List<Product> productList=query.list();
	session.close();
	return productList; 
	
}

public void editProductData(Product product)
{
	Session session=sessionFactory.openSession();
	session.saveOrUpdate(product);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}

}


	


