package com.example.tennis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTennis {

	public static void main(String[] args) {
		TestTennis tennis = null;
		TennisService service = null;
		Game game = null;
		try {
			
			Player player1 = new Player(1, "Sania Mirza", Score.ZERO,0,0,false);
			Player player2 = new Player(2, "Sharapova", Score.ZERO,0,0,false);
			service = new TennisService(player1, player2);
			game = new Game(player1, player2);
			
			tennis = new TestTennis();
			tennis.getInput(service, game);			
			
		} catch (Exception exp) {
			System.out.println("Exception :"+exp.getMessage());
			tennis.getInput(service, game);
		}
	}
	
	
	public void getInput(TennisService service, Game game) {
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("If Player1 wins enter 1 or if Player2 wins enter 2 : ");  
		int palyerNo =  sc.nextInt();  
		
		if(palyerNo == 1 || palyerNo == 2) {
			if(game.isGameTie()) {				
				String result = service.playForTieBreak(palyerNo, game);
				System.out.println(result);
			} else {
				String result = service.play(palyerNo);				
				System.out.println(result);
				checkGameWinner(game);
			}
			if(game.getGameWinner() != null) {
				System.out.println(" ***** The Game winner is : " + game.getGameWinner().getName());
				System.exit(0);
			} else {
				getInput(service, game);
			}
		} else {
			throw new InputMismatchException("Please enter either 1 or 2");
		}
	}
	
	private void checkGameWinner(Game game) {
		if((game.getPlayer1().getSetCount() == 6 && game.getPlayer2().getSetCount() <= 4) ||
				(game.getPlayer1().getSetCount() == 7 && game.getPlayer2().getSetCount() == 5)) {
			game.setGameWinner(game.getPlayer1());			
		} else if((game.getPlayer2().getSetCount() == 6 && game.getPlayer1().getSetCount() <= 4)||
				(game.getPlayer2().getSetCount() == 7 && game.getPlayer1().getSetCount() == 5)) {
			game.setGameWinner(game.getPlayer2());			
		} if (game.getPlayer1().getSetCount() == 6 && game.getPlayer2().getSetCount() ==6) {
			game.setGameTie(true);
			System.out.println("\n ****** The Game is tie and Tie-Brek rule activated ****** \n");
		}		
	}
}
