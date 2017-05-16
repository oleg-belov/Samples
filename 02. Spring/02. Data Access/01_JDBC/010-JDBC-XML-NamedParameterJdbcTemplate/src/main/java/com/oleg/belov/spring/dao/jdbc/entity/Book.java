package com.oleg.belov.spring.dao.jdbc.entity;

public class Book {

	private Long id;
	private String name;
	private String descr;
	private int pages;
	private int year;
	private String language;
	private Long categoryId;
	private String tupe;
	
	public Book() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTupe() {
		return tupe;
	}
	public void setTupe(String tupe) {
		this.tupe = tupe;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", descr=" + descr + ", pages=" + pages + ", year=" + year
				+ ", language=" + language + ", categoryId=" + categoryId + ", tupe=" + tupe + "]";
	}
	
}
