package com.example.tennis;

public class Game {
	private Player player1;
	private Player player2;
	private Player gameWinner;
	private boolean gameTie;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public Player getGameWinner() {
		return gameWinner;
	}

	public void setGameWinner(Player gameWinner) {
		this.gameWinner = gameWinner;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}

	public boolean isGameTie() {
		return gameTie;
	}

	public void setGameTie(boolean gameTie) {
		this.gameTie = gameTie;
	}
}
