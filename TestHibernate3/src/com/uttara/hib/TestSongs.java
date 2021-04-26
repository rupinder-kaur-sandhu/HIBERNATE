package com.uttara.hib;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestSongs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			
		SessionFactory sf = HibernateUtil.getSessionFactory();
		 Session session = sf.openSession();//session is backed by connection
		 Transaction tx = session.beginTransaction();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy");
		 Song s1 = new Song("ChaiyaChaiya",6,5,sdf.parse("10/02/2021"));
		 //s1 is in transient state
		 System.out.println("Before saving s1 id is "+s1.getId());
		 Long id = (Long)session.save(s1);//s1 in persistent state and hibernate will generate id for it.
		 System.out.println("After saving s1 id is "+s1.getId());
		 tx.commit();// now s1 state will be inserted into table using prepared statement
		 session.close();//backing connection closed -> all Result set,prepared statemnet...all resources released
		 //so s1 is in detached state
		 
		 s1.setTitle("chaiya chaiya chaiya.......");// object became dirty
		 
		 //second session
		 session = sf.openSession();//new session backed by new connection
		 tx = session.beginTransaction();
		 session.update(s1);// will make s1 persistent. hibernate will automatically update the dirtied state back to db
		 tx.commit();
		 session.close();
		 
		 //third session
		 session = sf.openSession();
		 tx = session.beginTransaction();
		 Song s2 = session.get(Song.class, id);//new Song obj
		 //s2 is in persistent state, s1 is in detached state	
		 s2.setDuration(10);
		 for(int i=0;i<1000;i++)
		 {
			 Song s = new Song("hamma hamma"+i,5,4,sdf.parse("01/01/2021"));
			 session.save(s);
		 }
		 tx.commit();//hibernate does dirty checking and make changes to s2 persistent object be pushed to DB
		 session.close();
		 
		 
		 
		 //fourth session
		 session = sf.openSession();
		 tx = session.beginTransaction();
		 //Query q = (Query)session.createQuery("from Song");
		 //List<String> songs = q.getResultList();
		 Query q = session.createQuery("Select title,rating from Song");
		 
		 List objs = q.list();
		 for(Object ob : objs)
		 {
			 Object[] oa = (Object[]) ob;
			 System.out.println("ob[0] = "+oa[0]+" ob[1] "+oa[1]);
		 }
		 tx.commit();
		 session.close();
		 
		 sf.close();
		 System.out.println("");
		 System.out.println("");
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
		
	}

}
