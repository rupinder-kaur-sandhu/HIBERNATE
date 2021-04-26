package com.uttara.hib;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestHib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Address a = new Address("No 10","1st block rajajinagar","Karnataka","560010");
		PhoneNumber p1 = new PhoneNumber("080","+91","8866888801");	
		PhoneNumber p2 = new PhoneNumber("080","+91","8877665544");
		
		
	Employee e = new Employee("Rupinder",new Date(),a);
	e.getEmails().add("rup@gmail.com");
	e.getEmails().add("a@gmail.com");
	e.getEmails().add("b@gmail.com");
	e.getEmails().add("c@gmail.com");
	e.getEmails().add("d@gmail.com");
	e.getPhoneNum().add(p1);
	e.getPhoneNum().add(p2);
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session s = sf.openSession();
	s.beginTransaction();
	s.save(e);
	s.getTransaction().commit();
	s.close();
	
	HibernateUtil.getSessionFactory().close();

	}

}
