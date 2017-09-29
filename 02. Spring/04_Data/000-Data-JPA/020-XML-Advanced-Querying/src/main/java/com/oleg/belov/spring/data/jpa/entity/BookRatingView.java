package com.oleg.belov.spring.data.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="book_rating_view")
@NamedQuery(name="BookRatingView.findAll", query="SELECT b FROM BookRatingView b")
public class BookRatingView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rating_id")
	private Long ratingId;

	@Column(name="rating_value")
	private BigDecimal ratingValue;

	public BookRatingView() {
	}

	public Long getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public BigDecimal getRatingValue() {
		return this.ratingValue;
	}

	public void setRatingValue(BigDecimal ratingValue) {
		this.ratingValue = ratingValue;
	}

	@Override
	public String toString() {
		return "BookRatingView [ratingId=" + ratingId + ", ratingValue=" + ratingValue + "]";
	}
}