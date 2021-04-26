package com.uttara.hib;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			int ch = 0;
			String name, dob, dia, gen;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Actor a = null;
			while (ch != 5) {
				System.out.println("Press1 to create Actor");
				System.out.println("Press 2 to list Actors");
				System.out.println("Press 3 to update Actor");
				System.out.println("Press 4 to delete Actor");
				System.out.println("Press 5 to exit");
				ch = sc1.nextInt();
				switch (ch) {
				case 1:
					System.out.println("creating actor");
					System.out.println("enter name of actor");
					name = sc2.nextLine();

					System.out.println("Famous Dialogue of actor");
					dia = sc2.nextLine();

					System.out.println("what is gender");
					gen = sc2.nextLine();

					System.out.println("whatis DOB");
					dob = sc2.nextLine();

					a = new Actor(name, dia, sdf.parse(dob), gen);
					
					Session s1 = factory.openSession();
					s1.beginTransaction();
					Long id = (Long) s1.save(a);
					System.out.println("genrated primary key = " + id);
					s1.getTransaction().commit();
					s1.close();
					
					break;
				case 2:
					System.out.println("listing actor");
					
					Session s3 = factory.openSession();
					s3.beginTransaction();
					
					List<Actor> actors = s3.createQuery("from Actor").list();
					for(Actor x : actors)
						System.out.println("Name : "+x.getName()+" Famous Dialogue "+ x.getFamousD()+" DOB "+sdf.format(x.getDob())+" gender "+x.getGender());
					
					s3.getTransaction().commit();
					s3.close();
					break;
				case 3:
					System.out.println("updating actor");
					System.out.println("enter sl_no of actor");
					long sl = sc1.nextInt();
					Session s2 = factory.openSession();
					s2.beginTransaction();
					Actor a2 = s2.get(Actor.class, sl);
					
					System.out.println("enter change off dialogue");
					dia=sc2.nextLine();
					
					a2.setFamousD(dia);//dirtied
					s2.getTransaction().commit();
					s2.close();
					
					break;
				case 4:
					System.out.println("deleting actor");
					System.out.println("enter Sl of actor");
					sl = sc1.nextLong();
					
					Session s4 = factory.openSession();
							s4.beginTransaction();
							Actor a3 = s4.get(Actor.class, sl);
							
							s4.delete(a3);
							s4.getTransaction().commit();
							s4.close();
					break;
				case 5:
					System.out.println("exiting");
					break;
				}
			}

			// Interact with session PAI to ask Hibernate to perform persistence
			// session is used to interact with hibernate, so hibernate will connect with
			// database and when hibernate connects with database
			// any change it does must be within the boundary of transaction.
			// transaction is from hibernate to DB, whereas session is from our applpication
			// to hibernate

			
			
			factory.close();

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}
