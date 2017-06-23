package assignment2;

import java.util.Scanner;

public class Driver {
	public static void main(String [] args){
		System.out.println("Welcome to Mastermind.");
		System.out.println("Do you want to play a new game? (Y/N):");
		

		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		
		
		while(c == 'Y'){//if user wants to cont playing))
			if(args.length != 0){
				if(args[0].equals("1")){
					Game g = new Game(true);
					g.runGame(sc);
				}	
				else{
					Game g = new Game(false);
					g.runGame(sc);
				}
			}
			else{
				Game g = new Game(false);
				g.runGame(sc);
			}
			
			// CONTINUE???
			System.out.println("Do you want to play a new game? (Y/N):");
			c = sc.next().charAt(0);			
		}
		
		sc.close();
	}

}
