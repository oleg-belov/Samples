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

import com.oleg.belov.jpa.hibernate.model.Book;
import com.oleg.belov.jpa.hibernate.model.Manuscript;

public class TestBidirectionalOneToOne {

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
	public void bidirectionalOneToOne() {
		log.info("... bidirectionalOneToOne ...");

		// Add a new Review
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Book b = em.find(Book.class, 1L);
		
		Manuscript m = new Manuscript();
		m.setBook(b);
		
		b.setManuscript(m);
		
		em.persist(m);
		
		em.getTransaction().commit();
		em.close();
		
		// Get Book entity with Authors
		em = emf.createEntityManager();
		em.getTransaction().begin();

		b = em.find(Book.class, 1L);
		
		m = b.getManuscript();
		Assert.assertEquals(b, m.getBook());
		
		em.getTransaction().commit();
		em.close();
	}
}
