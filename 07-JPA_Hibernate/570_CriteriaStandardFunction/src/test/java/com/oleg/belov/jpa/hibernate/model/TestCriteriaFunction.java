package com.oleg.belov.jpa.hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Author;

public class TestCriteriaFunction {

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
	public void callSizeFunction() {
		log.info("... callSizeFunction ...");

//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
//		Root<Author> root = cq.from(Author.class);
//		cq.multiselect(root, cb.size(root.get(Author_.books)));
//		cq.groupBy(root.get(Author_.id));
//		
//		TypedQuery<Tuple> q = em.createQuery(cq);
//		List<Tuple> results = q.getResultList();
//		
//		for (Tuple r :  results) {
//			log.info(r.get(0) + " wrote " +  r.get(1) + " books.");
//		}
//
//		em.getTransaction().commit();
//		em.close();
	}
}
