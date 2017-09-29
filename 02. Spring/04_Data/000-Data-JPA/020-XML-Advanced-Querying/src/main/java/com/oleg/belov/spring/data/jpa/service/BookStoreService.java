package com.oleg.belov.spring.data.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

public interface BookStoreService {

	List<BookCategory> findAllBookCategorys();

	List<BookCategory> findByCategoryIdLessThanEqual(Long categoryIdLessThanEqual);

	List<BookCategory> findByCategoryName(String categoryName);

	List<BookCategory> findByCategoryIdGteaterThanEquals(Long categoryIdGreaterThanEqual);

	Page<BookCategory> findAllByPage(Pageable pageRequest);

	Page<BookCategory> findByCategoryIdGreaterThanPageable(Long categoryIdGreaterThan, Pageable pageRequest);

	List<BookCategory> findAllSort(Sort sort);
}
