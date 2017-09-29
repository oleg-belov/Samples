package com.oleg.belov.spring.data.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;
import com.oleg.belov.spring.data.jpa.repository.BookCategoryRepository;
import com.oleg.belov.spring.data.jpa.service.BookStoreService;

@Service
public class BookStoreServsiceImpl implements BookStoreService {
	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@Override
	public List<BookCategory> findByCategoryIdGreaterThan(Long categoryId, Sort sort) {
		return bookCategoryRepository.findByCategoryIdGreaterThan(categoryId, sort);
	}

	@Override
	public List<BookCategory> findByCategoryIds(List<Long> categoryIds) {
		return bookCategoryRepository.findByCategoryId(categoryIds);
	}
}
