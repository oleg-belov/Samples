package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Book;

public class TestNaturalId {

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

	@Test
	public void naturalId() {
		log.info("... naturalId ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Session session = em.unwrap(Session.class);

		Book b = session.bySimpleNaturalId(Book.class)
				.load("123-4567890123");
		Assert.assertEquals(new Long(1), b.getId());

		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void simpleNaturalId() {
		log.info("... simpleNaturalId ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Session session = em.unwrap(Session.class);

		Book b = session.bySimpleNaturalId(Book.class)
				.load("123-4567890123");
		Assert.assertEquals(new Long(1), b.getId());

		em.getTransaction().commit();
		em.close();
	}
}
