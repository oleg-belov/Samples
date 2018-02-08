package com.oleg.belov.jpa.hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Book;

public class TestMetamodel {

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
	public void getBooks() {
		log.info("... getBooks ...");

//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
//		Root<Book> root = cq.from(Book.class);
//		cq.multiselect(root.get(Book_.title), root.get(Book_.publishingDate));
//				
//		List<Tuple> results = em.createQuery(cq).getResultList();
//		
//		for (Tuple r : results) {
//			log.info(r.get(0) + " was published on " + r.get(1));
//		}
//		
//		em.getTransaction().commit();
//		em.close();
	}
}
