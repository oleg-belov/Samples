package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAccessHibernateApi {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	private EntityManagerFactory emf;

	@Before
	public void init() {
		emf = Persistence.createEntityManagerFactory("my-persistence-unit");
	}

	@After
	public void close() {
		emf.close();
	}

	@SuppressWarnings("unused")
	@Test
	public void accessHibernateSession() {
		log.info("... accessHibernateSession ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Session session = em.unwrap(Session.class);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void accessHibernateSessionFactory() {
		log.info("... accessHibernateSessionFactory ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		SessionFactory sessionFactory = em.getEntityManagerFactory().unwrap(SessionFactory.class);
		
		em.getTransaction().commit();
		em.close();
	}
}
