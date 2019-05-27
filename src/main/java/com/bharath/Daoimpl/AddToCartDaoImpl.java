package com.bharath.Daoimpl;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.model.AddToCart;
import com.bharath.model.Product;

@Component
public class AddToCartDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
	public AddToCart getCart(Product product,int quantity)
	{AddToCart addToCart=new AddToCart();
    Session session=sessionFactory.openSession();
    if(addToCart.getCartId()==0)
       {
    int id=(int)(Math.random()*10000);
    addToCart.setCartId(id);
       }
    addToCart.setProductId(product.getProductId());
    addToCart.setProductName(product.getProductName());
    addToCart.setProductPrice(product.getProductPrice());
    addToCart.setProductSupplier(product.getProductSupplier());
    addToCart.setQuantity(quantity);
    addToCart.setTotalPrice(addToCart.getProductPrice()*addToCart.getQuantity());
    session.save(addToCart);
    Transaction transaction=session.beginTransaction();
    transaction.commit();
    session.close();
    return addToCart;
}
public List<AddToCart> getCartData()
{
Session session=sessionFactory.openSession();
   Query query=session.createQuery("from AddToCart");
    List<AddToCart> cartlist=query.list();
    for(AddToCart cartdata:cartlist)
    {
        System.out.println(cartdata.getProductId());
        
    }
    session.close();
    return cartlist;
}
}
