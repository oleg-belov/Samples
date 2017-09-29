package com.oleg.belov.spring.data.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;
import com.oleg.belov.spring.data.jpa.repository.BookCategoryRepository;
import com.oleg.belov.spring.data.jpa.service.BookStoreService;

@Service
public class BookStoreServsiceImpl implements BookStoreService {
	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@Override
	public List<BookCategory> findByCategoryName(String categoryName) {
		return bookCategoryRepository.findByCategoryName(categoryName);
	}

	@Override
	public List<BookCategory> findByCategoryNameLike(String categoryNameLike) {
		return bookCategoryRepository.findByCategoryNameLike(categoryNameLike);
	}

	@Override
	public List<BookCategory> findByCategoryNameContaining(String categoryNameContaining) {
		return bookCategoryRepository.findByCategoryNameContaining(categoryNameContaining);
	}

	@Override
	public List<BookCategory> findByCategoryNameStartingWith(String categoryNameStartingWith) {
		return bookCategoryRepository.findByCategoryNameStartingWith(categoryNameStartingWith);
	}

	@Override
	public List<BookCategory> findByCategoryNameEndingWith(String categoryNameEndingWith) {
		return bookCategoryRepository.findByCategoryNameEndingWith(categoryNameEndingWith);
	}

	@Override
	public List<BookCategory> findByCategoryNameIgnoreCase(String categoryNameIgnoreCase) {
		return bookCategoryRepository.findByCategoryNameIgnoreCase(categoryNameIgnoreCase);
	}

	@Override
	public List<BookCategory> findByCategoryIdEquals(Long categoryId) {
		return bookCategoryRepository.findByCategoryIdEquals(categoryId);
	}

	@Override
	public List<BookCategory> findByCategoryIdGreaterThan(Long categoryIdGreaterThan) {
		return bookCategoryRepository.findByCategoryIdGreaterThan(categoryIdGreaterThan);
	}

	@Override
	public List<BookCategory> findByCategoryIdLessThan(Long categoryIdLessThan) {
		return bookCategoryRepository.findByCategoryIdLessThan(categoryIdLessThan);
	}

	@Override
	public List<BookCategory> findByCategoryIdGreaterThanEqual(Long categoryIdGreaterThanEqual) {
		return bookCategoryRepository.findByCategoryIdGreaterThanEqual(categoryIdGreaterThanEqual);
	}

	@Override
	public List<BookCategory> findByCategoryIdLessThanEqual(Long categoryIdLessThanEqual) {
		return bookCategoryRepository.findByCategoryIdLessThanEqual(categoryIdLessThanEqual);
	}

	@Override
	public List<BookCategory> findByCategoryIdBetween(Long categoryIdBetweenMin, Long categoryIdBetweenMax) {
		return bookCategoryRepository.findByCategoryIdBetween(categoryIdBetweenMin, categoryIdBetweenMax);
	}

	@Override
	public List<BookCategory> findByCategoryNameContainingOrCategoryIdLessThan(String categoryNameContaining,
			Long categoryIdLessThan) {
		return bookCategoryRepository.findByCategoryNameContainingOrCategoryIdLessThan(categoryNameContaining, 
				categoryIdLessThan);
	}

	@Override
	public List<BookCategory> findByCategoryNameEndingWithAndCategoryIdLessThan(String categoryNameEndingWith,
			Long categoryIdLessThan) {
		return bookCategoryRepository.findByCategoryNameEndingWithAndCategoryIdLessThan(categoryNameEndingWith, 
				categoryIdLessThan);
	}

	@Override
	public List<BookCategory> findByCategoryIdNot(Long categoryId) {
		return bookCategoryRepository.findByCategoryIdNot(categoryId);
	}

	@Override
	public List<BookCategory> findByCategoryNameContainingOrderByCategoryNameDesc(String categoryNameContaining) {
		return bookCategoryRepository.findByCategoryNameContainingOrderByCategoryNameDesc(categoryNameContaining);
	}

	@Override
	public List<BookCategory> findByCategoryIdLessThanOrderByCategoryNameAsc(Long categoryIdLessThan) {
		return bookCategoryRepository.findByCategoryIdLessThanOrderByCategoryNameAsc(categoryIdLessThan);
	}
}
