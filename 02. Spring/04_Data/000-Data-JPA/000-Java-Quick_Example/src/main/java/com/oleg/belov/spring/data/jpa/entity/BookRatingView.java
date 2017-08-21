package com.oleg.belov.spring.data.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the book_rating_view database table.
 * 
 */
@Entity
@Table(name="book_rating_view")
@NamedQuery(name="BookRatingView.findAll", query="SELECT b FROM BookRatingView b")
public class BookRatingView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="rating_id")
	private Integer ratingId;

	@Column(name="rating_value")
	private BigDecimal ratingValue;

	public BookRatingView() {
	}

	public Integer getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public BigDecimal getRatingValue() {
		return this.ratingValue;
	}

	public void setRatingValue(BigDecimal ratingValue) {
		this.ratingValue = ratingValue;
	}

}