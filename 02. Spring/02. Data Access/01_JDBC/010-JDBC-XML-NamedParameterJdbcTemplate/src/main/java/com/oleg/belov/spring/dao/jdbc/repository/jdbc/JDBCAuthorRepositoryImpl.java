package com.oleg.belov.spring.dao.jdbc.repository.jdbc;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.dao.jdbc.entity.Author;
import com.oleg.belov.spring.dao.jdbc.repository.AuthorRepository;

@Repository
public class JDBCAuthorRepositoryImpl implements AuthorRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int insertAuthor(String name, Date birthDate) {
		String sql = "INSERT INTO author(author_name, author_date_of_birth) VALUES(:authorName, :authorBirthDate)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		
		namedParameters.put("authorName", name);
		namedParameters.put("authorBirthDate", birthDate);
		
		return namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	
	@Override
	public int updateAuthorBirthDateById(Long id, Date birthDate) {
		String sql = "UPDATE author SET author_date_of_birth = :authorBirthDate WHERE author_id= :authorId";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		
		namedParameters.put("authorId", id);
		namedParameters.put("authorBirthDate", birthDate);
		
		return namedParameterJdbcTemplate.update(sql,namedParameters);
	}
	
	@Override
	public void dropAuthorTable() {
		String sql = "DROP TABLE author";
		
		jdbcTemplate.execute(sql);
	}

	@Override
	public int[] insertAuthorsList(List<Author> authors) {
		String sql = "INSERT INTO author(author_name, author_date_of_birth) VALUES(:name, :birthDate)";
		SqlParameterSource[] authorsList = SqlParameterSourceUtils.createBatch(authors.toArray());
		
		int[] updateCount = namedParameterJdbcTemplate.batchUpdate(sql, authorsList);
		
		return updateCount;
	}
	
	@Override
	public int[] insertAuthorsListByPS(List<Author> authors) {
		String sql = "INSERT INTO author(author_name, author_date_of_birth) VALUES(?, ?)";
		
		int[] updateCount = jdbcTemplate.batchUpdate(sql, 
				new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, authors.get(i).getName());
						ps.setDate(2, new java.sql.Date(authors.get(i).getBirthDate().getTime()));
					}
					
					@Override
					public int getBatchSize() {
						return authors.size();
					}
				});
		
		return updateCount;
	}
	
	
}
