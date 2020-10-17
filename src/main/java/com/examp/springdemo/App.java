package com.examp.springdemo;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//import org.omg.CORBA.portable.ApplicationException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*Laptop lap=new Laptop();
    	lap.setLid(1);
    	lap.setLname("dell");
    	
    	Student s=new Student();
    	s.setRollno(101);
    	s.setName("deepak");
    	s.setMarks(80);
    	s.getLaptop().add(lap);
    	
    	lap.getStudent().add(s);*/
    	
    	/*EmployeeName ename=new EmployeeName();
    	ename.setFirstName("deepak");
    	ename.setLastName("choudhary");
    	ename.setMiddleName("dadanprasad");*/
    	
    	//Employee emp=new Employee();
    	/*emp.setId(1);
    	emp.setEmail("deepakc12@");
    	emp.setEname(ename);
    	*/
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
    	
    	ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf=con.buildSessionFactory(reg);
    	
    	Session session1= sf.openSession();
    	
    	session1.beginTransaction();
    	//SQL Queries..
    	SQLQuery query=session1.createSQLQuery("select name,marks from student where marks>60");
    	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List students=query.list();
    	
    	for(Object o:students){
    		Map m=(Map) o;
    		System.out.println(m.get("name")+" : "+m.get("marks"));
    	}
    	session1.getTransaction().commit();
    	session1.close();   	
    }
}
