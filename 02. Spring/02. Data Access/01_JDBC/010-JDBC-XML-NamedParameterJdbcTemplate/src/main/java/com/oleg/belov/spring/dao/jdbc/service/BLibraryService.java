package com.oleg.belov.spring.dao.jdbc.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.oleg.belov.spring.dao.jdbc.entity.Author;

public interface BLibraryService<T> {
	public int getNumberOfBooks();
	public T getById(Long id);
	public Map<String, Object> getByIdInMap(Long id);
	public List<Map<String, Object>> getAllBooksInMap();
	public T getByDateAndLanguage(int year, String language);
	public List<T> getAllBooks();
	public int insertAuthor(String name, Date birthDate);
	public int updateAuthorBirthDateById(Long id, Date birthDate);
	public void dropAuthorTable();
	int[] insertAuthorsList(List<Author> authors);
	int[] insertAuthorsListByPS(List<Author> authors);
}
