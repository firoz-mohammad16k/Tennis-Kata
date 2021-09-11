package com.example.tennis;

public class TennisService {

	private Player player1;
	private Player player2;
	
	TennisService(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;		
	}
	public String play(int point) {		
		
		if(point == 1) {			
			player1.setScorePoint(player1.getScorePoint() +1);
			if (player1.getScorePoint() == 3 && player2.getScorePoint() ==3) {
				activeDeuse();
				return getResult() + "\n" + " ***** DEUCE Rule Active *****";
			}
			checkWinnigShot();
			if(player1.isWinnigShot()) {
				reInitializePlayers();				
				return player1.getName() + " won the set \n" + getTotalSetCount();
			} else {
				if(player1.getScore() == Score.DEUSE) {
					player1.setScore(Score.ADVANTAGE);
					player2.setScore(Score.DEUSE);
					player2.setScorePoint(3);
				} else {
					setScore(player1.getScorePoint(), player1);
				}
			}
		} else {
			player2.setScorePoint(player2.getScorePoint() +1);
			if (player1.getScorePoint() == 3 && player2.getScorePoint() ==3) {
				activeDeuse();				
				return getResult() + "\n" + "**** DEUCE Rule Active *****";				
			}
			checkWinnigShot();
			
			if(player2.isWinnigShot()) {
				reInitializePlayers();
				return player2.getName() + " won the set \n" + getTotalSetCount();
			} else {
				if(player2.getScore() == Score.DEUSE) {
					player2.setScore(Score.ADVANTAGE);
					player1.setScore(Score.DEUSE);
					player1.setScorePoint(3);
				} else {
					setScore(player2.getScorePoint(), player2);
				}
			}
		}		
				
		
		return getResult();
	}	
	
	public String playForTieBreak(int point, Game game) {			
		if(point == 1) {			
			player1.setScorePoint(player1.getScorePoint() +1);			
			checkWinnigShotForTieBreak(game);	
			if(player1.isWinnigShot()) {
				return "The Game winner is :" + player1.getName();
			} else {
				
			}
		} else {
			player2.setScorePoint(player2.getScorePoint() +1);
			checkWinnigShotForTieBreak(game);
			if(player2.isWinnigShot()) {
				return "The Game winner is :" + player2.getName();
			} 
		}				
		
		return player1.getName() +" score :" + player1.getScorePoint() + "\n" 
		+ player2.getName() +" score :" + player2.getScorePoint();
	}	
		
	private void checkWinnigShot() {
		if((player1.getScorePoint()>3 && player2.getScorePoint() < 3) || 
				(player2.getScorePoint()>3 && player1.getScorePoint() < 3)) {
			getLeadPlayer().setWinnigShot(true);
        	getLeadPlayer().setSetCount(getLeadPlayer().getSetCount() +1);
		} else if (player1.getScorePoint() >= 3 && player2.getScorePoint() >= 3) {
            if (Math.abs(player2.getScorePoint() - player1.getScorePoint()) >= 2) {
            	getLeadPlayer().setWinnigShot(true);
            	getLeadPlayer().setSetCount(getLeadPlayer().getSetCount() +1);                         
            }          
        }  		
	}	
	
	private void checkWinnigShotForTieBreak(Game game) {
		if (player1.getScorePoint() >= 6 && player2.getScorePoint() >= 6) {
            if (Math.abs(player2.getScorePoint() - player1.getScorePoint()) >= 2) {
            	getLeadPlayer().setWinnigShot(true);    
            	game.setGameWinner(getLeadPlayer());
            }          
        }  		
	}
	
	private void activeDeuse() {		
    	player1.setScore(Score.DEUSE);
    	player2.setScore(Score.DEUSE);               
	}
	
	public Player getLeadPlayer() {
        return (player1.getScorePoint() > player2.getScorePoint()) ? player1 : player2;
    }
	
	private void setScore(int scorePoint, Player player) {
		
		 switch(scorePoint){  
		    //Case statements  
		    case 1: 
		    	player.setScore(Score.FIFTEEN);
		    	break;  
		    case 2: 
		    	player.setScore(Score.THIRTY);
		    	break;  
		    case 3: 
		    	player.setScore(Score.FOURTY);
		    	break;  		   
		    //Default case statement  
		    default:
		    	player.setScore(Score.ZERO); 
		    	break;
	    } 
	}
	
	private void reInitializePlayers() {
		player1.setScore(Score.ZERO);
		player1.setScorePoint(0);
		player1.setWinnigShot(false);
		
		player2.setScore(Score.ZERO);
		player2.setScorePoint(0);
		player2.setWinnigShot(false);
	}
	
	private String getResult() {
		return player1.getName() +" score :" + player1.getScore().score + "\n" 
				+ player2.getName() +" score :" + player2.getScore().score;
	}
	
	private String getTotalSetCount() {
		return "Total No Of Sets won by " + player1.getName() + " : " + player1.getSetCount() + "\n" 
				+ "Total No Of Sets won by " + player2.getName() + " : " + player2.getSetCount();
	}
	
	
}
