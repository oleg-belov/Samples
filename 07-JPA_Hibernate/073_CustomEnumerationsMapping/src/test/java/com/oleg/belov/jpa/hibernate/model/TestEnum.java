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
import com.oleg.belov.jpa.hibernate.model.AuthorStatus;

public class TestEnum {

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
	public void persistAndLoad() {
		log.info("... persistAndLoad ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Author a = new Author();
		a.setFirstName("John");
		a.setLastName("Doe");
		a.setStatus(AuthorStatus.PUBLISHED);
		
		em.persist(a);
		
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
		em.getTransaction().begin();

		a = em.find(Author.class, a.getId());
		log.info(a.toString());

		assertThat(a.getId(), equalTo(1L));

		em.getTransaction().commit();
		em.close();
	}
}
