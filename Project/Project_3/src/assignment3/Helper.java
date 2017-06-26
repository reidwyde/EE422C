/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Jose Camacho
 * jac6493
 * Reid Wyde
 * raw3295
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL: https://github.com/josecamacho8/EE422C/tree/master/Project/Project_3
 * Summer 2017
 */


package assignment3;

import java.util.*;
import java.io.*;



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
		
		if (!(word1.length() == word2.length())){
			return false;
		}
		
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
		if(root.toLowerCase().equals(end.toLowerCase())){
			return true;
		}

		visited.add(root.toLowerCase());
		for(String s : dict){
			if(isOneOff(root.toLowerCase(), s.toLowerCase()) && isOneOff(s.toLowerCase(), end.toLowerCase())){
				if(!visited.contains(s.toLowerCase())){
					if(dfsHelper(s, end, ladder)){
						ladder.add(s.toLowerCase());
						return true;
					}
				}
			}
		}
		for(String s : dict){
			if(isOneOff(root.toLowerCase(), s.toLowerCase())){
				if(!visited.contains(s.toLowerCase())){
					if(dfsHelper(s, end, ladder)){
						ladder.add(s.toLowerCase());
						return true;
					}
				}
			}
		}
		return false;
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
	
	//BFS helper functions


	public static ArrayList<String> buildAnsLadder(List<String> centerGroup){
	    //System.out.println("--------bAL sees cg as:--------------");
	    
	   /* for (String word: centerGroup){
	    	System.out.println(word);
	    }
	    */
		
		
	    if (centerGroup.size() <= 2){
	    	return (ArrayList<String>)centerGroup;
	    }
		
	    String start = centerGroup.get(centerGroup.size()-1);
	    String end = centerGroup.get(0);
	    
	/*
	    System.out.println("--------bAL sees start as:--------------");
	    System.out.println(start);
	    System.out.println("--------bAL sees end as:--------------");
	    System.out.println(end);
	  */
	    
	    
	    ArrayList<String> ansLadder = new ArrayList<String>();
	    ansLadder.add(start);
	    
	    
	    
	     //ok so we need to go from 0 index until we find a word that is one off from start
	    //when we get to this word, we want to add it
	    //then we want to set start to that word
	    
	    while (!ansLadder.contains(end)){
	    	int localEnd = centerGroup.indexOf(start);
	    	for (int i = 0; i<localEnd; i++){
	    		if (isOneOff(start, centerGroup.get(i))){
	    			ansLadder.add(centerGroup.get(i));
	    			start = centerGroup.get(i);
	    			break;
	    		}
	    	}
	    }
	   
	    Collections.reverse(ansLadder);
	    
	    return ansLadder;
	}

	public List<String> buildCenterGroup (String start, String end){
		String origStart = start;
		String origEnd = end;
	    List<String> centerGroup = new ArrayList<String>();
	    List<String> centerGroup2 = new ArrayList<String>();
	    
	    boolean contains = false;
	    boolean endOfList = false;
	    int index = 0;
	    //goes through all the off by 1 words from start. We want to add this group from the dictionary.
	    //if the centerGroup contains end we stop
	    //if thisGroup runs out, we want to run a new listOneOff, with start updated to the next thing in the center group
	    
	    if (start.equals(end) || isOneOff(start,  end)){
	    	centerGroup2.add(start);
			centerGroup2.add(end);
			return centerGroup2;
	    }
	    
	    
	    centerGroup.add(start);
	    
	    while(!contains){
			ArrayList<String> thisGroup = listOneOff(start, end);
			for (String word : centerGroup){
				if (thisGroup.contains(word)){
					thisGroup.remove(word);
				}
			}
			for (String word : thisGroup){
					centerGroup.add(word);
					if (word.equals(end)){
						contains = true;
						break;
					}
			}
			if (contains) break;
			index++;
			if (index >= centerGroup.size()){
			//	System.out.println("we ran out of the center group");
			//	System.out.println("this is the center group: ");
			//	for (String disword : centerGroup){
			//		System.out.println(disword);
			//	}
				break;
			}
			else{
				start=centerGroup.get(index);
			}
	    }
		if (!contains){
			centerGroup2.add(origStart);
			centerGroup2.add(origEnd);
			return centerGroup2;
		}
	    int endex = centerGroup.indexOf(end);
	    for (int i = 0; i<=endex; i++){
	    	centerGroup2.add(centerGroup.get(i));
	    	//System.out.println(centerGroup.get(i));
	    }
	
	    
	    return centerGroup2;
	}
	

	public ArrayList<String> listOneOff (String start, String end){
	    ArrayList<String> listOneOff = new ArrayList<String>();
	    
	    for (int i = 0; i<start.length(); i++){
		    listOneOff.addAll(listSameOneOff(start, i));
	    }
	 
	    return listOneOff;
	}

	public ArrayList<String> listSameOneOff (String start, int n){
	    ArrayList<String> sameOneOff = new ArrayList<String>();
	    String alph = "abcdefghijklmnopqrstuvwxyz";
	    char c = start.charAt(n);
	    for (char c1 : alph.toCharArray()){
	    	String newWord = start.substring(0,n) + c1 + start.substring(n+1, start.length());
			if ( !(c == c1) && dict.contains(newWord.toUpperCase()) && ! newWord.equals(start)  ){
			    sameOneOff.add(newWord);
			    //System.out.println(newWord);
			}
		}
	    
	    return sameOneOff;
	}
	
	
	
	public static ArrayList<String> capPermTailRecurse(String str) {
		ArrayList<String> perms = new ArrayList<String>();
		capPermTailRecurseHelper(0, str, perms);
		Collections.reverse(perms);
		
		return perms;
	}

	private static void capPermTailRecurseHelper(int index, String str, ArrayList<String> all) {
		if (index == str.length()) {
			all.add(str);
			return;
		}
		String pre = str.substring(0, index);
		Character up = Character.toUpperCase(str.charAt(index));
		Character low = Character.toLowerCase(str.charAt(index));
		String post = str.substring(index+1, str.length());
		capPermTailRecurseHelper(index+1, pre + up + post, all);
		capPermTailRecurseHelper(index+1, pre + low + post, all);
	}

	public boolean contains2(String start) {
		ArrayList<String> capPerms = capPermTailRecurse(start);
		System.out.println("madeit3");
		for (String word : capPerms){
			if (dict.contains(word)){
				System.out.println("madeit4");
				return true;
			}
		}

		return false;
	}






















}

