/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Jose Camacho
 * jac6493
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL: https://github.com/josecamacho8/EE422C/tree/master/Project/Project_3
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
		ArrayList<String> input;
		input = parse(kb);
		printLadder(getWordLadderDFS(input.get(0), input.get(1)));
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
		ArrayList<String> parsed = new ArrayList<String>();
		String input = keyboard.nextLine();

		if(input.equals("/quit")){
			return null;
		}

		int i = input.indexOf(' ');
		parsed.add(input.substring(0, i));
		parsed.add(input.substring(i + 1, input.length()));

		return parsed;
	}

	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		// Returned list should be ordered start 5to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		Set<String> dict = makeDictionary();
		Helper test = new Helper(dict);

		ArrayList<String> ladder = new ArrayList<String>();
		if(test.dfsHelper(start,  end, ladder)){
			ladder.add(start);
		} 
		else{
			ladder.add(start);
			ladder.add(end);
		}
		Collections.reverse(ladder);
		return ladder;
	}

	public static ArrayList<String> getWordLadderBFS(String start, String end) {

		Set<String> dict = makeDictionary();


		return null; // replace this line later with real return
	}


	public static void printLadder(ArrayList<String> ladder) {
		if(ladder.size() == 2){
			System.out.println("no word ladder can be found between " + ladder.get(0) + " and " + ladder.get(1) + ".");
		}
		else{
			System.out.println("a " + ladder.size() + "-rung word ladder exists between " + ladder.get(0) + " and " + ladder.get(ladder.size() - 1) + ".");
			for(int i = 0; i < ladder.size(); i++){
				System.out.println(ladder.get(i));
			}
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
