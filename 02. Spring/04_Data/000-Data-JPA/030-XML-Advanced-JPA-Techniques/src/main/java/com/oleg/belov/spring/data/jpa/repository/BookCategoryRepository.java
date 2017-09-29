package com.oleg.belov.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

@Repository
public interface BookCategoryRepository extends BaseRepository<BookCategory, Long> {
	
	public List<BookCategory> findByCategoryIdGreaterThan(Long categoryId, Sort sort);
}
