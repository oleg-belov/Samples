package com.oleg.belov.jpa.hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Book;

public class TestQueryPagination {

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
	public void first5Authors() {
		log.info("... first5Authors ...");

//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		// Define the CriteriaQuery
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//		Root<Book> root = cq.from(Book.class);
//		cq.orderBy(cb.asc(root.get(Book_.id)));
//		
//		// Execute query with pagination
//		List<Book> books = em.createQuery(cq)
//									.setMaxResults(5)
//									.setFirstResult(0)
//									.getResultList();
//		Assert.assertEquals("Expected a list of 5 books.", 5, books.size());
//		books.forEach(b -> log.info(b.getTitle()));
//
//		em.getTransaction().commit();
//		em.close();
	}

	@Test
	public void next5Authors() {
		log.info("... next5Authors ...");

//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		// Define the CriteriaQuery
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//		Root<Book> root = cq.from(Book.class);
//		cq.orderBy(cb.asc(root.get(Book_.id)));
//		
//		// Execute query with pagination
//		List<Book> books = em.createQuery(cq)
//									.setMaxResults(5)
//									.setFirstResult(5)
//									.getResultList();
//		Assert.assertEquals("Expected a list of 5 books.", 5, books.size());
//		books.forEach(b -> log.info(b.getTitle()));
//
//		em.getTransaction().commit();
//		em.close();
	}
}
