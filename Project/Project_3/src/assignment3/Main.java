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


public class Main {

	// static variables and constants only here.

	public static void main(String[] args) throws Exception {

		ArrayList<String> input = new ArrayList<String>();
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
	
		while (true){
			input = parse(kb);
			if (input.size() == 0){
				break;
			}
			else{
				printLadder(getWordLadderBFS(input.get(0), input.get(1)));
				printLadder(getWordLadderDFS(input.get(0), input.get(1)));
				while (! (kb.hasNext()) );
			}
		}
			
	
		/*
		
		//testing using SampleTest.java
		SampleTest s1 = new SampleTest();
		
		SampleTest.setUp();
		
		s1.testBFS1();
		s1.testDFS1();
		
		s1.testBFS2();
		s1.testDFS2();
		*/
		
		//testing using WordLadderTester.java
		/*WordLadderTester t1 = new WordLadderTester();
		WordLadderTester.setUp();
		
		t1.testBFS1();
		t1.testBFS2();
		t1.testDFS1();
		t1.testDFS2();
		*/
		
		
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
		if (input.contains("/quit")){
			return parsed;
		}
		
		Scanner input2 = new Scanner(input);
		
		while (input2.hasNext()){
			parsed.add(input2.next());
		}
		
		input2.close();
					
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
			ladder.add(end);
			ladder.add(start);
		}
		Collections.reverse(ladder);
		return ladder;
	}

	public static ArrayList<String> getWordLadderBFS(String start, String end) {

		Set<String> dict = makeDictionary();
		Helper h1 = new Helper(dict);
		
		
		boolean valid = dict.contains(start.toUpperCase()) && dict.contains(end.toUpperCase());
		if (!(valid)){
			ArrayList<String> ret = new ArrayList<String>();
			ret.add(start);
			ret.add(end);
			return ret;
		}
		List<String> cg = h1.buildCenterGroup(start, end);

		return Helper.buildAnsLadder(cg);
		
	}


	public static void printLadder(ArrayList<String> ladder) {
		if(ladder.size() == 2){
			System.out.println("no word ladder can be found between " + ladder.get(0) + " and " + ladder.get(1) + ".");
		}
		else{
			System.out.println("a " + (ladder.size()-2) + "-rung word ladder exists between " + ladder.get(0) + " and " + ladder.get(ladder.size() - 1) + ".");
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
