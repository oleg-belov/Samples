package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.LazyInitializationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Author;

public class TestJoinFetch {

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

	@Test(expected = LazyInitializationException.class)
	public void selectFromWithoutJoinFetch() {
		log.info("... selectFromWithoutJoinFetch ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Author a = em.createQuery("SELECT a FROM Author a WHERE id = 1", Author.class).getSingleResult();
		
		log.info("Commit transaction and close Session");
		em.getTransaction().commit();
		em.close();
		
		try {
			log.info(a.getFirstName()+" "+a.getLastName()+" wrote "+a.getBooks().size()+" books.");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}
	
	@Test
	public void selectFromWithJoinFetch() {
		log.info("... selectFromWithJoinFetch ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Author a = em.createQuery("SELECT a FROM Author a JOIN FETCH a.books WHERE a.id = 1", Author.class).getSingleResult();
		
		log.info("Commit transaction and close Session");
		em.getTransaction().commit();
		em.close();
		
		log.info(a.getFirstName()+" "+a.getLastName()+" wrote "+a.getBooks().size()+" books.");
	}
}
