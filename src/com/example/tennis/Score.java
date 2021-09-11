package com.example.tennis;

public enum Score {

	ZERO(0),FIFTEEN(15),THIRTY(30),FOURTY(40),DEUSE(40),ADVANTAGE(50);
	
	int score;
	Score(int score){
		this.score = score;
	}
}
