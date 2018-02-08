package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.BookValue;

public class TestMapNativeQuery {

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
	public void explicitMapping() {
		log.info("... explicitMapping ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		BookValue b = (BookValue) em.createNativeQuery("SELECT b.publishingDate as date, b.title, b.id FROM book b WHERE b.id = 1", "BookValueMapping").getSingleResult();
		Assert.assertTrue(b instanceof BookValue);
		Assert.assertEquals("Effective Java", b.getTitle());
		
		em.getTransaction().commit();
		em.close();
	}
}
