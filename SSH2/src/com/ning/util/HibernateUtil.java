package com.ning.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	
	 private static SessionFactory buildSessionFactory() {
		 //Create the SessionFactory from hibernate.cfg.xml
		 try {
/*			 Configuration configuration = new Configuration();
		      configuration.configure("hibernate.cfg.xml");
		      System.out.println("Hibernate Configuration loaded");
		      
		      //apply configuration property settings to StandardServiceRegistryBuilder
		      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		      System.out.println("Hibernate serviceRegistry created");
		      
		      SessionFactory sessionFactory = configuration
		                .buildSessionFactory(serviceRegistry);*/
		      
		      return sessionFactory;

		} catch (Throwable ex) {
			 System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
		}
	 }
	 
	 public static SessionFactory getSessionFactory() {
		  if(sessionFactory == null) 
			  sessionFactory = buildSessionFactory();
		    return sessionFactory;
	 }
}
