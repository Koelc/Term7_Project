package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.ProductDao;
import com.model.Category;
import com.model.Product;

public class ProductDaoImpl  implements ProductDao
{
	@Autowired// this annotation will mark the object as singleton
    SessionFactory sessionFactory;
    
    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory)
    {
    	super();
    	this.sessionFactory= sessionFactory;
    }
	
  
	public void insertProduct(Product supplier)// this method will be called
	//from controller of the front end
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier);// DB transaction
		session.getTransaction().commit();
				
	}
	
	public List<Product> retrieve()
	{
		Session session = sessionFactory.openSession();
		
			session.beginTransaction();
			List<Product> obj = session.createQuery("from Product").list();
			session.getTransaction().commit();
			return obj;
			
		}
	 public Product findById(int pid)
	  {

		  Session session = sessionFactory.openSession();
		  
		  Product  s = null;
		  try
		  {  
			session.beginTransaction();
			s = session.get(Product.class,pid);
			session.getTransaction().commit();
				  }
		  catch(Exception e)
		  {
			  session.getTransaction().rollback();
		  }
		  return s;
	  }
	


}











