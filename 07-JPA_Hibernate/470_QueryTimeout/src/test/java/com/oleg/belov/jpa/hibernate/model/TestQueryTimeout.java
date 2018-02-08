package com.oleg.belov.jpa.hibernate.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Author;

public class TestQueryTimeout {

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
	public void queryTimeoutOnQuery() {
		log.info("... queryTimeoutOnQuery ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class)
		  .setHint("javax.persistence.query.timeout", 1)
		  .getResultList();
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void queryTimeoutOnEMfind() {
		log.info("... queryTimeoutOnEMfind ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		HashMap<String, Object> hints = new HashMap<>();
		hints.put("javax.persistence.query.timeout", 1);
		
		em.find(Author.class, 50L, hints);
		
		em.getTransaction().commit();
		em.close();
	}
}
