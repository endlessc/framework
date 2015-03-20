package com.ning.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ning.model.User;

/**
 * 
 * @author Administrator
 *
 */
public class SpringHibernateTest {

	private SessionFactory sessionFactory;
	private ApplicationContext ctx;


	public void testSessionFactory() {
		String[] configLocations = new String[]{"classpath:application-*.xml"};
		ctx = new ClassPathXmlApplicationContext(configLocations);
		sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);

		System.out.println(ctx.getBean("dataSource"));
		System.out.println(sessionFactory);
		
		Session session = sessionFactory.openSession();
		
		User user = new User();
		user.setName("liangning");
		user.setPassword("123456");
		
		session.save(user);
	}

}
