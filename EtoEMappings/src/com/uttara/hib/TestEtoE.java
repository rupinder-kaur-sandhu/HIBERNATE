package com.uttara.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestEtoE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Vehicle v1 = new Vehicle("sc001",Vtype.TWOW);
		Vehicle v2 = new Vehicle("sc002",Vtype.SIXTEENW);
		
		Person p1 = new Person("Pingu",v1);
		Person p2 = new Person("Gangu",v2);
		
		session.save(p1);
		session.save(p2);
		
		//session.save(v1);
		//session.save(v2);
		
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
