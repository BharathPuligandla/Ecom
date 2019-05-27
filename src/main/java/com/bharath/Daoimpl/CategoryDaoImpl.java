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
public class CategoryDaoImpl
{
@Autowired
SessionFactory sessionFactory;
public void CategoryDao(Category c)
{
   Session s=sessionFactory.openSession();
   if(c.getCategoryid()==0)
   {
 int id=(int)(Math.random()*10000);
 c.setCategoryid(id);
   }
   s.save(c);
   Transaction t=s.beginTransaction();
   t.commit();
   System.out.println(sessionFactory);
   s.close();
}
public List<Category> getCategoryData()
{
    Session session=sessionFactory.openSession();
    Query query=session.createQuery("from Category");
    List<Category> categoryList=query.list();
    
    for(Category category:categoryList)
    {
        System.out.println(category.getCategoryid());
        System.out.println(category.getCategoryDiscription());
        System.out.println(category.getCategoryName());
    }
    session.close();
    return categoryList;
    
}
public Category getCategory(int categoryid)
{
	Session session=sessionFactory.openSession();
	Category category=session.get(Category.class,categoryid);
	session.close();
	return category;
}
public void deleteCategoryData(Category category)
{
	Session session=sessionFactory.openSession();
	session.delete(category);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}
public void editCategoryData(Category category)
{
	Session session=sessionFactory.openSession();
	session.delete(category);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}

}
