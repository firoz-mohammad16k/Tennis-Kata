package com.example.tennis;

public class Player {
	
	private int id;
	private String name;
	private Score score;
	private int scorePoint;	
	private boolean isWinnigShot;
	private int setCount;
	
	public Player(int id, String name, Score score, int scorePoint, int setCount,
			boolean isWinnigShot) {
		this.setId(id);
		this.setName(name);
		this.setScore(score);
		this.scorePoint = scorePoint;
		this.setCount = setCount;
		this.isWinnigShot = isWinnigShot;
	}		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	public int getScorePoint() {
		return scorePoint;
	}
	public void setScorePoint(int scorePoint) {
		this.scorePoint = scorePoint;
	}
	
	public boolean isWinnigShot() {
		return isWinnigShot;
	}

	public void setWinnigShot(boolean isWinnigShot) {
		this.isWinnigShot = isWinnigShot;
	}

	public int getSetCount() {
		return setCount;
	}

	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}

	
}
