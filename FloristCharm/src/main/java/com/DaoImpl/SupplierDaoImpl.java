package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.SupplierDao;
import com.model.Supplier;

public class SupplierDaoImpl  implements SupplierDao
{

	@Autowired// this annotation will mark the object as singleton
    SessionFactory sessionFactory;
    
    @Autowired
    public SupplierDaoImpl(SessionFactory sessionFactory)
    {
    	super();
    	this.sessionFactory= sessionFactory;
    }
	
  
	public void insertSupplier(Supplier supplier)// this method will be called
	//from controller of the front end
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier);// DB transaction
		session.getTransaction().commit();
				
	}
	
  public List<Supplier> retrieve()
  {
	  Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> obj = session.createQuery("from Supplier").list();
		
		session.getTransaction().commit();
		return obj;
  }
  
  public Supplier findById(int sid)
  {

	  Session session = sessionFactory.openSession();
	  
	  Supplier s = null;
	  try
	  {  
		session.beginTransaction();
		s = session.get(Supplier.class, sid);
		session.getTransaction().commit();
			  }
	  catch(Exception e)
	  {
		  session.getTransaction().rollback();
	  }
	  return s;
  }
	
}












