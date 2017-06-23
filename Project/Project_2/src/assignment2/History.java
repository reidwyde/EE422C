package assignment2;

public class History {
	Node [] history;
	int numInsert;
	
	History(int chances){
		history = new Node[chances];
	}
	
	public void insertHistory(Node guess){
		history[numInsert] = guess;
		numInsert++;
	}
	public void printHistory(){
		for(int i = 0; i < numInsert; i++){
			System.out.println(history[i].guess + " -> " + history[i].black + "b_" + history[i].white + "w");
		}
	}
}
