package com.oleg.belov.spring.data.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;
import com.oleg.belov.spring.data.jpa.repository.BookCategoryRepository;
import com.oleg.belov.spring.data.jpa.service.BookCategoryService;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
	@Autowired
	private BookCategoryRepository bookCategoryRepository;
	
	@Override
	public void save(BookCategory bookCategory) {
		bookCategoryRepository.save(bookCategory);
	}

}
