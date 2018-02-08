package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.BookValue;

public class TestJpqlQuery {

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
	public void pojoProjection() {
		log.info("... pojoProjection ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<BookValue> q = em.createQuery("SELECT new com.oleg.belov.jpa.hibernate.model.BookValue(b.id, b.title, b.publisher.name) FROM Book b WHERE b.id = :id", BookValue.class);
		q.setParameter("id", 1L);
		BookValue b = q.getSingleResult();
		
		Assert.assertTrue(b instanceof BookValue);
		Assert.assertEquals(new Long(1), ((BookValue)b).getId());
		log.info(b.toString());
		
		em.getTransaction().commit();
		em.close();
	}
}
