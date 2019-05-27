package com.bharath.Daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.controller.suppliercontroller;
import com.bharath.model.Category;
import com.bharath.model.Supplier;


@Component
public class SupplierDaoImpl {
@Autowired
SessionFactory sessionFactory;
public void AddSupplier(Supplier supplier)
{
    Session session=sessionFactory.openSession();
    if(supplier.getSupplierId()==0)
    {
    int id=(int)(Math.random()*10000);
   supplier.getSupplierId();
    }
    session.saveOrUpdate(supplier);
    Transaction transaction=session.beginTransaction();
    transaction.commit();
    System.out.println(sessionFactory);
    session.close();
    
}
public List<Supplier> getSupplier()
{
	
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Supplier");
	List<Supplier> supplierlist=query.list();
	for(Supplier cat:supplierlist)
	{
		System.out.println(cat.getSupplierId());
		System.out.println(cat.getSupplierDetails());
		System.out.println(cat.getSupplierName());
	}
	session.close();
	return supplierlist;
}
public Supplier getSupplier(int supplierId)
{
	Session session=sessionFactory.openSession();
	Supplier supplier=session.get(Supplier.class,supplierId);
	session.close();
	return supplier;
}
public void deletesupplierData(Supplier supplier)
{
	Session session=sessionFactory.openSession();
	session.delete(supplier);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}
public void editsupplierData(Supplier supplier)
{
	Session session=sessionFactory.openSession();
	session.saveOrUpdate(supplier);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
	
}

}