package com.oleg.belov.spring.dao.jdbc.repository.jdbc;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.dao.jdbc.repository.AuthorRepository;

@Repository
public class JDBCAuthorRepositoryImpl implements AuthorRepository {
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int insertAuthor(String name, Date birthDate) {
		String sql = "INSERT INTO author(author_name, author_date_of_birth) VALUES(?, ?)";
		
		return jdbcTemplate.update(sql, name, birthDate);
	}
	
	@Override
	public int updateAuthorBirthDateById(Long id, Date birthDate) {
		String sql = "UPDATE author SET author_date_of_birth = ? WHERE author_id= ?";
		
		//or return jdbcTemplate.update(sql, new Object[]{birthDate, id});
		return jdbcTemplate.update(sql, birthDate, id);
	}
	
	@Override
	public void dropAuthorTable() {
		String sql = "DROP TABLE author";
		
		jdbcTemplate.execute(sql);
	}
}
