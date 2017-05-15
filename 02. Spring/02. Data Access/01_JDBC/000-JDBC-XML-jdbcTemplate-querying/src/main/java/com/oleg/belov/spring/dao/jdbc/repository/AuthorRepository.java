package com.oleg.belov.spring.dao.jdbc.repository;

import java.util.Date;

public interface AuthorRepository {
	public int insertAuthor(String name, Date birthDate);
	public int updateAuthorBirthDateById(Long id, Date birthDate);
	public void dropAuthorTable();
}
