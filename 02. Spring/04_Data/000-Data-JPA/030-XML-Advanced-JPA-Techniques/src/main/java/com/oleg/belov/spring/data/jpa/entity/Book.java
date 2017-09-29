package com.oleg.belov.spring.data.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private Long bookId;

	@Column(name="book_content")
	private byte[] bookContent;

	@Column(name="book_date")
	private Integer bookDate;

	@Column(name="book_descr")
	private String bookDescr;

	@Column(name="book_img")
	private byte[] bookImg;

	@Column(name="book_language")
	private String bookLanguage;

	@Column(name="book_name")
	private String bookName;

	@Column(name="book_pages")
	private Integer bookPages;

	@Column(name="book_tupe")
	private String bookTupe;

	//bi-directional many-to-one association to BookCategory
	@ManyToOne
	@JoinColumn(name="category_id")
	private BookCategory bookCategory;

	//bi-directional many-to-many association to Author
	@ManyToMany
	@JoinTable(
		name="book_author"
		, joinColumns={
			@JoinColumn(name="book_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="author_id")
			}
		)
	private List<Author> authors;

	//bi-directional many-to-one association to Vote
	@OneToMany(mappedBy="book")
	private List<Vote> votes;

	public Book() {
	}

	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public byte[] getBookContent() {
		return this.bookContent;
	}

	public void setBookContent(byte[] bookContent) {
		this.bookContent = bookContent;
	}

	public Integer getBookDate() {
		return this.bookDate;
	}

	public void setBookDate(Integer bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookDescr() {
		return this.bookDescr;
	}

	public void setBookDescr(String bookDescr) {
		this.bookDescr = bookDescr;
	}

	public byte[] getBookImg() {
		return this.bookImg;
	}

	public void setBookImg(byte[] bookImg) {
		this.bookImg = bookImg;
	}

	public String getBookLanguage() {
		return this.bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getBookPages() {
		return this.bookPages;
	}

	public void setBookPages(Integer bookPages) {
		this.bookPages = bookPages;
	}

	public String getBookTupe() {
		return this.bookTupe;
	}

	public void setBookTupe(String bookTupe) {
		this.bookTupe = bookTupe;
	}

	public BookCategory getBookCategory() {
		return this.bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Vote> getVotes() {
		return this.votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public Vote addVote(Vote vote) {
		getVotes().add(vote);
		vote.setBook(this);

		return vote;
	}

	public Vote removeVote(Vote vote) {
		getVotes().remove(vote);
		vote.setBook(null);

		return vote;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookContent=" + Arrays.toString(bookContent) + ", bookDate=" + bookDate
				+ ", bookDescr=" + bookDescr + ", bookImg=" + Arrays.toString(bookImg) + ", bookLanguage="
				+ bookLanguage + ", bookName=" + bookName + ", bookPages=" + bookPages + ", bookTupe=" + bookTupe
				+ ", bookCategory=" + bookCategory + ", authors=" + authors + ", votes=" + votes + "]";
	}
}