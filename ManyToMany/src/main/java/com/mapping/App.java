package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration  cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();
       
       Employee e = new Employee();
       Employee e2 = new Employee();
       
       e.setEid(10);
       e.setEname("khanbhai");
       
       e2.setEid(11);
       e2.setEname("deependra");
       
       Project p = new Project();
       Project p2 = new Project();
       
       p.setPid(10000);
       p.setPname("SplitBill management");
       
       p2.setPid(10001);
       p2.setPname("Stock Management");
       
       List<Employee>list1 = new ArrayList<Employee>();
       List<Project>list2 = new ArrayList<Project>();
       
       list1.add(e);
       list1.add(e2);
       
       list2.add(p);
       list2.add(p2);
       
       e.setProject(list2);
       p2.setEmp(list1);
       
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();
       
       session.save(e);
       session.save(e2);
       session.save(p);
       session.save(p2);
       
       tx.commit();
       session.close();
       factory.close();
       
       
    }
}
