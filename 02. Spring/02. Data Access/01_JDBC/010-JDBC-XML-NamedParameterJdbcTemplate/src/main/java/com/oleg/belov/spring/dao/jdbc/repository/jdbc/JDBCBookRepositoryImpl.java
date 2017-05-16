package com.oleg.belov.spring.dao.jdbc.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.dao.jdbc.entity.Book;
import com.oleg.belov.spring.dao.jdbc.repository.BookRepository;

@Repository
public class JDBCBookRepositoryImpl implements BookRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getNumberOfBooks() {
		String sql = "SELECT COUNT(*) FROM book";
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public Book getById(Long id) {
		String sql = "SELECT * FROM book WHERE book_id = :bookId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("bookId", id);
		
		
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters,
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
		String sql = "SELECT * FROM book WHERE book_id = :bookId";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("bookId", id);
		
		return namedParameterJdbcTemplate.queryForMap(sql, namedParameters);
	}
	
	@Override
	public List<Map<String, Object>> getAllBooksInMap() {
		String sql = "SELECT * FROM book";
		
		return jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public Book getByDateAndLanguage(int year, String language) {
		String sql = "SELECT * FROM book WHERE book_date = :bookDate AND book_language = :bookLanguage";
		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("bookDate", year)
				.addValue("bookLanguage", language);
		
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new BookMapper());
	}
	
	@Override
	public List<Book> getAllBooks() {
		String sql = "SELECT * FROM book";
		
		return namedParameterJdbcTemplate.query(sql, new BookMapper());
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
