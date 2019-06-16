package client;

import java.util.Stack;

import org.hibernate.Session;

import entity.customer;
import util.HibernateUtil;

public class DaoImplementation {

	public String add(customer cus) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 System.out.println(session);
		 String msg = "";
		int tran = (int)session.save(cus);
		 session.beginTransaction().commit();
		
			msg = "The order" + tran  + " has been Added succesfully";
		
		session.close();
		return msg;
		
	}
	

	public customer Inquire(String tran) {
		 System.out.println("m in dbs");
		Session session = HibernateUtil.getSessionFactory().openSession();
		 System.out.println(session);
		  if (session != null) 
		  {
			   try
			   {
				   customer cus = (customer)session.get(customer.class, tran);
				   if(cus!= null) {
					   System.out.println("customer is not null");
					   return cus ;
				   }
			   }
			   catch (Exception exception)
			   {
				    System.out.println("Exception occred while reading user data: "
				      + exception.getMessage());
			    }
		  }
	session.close();
		return null;
		
	}
}
