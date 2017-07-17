package com.oleg.belov.mongodb.basic.documents;

public class Grade {
	private Object  date;
	private char grade;
	private int score;

	public Grade() {
	}
	
	public Grade(Object date, char grade, int score) {
		this.date = date;
		this.grade = grade;
		this.score = score;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
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

	@Override
	public String toString() {
		return "Grade [date=" + date + ", grade=" + grade + ", score=" + score + "]";
	}
}
