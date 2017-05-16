package com.oleg.belov.spring.dao.jdbc.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleg.belov.spring.dao.jdbc.entity.Author;
import com.oleg.belov.spring.dao.jdbc.entity.Book;
import com.oleg.belov.spring.dao.jdbc.repository.AuthorRepository;
import com.oleg.belov.spring.dao.jdbc.repository.BookRepository;

@Service
public class BLibraryServiceImpl implements BLibraryService<Book> {
	
	private BookRepository bookRepository;
	private AuthorRepository authorReporitory;
	
	@Autowired
	public BLibraryServiceImpl(BookRepository bookRepository, AuthorRepository authorReporitory) {
		this.bookRepository = bookRepository;
		this.authorReporitory = authorReporitory;
	}
	
	@Override
	public int getNumberOfBooks() {
		return bookRepository.getNumberOfBooks();
	}
	
	@Override
	public Book getById(Long id) {
		return bookRepository.getById(id);
	}
	
	@Override
	public Map<String, Object> getByIdInMap(Long id) {
		return bookRepository.getByIdInMap(id);
	}
	
	@Override
	public List<Map<String, Object>> getAllBooksInMap() {
		return bookRepository.getAllBooksInMap();
	}
	
	@Override
	public Book getByDateAndLanguage(int year, String language) {
		return bookRepository.getByDateAndLanguage(year, language);
	}
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.getAllBooks();
	}
	
	@Override
	public int insertAuthor(String name, Date birthDate) {
		return authorReporitory.insertAuthor(name, birthDate);
	}
	
	@Override
	public int updateAuthorBirthDateById(Long id, Date birthDate) {
		return authorReporitory.updateAuthorBirthDateById(id, birthDate);
	}
	
	@Override
	public void dropAuthorTable() {
		authorReporitory.dropAuthorTable();
	}
	
	@Override
	public int[] insertAuthorsList(List<Author> authors) {
		return authorReporitory.insertAuthorsList(authors);
	}
	
	@Override
	public int[] insertAuthorsListByPS(List<Author> authors) {
		return authorReporitory.insertAuthorsListByPS(authors);
	}
}
