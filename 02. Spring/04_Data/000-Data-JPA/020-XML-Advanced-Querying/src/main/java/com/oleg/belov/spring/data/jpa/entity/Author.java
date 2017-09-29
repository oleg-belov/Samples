package com.oleg.belov.spring.data.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="author_id")
	private Long authorId;

	@Temporal(TemporalType.DATE)
	@Column(name="author_date_of_birth")
	private Date authorDateOfBirth;

	@Column(name="author_img")
	private byte[] authorImg;

	@Column(name="author_name")
	private String authorName;

	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="authors")
	private List<Book> books;

	public Author() {
	}

	public Long getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Date getAuthorDateOfBirth() {
		return this.authorDateOfBirth;
	}

	public void setAuthorDateOfBirth(Date authorDateOfBirth) {
		this.authorDateOfBirth = authorDateOfBirth;
	}

	public byte[] getAuthorImg() {
		return this.authorImg;
	}

	public void setAuthorImg(byte[] authorImg) {
		this.authorImg = authorImg;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorDateOfBirth=" + authorDateOfBirth + ", authorImg="
				+ Arrays.toString(authorImg) + ", authorName=" + authorName + ", books=" + books + "]";
	}
}