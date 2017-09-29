package com.oleg.belov.spring.data.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public List<BookCategory> findAllBookCategorys() {
		return bookCategoryRepository.findAllBookCategorys();
	}

	@Override
	public List<BookCategory> findByCategoryIdLessThanEqual(Long categoryIdLessThanEqual) {
		return bookCategoryRepository.findByCategoryIdLessThanEquals(categoryIdLessThanEqual);
	}

	@Override
	public List<BookCategory> findByCategoryName(String categoryName) {
		return bookCategoryRepository.findByCategoryName(categoryName);
	}

	@Override
	public List<BookCategory> findByCategoryIdGteaterThanEquals(Long categoryIdGreaterThanEqual) {
		return bookCategoryRepository.findByCategoryIdGteaterThanEquals(categoryIdGreaterThanEqual);
	}

	@Override
	public Page<BookCategory> findAllByPage(Pageable pageRequest) {
		return bookCategoryRepository.findAll(pageRequest);
	}

	@Override
	public Page<BookCategory> findByCategoryIdGreaterThanPageable(Long categoryIdGreaterThan, Pageable pageRequest) {
		return bookCategoryRepository.findByCategoryIdGreaterThan(categoryIdGreaterThan, pageRequest);
	}

	@Override
	public List<BookCategory> findAllSort(Sort sort) {
		return bookCategoryRepository.findAll(sort);
	}

}
