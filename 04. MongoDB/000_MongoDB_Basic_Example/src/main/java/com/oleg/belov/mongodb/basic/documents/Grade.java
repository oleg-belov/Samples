package com.oleg.belov.mongodb.basic.documents;

import java.util.Date;

public class Grade {
	private Date  date;
	private char grade;
	private int score;

	public Grade() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
