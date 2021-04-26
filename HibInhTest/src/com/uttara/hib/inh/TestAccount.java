package com.uttara.hib.inh;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf=null;
		Transaction tx = null;
		try {
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		BankAccount a1 = new BankAccount("Mr.X",new BigDecimal("100000"),"HDFC",new BigDecimal("1000"));
		CreditCardAccount a2 = new CreditCardAccount("Mr Y",new BigDecimal("0"),"423567890", new BigDecimal("5777"),sdf.parse("01/01/2020"));
		
		sf = HibernateUtil.getSessionFactory();
		Session s1 = sf.openSession();
		 tx = s1.beginTransaction();
		 
		 s1.save(a1);
		 s1.save(a2);
		
		tx.commit();
		
		s1.close();
		
		//-------table per class observations
		//table is created per class(means parent columns in child tables will be replicated), but we have created data for child classes, here a1 is bank acc and a2 is credit card acc
		//so Acc table is empty whereas bankacc and creditcard acc has 1-1 value each
		//remember for table per class: polymorphic association does not exist(no primary key/foreign key relationshoips), but polymorphic query works which  means
		//query from parent table will result rows from all tables including parent and child.
		
		
		//-----------------JOINED------------------------
		//Polymorphic association and polymorphic query both works
		
		//------------------Single_Table
		//
		Session s2 = sf.openSession();
		List<Account> accounts = s2.createQuery("from Account").list();
		System.out.println(" accounts "+accounts);
		
		}
		catch(Throwable t)
		{
			tx.rollback();
			t.printStackTrace();
		}
		finally
		{
			sf.close();
		}
	}

}
