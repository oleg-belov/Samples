package com.oleg.belov.mongodb.basic.documents;

public class Score {
	private String type;
	private double score;
	
	public Score() {}

	public Score(String type, double score) {
		super();
		this.type = type;
		this.score = score;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score [type=" + type + ", score=" + score + "]";
	}
}
