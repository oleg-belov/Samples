package com.oleg.belov.spring.dao.jdbc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.dao.jdbc.entity.Book;

@Repository
public class BookRepository{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getNumberOfBooks() {
		String sql = "SELECT COUNT(*) FROM book";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public List<String> getAllBookNames() {
		String sql = "SELECT book_name FROM book";
		return jdbcTemplate.queryForList(sql);
	}
	
	public Book getBookByName(String name) {
		String sql = "SELECT * FROM book WHERE book_name = ?"
		return jdbcTemplate.queryForObject(sql, new Book);
	}
	
}
