package com.oleg.belov.jpa.hibernate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.oleg.belov.jpa.hibernate.model.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootstrappingTest {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private EntityManager em;
	
	@Test
	@Transactional
	@Commit
	public void accessHibernateSession() {
		log.info("... accessHibernateSession ...");
		
		Author a = new Author();
		a.setFirstName("Thorben");
		a.setLastName("Janssen");
		em.persist(a);
		
		Author res = em.find(Author.class, 1L);
		
		assertThat(res.getId(), equalTo(1L));
	}
}
