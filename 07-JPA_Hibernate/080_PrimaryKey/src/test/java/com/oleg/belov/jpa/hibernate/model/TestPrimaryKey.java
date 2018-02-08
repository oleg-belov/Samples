package com.oleg.belov.jpa.hibernate.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Author;

public class TestPrimaryKey {

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
	public void testPrimaryKey() {
		log.info("... testPrimaryKey ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Author a = new Author();
		a.setId(1L);
		a.setFirstName("Thorben");
		a.setLastName("Janssen");
		
		log.info("Persist new Author entity.");
		em.persist(a);
		
		log.info("Call flush");
		em.flush();
		
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
		em.getTransaction().begin();

		a = em.find(Author.class, 1L);
		
		assertThat(a.getId(), equalTo(1L));
		
		em.getTransaction().commit();
		em.close();
	}
}
