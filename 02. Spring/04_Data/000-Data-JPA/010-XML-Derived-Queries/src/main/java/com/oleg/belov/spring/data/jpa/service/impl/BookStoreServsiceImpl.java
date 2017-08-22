package com.oleg.belov.spring.data.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleg.belov.spring.data.jpa.repository.BookCategoryRepository;
import com.oleg.belov.spring.data.jpa.service.BookStoreService;

@Service
public class BookStoreServsiceImpl implements BookStoreService {
	@Autowired
	private BookCategoryRepository bookCategoryRepository;

}
