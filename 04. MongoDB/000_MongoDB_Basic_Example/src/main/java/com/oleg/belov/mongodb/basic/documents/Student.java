package com.oleg.belov.mongodb.basic.documents;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Student {
	
	@SerializedName("_id")
	private Long id;
	private String name;
	private List<Score> scores;

	public Student() {
	}

	public Student(String name, String lastName, List<Score> scores) {
		this.name = name;
		this.scores = scores;
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

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return String.format("Student[id=%s, name='%s', scores='%s']", id,
				name, scores.toString());
	}

}
