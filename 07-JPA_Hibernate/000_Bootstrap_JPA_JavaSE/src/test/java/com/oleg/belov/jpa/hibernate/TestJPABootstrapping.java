package com.oleg.belov.jpa.hibernate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJPABootstrapping {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	public void bootstrapping() {
		log.info("... bootstrapping ...");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Book book = em.find(Book.class, 1L);
		
		assertThat(book.getId(), equalTo(1L));

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
