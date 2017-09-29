package com.oleg.belov.spring.data.jpa.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

public interface BookStoreService {

	public List<BookCategory> findByCategoryIdGreaterThan(Long categoryId, Sort sort);
	public List<BookCategory> findByCategoryIds(List<Long> categoryIds);
}
