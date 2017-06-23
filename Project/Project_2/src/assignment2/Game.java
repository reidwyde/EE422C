package assignment2;

import java.util.Scanner;

public class Game {
	String answer;
	String [] colors;
	int guessNumber;
	int pegs;
	History gameHistory;

	public Game(boolean bool){
		answer = SecretCodeGenerator.getInstance().getNewSecretCode();
		guessNumber = GameConfiguration.guessNumber;
		colors = GameConfiguration.colors;
		pegs = GameConfiguration.pegNumber;
		gameHistory = new History(guessNumber);
		if(bool){
			System.out.println("Secret code: " + answer);
		}
		System.out.println();
	}
	
	public void runGame(Scanner scan){
		while(guessNumber > 0){
			System.out.println("You have " + guessNumber + " guess(es) left.");
			System.out.println("Enter guess:");
			String guess = scan.next();
			if(guess.equals("HISTORY")){
				gameHistory.printHistory();
				System.out.println();
			}
			else if(guess.length() != pegs){
				System.out.println("INVALID_GUESS");
			}
			else if(!Header.validColors(guess, colors)){
				System.out.println("INVALID_GUESS");			
			}
			else{
				Node r_guess = Header.determineMatch(guess, answer, pegs);
				if(r_guess.match){
					System.out.println("You win!");
					System.out.println();

					
					return;
				}
				else{
					gameHistory.insertHistory(r_guess);
					guessNumber--;
					if(guessNumber == 0){
						break;
					}
					System.out.println();
				}
			}
		}
		
		System.out.println("You lose! The pattern was " + answer);
		System.out.println();
	}
}
