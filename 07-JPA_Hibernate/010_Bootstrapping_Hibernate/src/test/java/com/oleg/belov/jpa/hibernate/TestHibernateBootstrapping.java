package com.oleg.belov.jpa.hibernate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.Author;

public class TestHibernateBootstrapping {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	public void bootstrapping() {
		log.info("... bootstrapping ...");

		ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory sessionFactory = new MetadataSources(standardRegistry)
			.addAnnotatedClass(Author.class).buildMetadata()
			.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();

		Author a = new Author();
		a.setFirstName("Thorben");
		a.setLastName("Janssen");
		session.persist(a);
		
		Author res = session.find(Author.class, 1L);
		
		assertThat(res.getId(), equalTo(1L));
		
		session.getTransaction().commit();
		session.close();
	}
}
