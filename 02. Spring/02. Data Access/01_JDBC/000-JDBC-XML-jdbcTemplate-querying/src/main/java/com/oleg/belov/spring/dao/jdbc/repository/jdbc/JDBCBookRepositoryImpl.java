package com.oleg.belov.spring.dao.jdbc.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.dao.jdbc.entity.Book;
import com.oleg.belov.spring.dao.jdbc.repository.BookRepository;

@Repository
public class JDBCBookRepositoryImpl implements BookRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getNumberOfBooks() {
		String sql = "SELECT COUNT(*) FROM book";
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public Book getById(Long id) {
		String sql = "SELECT * FROM book WHERE book_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{id},
			new RowMapper<Book>() {
				public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
					Book book = new Book();
					book.setId(rs.getLong("book_id"));
					book.setName(rs.getString("book_name"));
					book.setDescr(rs.getString("book_descr"));
					book.setPages(rs.getInt("book_pages"));
					book.setYear(rs.getInt("book_date"));
					book.setLanguage(rs.getString("book_language"));
					book.setCategoryId(rs.getLong("category_id"));
					book.setTupe(rs.getString("book_tupe"));
					
					return book;
				}
		});
	}

	@Override
	public Map<String, Object> getByIdInMap(Long id) {
		String sql = "SELECT * FROM book WHERE book_id = ?";
		
		return jdbcTemplate.queryForMap(sql, new Object[]{id});
	}
	
	@Override
	public List<Map<String, Object>> getAllBooksInMap() {
		String sql = "SELECT * FROM book";
		
		return jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public Book getByDateAndLanguage(int year, String language) {
		String sql = "SELECT * FROM book WHERE book_date = ? AND book_language = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{year, language}, new BookMapper());
	}
	
	@Override
	public List<Book> getAllBooks() {
		String sql = "SELECT * FROM book";
		
		return jdbcTemplate.query(sql, new BookMapper());
	}
	
	private static final class BookMapper implements RowMapper<Book> {
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setId(rs.getLong("book_id"));
			book.setName(rs.getString("book_name"));
			book.setDescr(rs.getString("book_descr"));
			book.setPages(rs.getInt("book_pages"));
			book.setYear(rs.getInt("book_date"));
			book.setLanguage(rs.getString("book_language"));
			book.setCategoryId(rs.getLong("category_id"));
			book.setTupe(rs.getString("book_tupe"));
			
			return book;
		}
	}
}
