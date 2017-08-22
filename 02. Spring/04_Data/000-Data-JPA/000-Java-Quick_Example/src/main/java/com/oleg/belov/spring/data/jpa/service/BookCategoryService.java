package com.oleg.belov.spring.data.jpa.service;

import java.util.ArrayList;
import java.util.List;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

public interface BookCategoryService {
	void save(BookCategory bookCategory);

	List<BookCategory> findAll(ArrayList<Long> arrayList);

	BookCategory findOneById(long id);
	
	void delete(Long id);
	
	void delete(BookCategory bookCategory);

	void delete(List<BookCategory> list);

	void deleteInBatch(List<BookCategory> list);

	void deleteAll();

	void deleteAllInBatch();

	List<BookCategory> findAllUseReadOnlyRepository();

}
