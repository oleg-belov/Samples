package com.oleg.belov.spring.data.jpa.service;

import java.util.List;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

public interface BookStoreService {

	List<BookCategory> findByCategoryName(String categoryName);

	List<BookCategory> findByCategoryNameLike(String categoryNameLike);

	List<BookCategory> findByCategoryNameContaining(String categoryNameContaining);

	List<BookCategory> findByCategoryNameStartingWith(String categoryNameStartingWith);

	List<BookCategory> findByCategoryNameEndingWith(String categoryNameEndingWith);

	List<BookCategory> findByCategoryNameIgnoreCase(String categoryNameIgnoreCase);

	List<BookCategory> findByCategoryIdEquals(Long categoryId);

	List<BookCategory> findByCategoryIdGreaterThan(Long categoryIdGreaterThan);

	List<BookCategory> findByCategoryIdLessThan(Long categoryIdLessThan);

	List<BookCategory> findByCategoryIdGreaterThanEqual(Long categoryIdGreaterThanEqual);

	List<BookCategory> findByCategoryIdLessThanEqual(Long categoryIdLessThanEqual);

	List<BookCategory> findByCategoryIdBetween(Long categoryIdBetweenMin, Long categoryIdBetweenMax);

	List<BookCategory> findByCategoryNameContainingOrCategoryIdLessThan(String categoryNameContaining,
			Long categoryIdLessThan);

	List<BookCategory> findByCategoryNameEndingWithAndCategoryIdLessThan(String categoryNameEndingWith,
			Long categoryIdLessThan);

	List<BookCategory> findByCategoryIdNot(Long categoryId);

	List<BookCategory> findByCategoryNameContainingOrderByCategoryNameDesc(String categoryNameContaining);

	List<BookCategory> findByCategoryIdLessThanOrderByCategoryNameAsc(Long categoryIdLessThan);
}
