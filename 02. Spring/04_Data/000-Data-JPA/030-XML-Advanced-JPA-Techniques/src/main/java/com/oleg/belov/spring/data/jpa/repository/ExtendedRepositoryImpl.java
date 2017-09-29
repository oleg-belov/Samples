package com.oleg.belov.spring.data.jpa.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
	implements BaseRepository<T, ID>{

	private JpaEntityInformation<T,?> entityInformation;
	private EntityManager entityManger;
	
	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManger = entityManager;
		this.entityInformation = entityInformation;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCategoryId(List<ID> categoryIds) {
		Query query = this.entityManger.createQuery("select e from " + this.entityInformation.getEntityName() 
			+ " e where e." + this.entityInformation.getIdAttribute().getName() + " in :categoryIds");
		query.setParameter("categoryIds", categoryIds);
		return (List<T>) query.getResultList();
	}

}