package com.oleg.belov.spring.dao.jdbc.repository;

import java.util.Date;
import java.util.List;

import com.oleg.belov.spring.dao.jdbc.entity.Author;

public interface AuthorRepository {
	public int insertAuthor(String name, Date birthDate);
	public int updateAuthorBirthDateById(Long id, Date birthDate);
	public void dropAuthorTable();
	public int[] insertAuthorsList(List<Author> authors);
	public int[] insertAuthorsListByPS(List<Author> authors);
}
