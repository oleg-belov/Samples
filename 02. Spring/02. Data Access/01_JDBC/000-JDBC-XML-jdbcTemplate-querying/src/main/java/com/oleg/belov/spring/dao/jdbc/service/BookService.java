package com.oleg.belov.spring.dao.jdbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oleg.belov.spring.dao.jdbc.entity.Book;
import com.oleg.belov.spring.dao.jdbc.repository.BookRepository;

@Service
public class BookService{
	
	BookRepository bookRepository;

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public int getNumberOfBooks() {
		return bookRepository.getNumberOfBooks();
	}

	public List<String> getAllBookNames() {
		return bookRepository.getAllBookNames();
	}

	public Book getBookByName(String name) {
		return bookRepository.getBookByName(name);
	}
	
}
