package com.oleg.belov.jpa.hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oleg.belov.jpa.hibernate.model.Author;
import com.oleg.belov.jpa.hibernate.model.Book;

public class TestCriteriaQuery {

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
//		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//		Root<Book> root = cq.from(Book.class);
//		SetJoin<Book, Author> authors = root.join(Book_.authors);
//		
//		ParameterExpression<String> paramFirstName = cb.parameter(String.class);
//		ParameterExpression<String> paramLastName = cb.parameter(String.class);
//		cq.where(
//			cb.and(
//				cb.equal(authors.get(Author_.firstName), paramFirstName), 
//				cb.equal(authors.get(Author_.lastName), paramLastName)));
//		
//		TypedQuery<Book> query = em.createQuery(cq);
//		query.setParameter(paramFirstName, "Thorben");
//		query.setParameter(paramLastName, "Janssen");
//		List<Book> books = query.getResultList();
//		Assert.assertEquals(1, books.size());
//		
//		for (Book b : books) {
//			log.info(b.toString());
//		}
//		
//		em.getTransaction().commit();
//		em.close();
	}
}
