package com.oleg.belov.spring.data.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="Vote.findAll", query="SELECT v FROM Vote v")
public class Vote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vote_id")
	private Integer voteId;

	@Column(name="vote_value")
	private Integer voteValue;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;

	public Vote() {
	}

	public Integer getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public Integer getVoteValue() {
		return this.voteValue;
	}

	public void setVoteValue(Integer voteValue) {
		this.voteValue = voteValue;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", voteValue=" + voteValue + ", book=" + book + "]";
	}
}