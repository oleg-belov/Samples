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

import com.oleg.belov.jpa.hibernate.model.Author;

public class TestFormula {

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
	public void emFind() {
		log.info("... emFind ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Author a = em.find(Author.class, 1L);
		Assert.assertEquals(44, a.getAge());
		log.info(a.getFirstName() + " " + a.getLastName() + " is " + a.getAge() + " years old.");
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void query() {
		log.info("... query ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Author a = em.createQuery("SELECT a FROM Author a WHERE a.id = 1", Author.class).getSingleResult();
		Assert.assertEquals(44, a.getAge());
		log.info(a.getFirstName() + " " + a.getLastName() + " is " + a.getAge() + " years old.");
		
		em.getTransaction().commit();
		em.close();
	}
}
