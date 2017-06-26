package assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class HelperTest {

	@Test
	public void test() {
		Scanner kb = new Scanner(System.in);
		while(!(kb.hasNext()));
		String s = kb.next();
	
		ArrayList<String> t1 = Helper.capPermTailRecurse(s);
		
		System.out.println("--------------T1-------------");
		for (String str : t1){
			System.out.println(str);
		}	
	}
	
	
	
	
	
	

}
