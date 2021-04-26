package com.uttara.hib.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uttara.hib.HibernateUtil;

public class TestEtoE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Vehicle v1 = new Vehicle("sc001","sc001");
		Vehicle v2 = new Vehicle("sc002","sc009");
		
		Person p1 = new Person("Mrsaddy");
		Person p2 = new Person("Mr.joyy");
		
		p1.getVehicles().add(v1);
		p2.getVehicles().add(v2);
		
		v1.setOwner(p1);
		v2.setOwner(p2);
		
		session.save(p1);
		session.save(p2);

		
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
