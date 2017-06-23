package assignment3;


import java.util.*;

public class Helper {
	HashSet<String> visited;
	ArrayList<Node> bfspath;
	ArrayList<String> dfspath;
	Set<String> dict; //need to make lower case


	public Helper(Set<String> dictionary){
		visited = new HashSet<String>();
		bfspath = new ArrayList<Node>();
		dict = dictionary;
	}

	public static boolean isOneOff(String word1, String word2){
		//This assumes that passed words have same length
		int lettersMatched = 0;
		for(int i = 0; i < word1.length(); i++){
			if(word1.charAt(i) == word2.charAt(i)){
				lettersMatched++;
			}
		}

		if(lettersMatched == (word1.length() - 1)){
			return true;
		}
		return false;
	}

	
	public boolean dfsHelper(String root, String end, ArrayList<String> ladder){
		if(root.equals(end)){
			ladder.add(end);
			return true;
		}

		visited.add(root);
		for(String s : dict){
			if(isOneOff(root, s)){
				if(!visited.contains(s)){
					if(dfsHelper(s, end, ladder)){
						ladder.add(s);
						return true;
					}
				}
			}
		}
		return false;
	}



	public void reset(){
		visited.clear();
		dfspath.clear();
		bfspath.clear();
	}


	class Node{
		String name;
		Node parent;

		public Node(String name){
			this.name = name;
			parent = null;
		}

		@Override
		public String toString() { return name; }

		public boolean isEqual(Node other){
			if(this.name.equals(other.name)){
				return true;
			}
			return false;
		}

	}

}

