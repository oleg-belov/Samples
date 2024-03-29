package com.oleg.belov.jpa.hibernate.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Author;

public class TestTableAndSchemaName {

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
	public void selectFromView() {
		log.info("... selectFromView ...");

		// Persist a new Author entity
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Author a = new Author();
		a.setFirstName("firstName");
		a.setLastName("lastName");
		em.persist(a);
		
		em.getTransaction().commit();
		em.close();
		
		// Use a new EntityManager to read the Author entity from the database and not the cache
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		a = em.createQuery("SELECT a FROM Author a WHERE firstName = 'firstName'", Author.class).getSingleResult();
		Assert.assertNotNull(a);
		log.info(a.toString());
		
		assertThat(a.getId(), equalTo(1L));
		
		em.getTransaction().commit();
		em.close();
	}
}
