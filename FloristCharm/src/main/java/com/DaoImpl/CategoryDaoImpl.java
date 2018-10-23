package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.CategoryDao;
import com.model.Category;
import com.model.Supplier;

public class CategoryDaoImpl implements CategoryDao
{
	@Autowired// this annotation will mark the object as singleton
    SessionFactory sessionFactory;
    
    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory)
    {
    	super();
    	this.sessionFactory= sessionFactory;
    }
	
  
	public void insertCategory(Category category)// this method will be called
	//from controller of the front end
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);// DB transaction
		session.getTransaction().commit();
				
	}

	  public List<Category> retrieve()
	  {
		  Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Category> obj = session.createQuery("from Category").list();
			
			session.getTransaction().commit();
			return obj;
	  }
	  
	  public Category findById(int cid)
	  {

		  Session session = sessionFactory.openSession();
		  
		  Category  s = null;
		  try
		  {  
			session.beginTransaction();
			s = session.get(Category.class,cid);
			session.getTransaction().commit();
				  }
		  catch(Exception e)
		  {
			  session.getTransaction().rollback();
		  }
		  return s;
	  }
}
