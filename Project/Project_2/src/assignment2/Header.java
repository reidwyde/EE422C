/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Jose Camacho
 * jac6493
 * Slip days used: <0>
 * Summer 2017
 */
package assignment2;
class Node{
	String guess;
	int black;
	int white;
	boolean match;
}
public class Header{
	public static boolean validColors(String guess, String [] colors){
		for(int i = 0; i < guess.length(); i++){
			int match = 0;
			for(int j = 0; j < colors.length; j++){
				if(colors[j].equals(String.valueOf(guess.charAt(i)))){
					match++;
				}
			}
			if(match == 0){
				return false;
			}
		}
		return true;
	}
	

	public static Node determineMatch(String guess, String answer, int pegs){
		Node r_node = new Node();
		r_node.guess = guess;
		r_node.white = 0;
		r_node.black = 0;
		
		
		int [] check = new int[guess.length()];
		
		//Check black pegs first then white seperately
		for(int i = 0; i < guess.length(); i++){
			if(guess.charAt(i) == answer.charAt(i)){
				check[i] = 2;
			}
		}	
		for(int i = 0; i < guess.length(); i++){
			if(check[i] != 2){	
				for(int j = 0; j < answer.length(); j++){
					if(guess.charAt(i) == answer.charAt(j)){
						if(check[j] == 0){
							check[j] = 1;
							break;
							}
						}
					}
				}
			}
	
		for(int i = 0; i < check.length; i++){
			if(check[i] == 1){
				r_node.white++;
			}
			else if(check[i] == 2){
				r_node.black++;
			}
		}
		
		System.out.println(guess + " -> " + r_node.black + "b_" + r_node.white + "w");


		if(r_node.black == pegs){
			r_node.match = true;
		}
		else{
			r_node.match = false;
		}
		return r_node;
	}
}
