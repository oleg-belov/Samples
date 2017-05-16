package com.oleg.belov.spring.dao.jdbc.repository;

import java.util.List;
import java.util.Map;

import com.oleg.belov.spring.dao.jdbc.entity.Book;

public interface BookRepository {
	public int getNumberOfBooks();
	public Book getById(Long id);
	public Map<String, Object> getByIdInMap(Long id);
	public List<Map<String, Object>> getAllBooksInMap();
	public Book getByDateAndLanguage(int year, String language);
	public List<Book> getAllBooks();
}
