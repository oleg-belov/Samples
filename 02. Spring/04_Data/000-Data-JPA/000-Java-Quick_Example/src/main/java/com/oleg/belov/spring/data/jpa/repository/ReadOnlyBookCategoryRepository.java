package com.oleg.belov.spring.data.jpa.repository;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

public interface ReadOnlyBookCategoryRepository extends ReadOnlyRepository<BookCategory, Long> {

}
