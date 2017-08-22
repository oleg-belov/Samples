package com.oleg.belov.spring.data.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;
import com.oleg.belov.spring.data.jpa.repository.BookCategoryRepository;
import com.oleg.belov.spring.data.jpa.repository.ReadOnlyBookCategoryRepository;
import com.oleg.belov.spring.data.jpa.service.BookCategoryService;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
	@Autowired
	private BookCategoryRepository bookCategoryRepository;
	
	@Autowired
	private ReadOnlyBookCategoryRepository readOnlyRookCategoryRepository;
	
	@Override
	public void save(BookCategory bookCategory) {
		bookCategoryRepository.save(bookCategory);
	}

	@Override
	public List<BookCategory> findAll(ArrayList<Long> arrayList) {
		return bookCategoryRepository.findAll(arrayList);
	}

	@Override
	public BookCategory findOneById(long id) {
		return bookCategoryRepository.findOne(id);
	}
	
	@Override
	public void delete(Long id) {
		bookCategoryRepository.delete(id);
	}

	@Override
	public void delete(BookCategory bookCategory) {
		bookCategoryRepository.delete(bookCategory);		
	}

	@Override
	public void delete(List<BookCategory> list) {
		bookCategoryRepository.delete(list);
	}

	@Override
	public void deleteInBatch(List<BookCategory> list) {
		bookCategoryRepository.deleteInBatch(list);
	}

	@Override
	public void deleteAll() {
		bookCategoryRepository.deleteAll();
	}

	@Override
	public void deleteAllInBatch() {
		bookCategoryRepository.deleteAllInBatch();
	}

	@Override
	public List<BookCategory> findAllUseReadOnlyRepository() {
		return readOnlyRookCategoryRepository.findAll();
	}

}
