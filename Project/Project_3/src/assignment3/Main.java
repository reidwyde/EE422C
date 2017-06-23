/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Summer 2017
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {

	// static variables and constants only here.
	

	

	public static void main(String[] args) throws Exception {

		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, reakarinasd/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
		initialize();
		printLadder(parse(kb));
	}

	public static void initialize() {
		

		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
	}

	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word, rungs, and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		if(keyboard.next().equals("/quit")){
			return null;
		}
		ArrayList<String> parsed = new ArrayList<String>();
		String input = keyboard.nextLine();
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == ' '){
				parsed.add(input.substring(0, i - 1));
				parsed.add(input.substring(i + 1, input.length() - 1));
			}
		}
		return parsed;
	}

	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		

		// Returned list should be ordered start 5to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		Set<String> dict = makeDictionary();

		return null; // replace this line later with real return
	}

	public static ArrayList<String> getWordLadderBFS(String start, String end) {

		Set<String> dict = makeDictionary();
		

		return null; // replace this line later with real return
	}


	public static void printLadder(ArrayList<String> ladder) {
		System.out.println("?");
		for(int i = 0; i < ladder.size(); i++){
			System.out.println(ladder.get(i));
		}
	}


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
}
