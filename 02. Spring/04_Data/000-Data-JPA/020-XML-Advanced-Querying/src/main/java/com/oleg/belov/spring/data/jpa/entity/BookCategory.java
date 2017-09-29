package com.oleg.belov.spring.data.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="book_category")
@NamedQueries({ @NamedQuery(name="BookCategory.findAll", query="SELECT b FROM BookCategory b"),
	@NamedQuery(name="BookCategory.findByCategoryIdGteaterThanEquals", query="SELECT b FROM BookCategory b where b.categoryId >= ?1")
})
public class BookCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="category_id")
	private Long categoryId;

	@Column(name="category_name")
	private String categoryName;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="bookCategory")
	private List<Book> books;

	public BookCategory() {
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setBookCategory(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setBookCategory(null);

		return book;
	}

	@Override
	public String toString() {
		return "BookCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
}