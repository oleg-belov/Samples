package com.oleg.belov.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

	@Query("SELECT b FROM BookCategory b")
	List<BookCategory> findAllBookCategorys();
	
	@Query("SELECT b FROM BookCategory b where b.categoryId <= ?1")
	List<BookCategory> findByCategoryIdLessThanEquals(Long categoryIdLessThanEqual);
	
	@Query("SELECT b FROM BookCategory b where b.categoryName = :categoryName")
	List<BookCategory> findByCategoryName(@Param("categoryName") String categoryName);
	
	@Query("SELECT b FROM BookCategory b where b.categoryId >= ?1")
	/*if is comment, use named query at BookCategory class*/
	List<BookCategory> findByCategoryIdGteaterThanEquals(Long categoryIdGreaterThanEqual);

	Page<BookCategory> findByCategoryIdGreaterThan(Long categoryIdGreaterThan, Pageable pageRequest);
}
