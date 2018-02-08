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

import com.oleg.belov.jpa.hibernate.model.Book;

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
	public void namedJpqlQuery() {
		log.info("... namedJpqlQuery ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Book> q = em.createNamedQuery(Book.QUERY_SELECT_BY_ID, Book.class);
		q.setParameter(Book.PARAM_ID, 1L);
		Book b = q.getSingleResult();
		Assert.assertTrue(b instanceof Book);
		Assert.assertEquals(new Long(1), ((Book)b).getId());
		
		em.getTransaction().commit();
		em.close();
	}
}
