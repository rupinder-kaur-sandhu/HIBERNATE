package com.uttara.hib.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uttara.hib.HibernateUtil;
import com.uttara.hib.many2many.Person;
import com.uttara.hib.many2many.Vehicle;

public class TestEtoE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Person p1 = new Person("Mr.uupi");
		Person p2 = new Person("Mr . bappi");
		Person p3 = new Person("ruppi");
		
		Vehicle v1 = new Vehicle("vespa","sc001");
		Vehicle v2 = new Vehicle("yamaha","bi001");
		Vehicle v3 = new Vehicle("m800","ca001");
		Vehicle v4 = new Vehicle("merc","ca002");
		Vehicle v5 = new Vehicle("bmw","ca003");
		
		p1.getVehicles().add(v1);
		p1.getVehicles().add(v2);
		p1.getVehicles().add(v5);
		
		v1.getOwners().add(p1);
		v2.getOwners().add(p1);
		v5.getOwners().add(p1);
		
		
		p2.getVehicles().add(v3);
		p2.getVehicles().add(v4);
		
		v3.getOwners().add(p2);
		v4.getOwners().add(p2);
		
		v4.getOwners().add(p3);
		p3.getVehicles().add(v4);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
