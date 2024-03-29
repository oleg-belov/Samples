package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Book;

public class TestNamedNativeQuery {

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
	public void namedNativeQuery() {
		log.info("... namedNativeQuery ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query q = em.createNamedQuery(Book.QUERY_SELECT_BY_ID);
		q.setParameter(1, 100);
		Book b = (Book) q.getSingleResult();
		Assert.assertTrue(b instanceof Book);
		Assert.assertEquals(new Long(100), ((Book)b).getId());
		
		em.getTransaction().commit();
		em.close();
	}
}
