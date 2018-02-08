package com.oleg.belov.jpa.hibernate;

import java.time.LocalDate;

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

import com.oleg.belov.jpa.hibernate.Author;
import com.oleg.belov.jpa.hibernate.Book;
import com.oleg.belov.jpa.hibernate.Publication;

public class TestInheritance {

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
	public void testInheritance() {
		log.info("... testInheritance ...");

		// persist a new Book entity
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Book b = new Book();
		b.setTitle("Hibernate in Practice");
		b.setNumPages(200);
		b.setPublishingDate(LocalDate.of(2017, 4, 4));
		
		Author a = em.find(Author.class, 1L);
		b.getAuthors().add(a);
		a.getPublications().add(b);
		
		em.persist(b);
		
		em.getTransaction().commit();
		em.close();
		
		
		// read the Book entity
		em = emf.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b WHERE b.id = :id", Book.class);
		q.setParameter("id", 1L);
		b = q.getSingleResult();
		Assert.assertTrue(b instanceof Book);
		Assert.assertEquals(new Long(1), ((Book)b).getId());
		
		log.info(b.toString());
		
		em.getTransaction().commit();
		em.close();
		
		// access association on Author entity
		em = emf.createEntityManager();
		em.getTransaction().begin();

		a = em.find(Author.class, 1L);
		for (Publication p : a.getPublications()) {
			log.info(p.toString());
		}

		em.getTransaction().commit();
		em.close();
	}
}
