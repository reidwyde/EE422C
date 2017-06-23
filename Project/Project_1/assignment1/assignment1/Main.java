/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;
import assignment1.SortTools;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) {
		int test[] = new int[10];
		for(int i = 0; i < test.length; i++){
			test[i] = test.length * i;
		}
		test[2] = 10; 
		test[9] = 80;
		System.out.println("Test1 is " + Arrays.toString(test));
		test(test, test.length);
		
		/*int test2[] = new int[1];
		System.out.println("Test2 is " + Arrays.toString(test2));
		test(test2, test2.length);*/
		
		
	}


	public static void test(int[] x, int n){
		/*System.out.println("Array is " + Arrays.toString(x));
			
		System.out.println("5 is in array: " + SortTools.find(x, n, 5));	
		System.out.println("General insert 10 into array: " + Arrays.toString(SortTools.insertGeneral(x, n, 10)));	
		System.out.println("General insert -1 into array: " + Arrays.toString(SortTools.insertGeneral(x, n, -1)));	
		System.out.println("General insert 20 into array: " + Arrays.toString(SortTools.insertGeneral(x, n, 20)));	
		System.out.println("General insert 16 into 1/2 array: " + Arrays.toString(SortTools.insertGeneral(x, n / 2, 16)));
		System.out.println("");
		
		System.out.println("Array is " + Arrays.toString(x));
		SortTools.insertInPlace(x, n - 1, 5);
		System.out.println("Place insert 5 into array: " + Arrays.toString(x));
		SortTools.insertInPlace(x, n - 1, -1);
		System.out.println("Place insert -1 into array: " + Arrays.toString(x));	
		SortTools.insertInPlace(x, n / 2, 15);
		System.out.println("Place insert 15 into 1/2 array: " + Arrays.toString(x));
		SortTools.insertInPlace(x, n -1, 20);
		System.out.println("Place insert 20 into array: " + Arrays.toString(x));
		SortTools.insertInPlace(x, n - 8, 100);
		System.out.println("Place insert 100 into array - 8: " + Arrays.toString(x));

		System.out.println("Array is sorted: " + SortTools.isSorted(x, n));	
		System.out.println("Array[2] is sorted: " + SortTools.isSorted(x, 2));
		System.out.println("Array[3] is sorted: " + SortTools.isSorted(x, 3));	
		System.out.println("Array[7] is sorted: " + SortTools.isSorted(x, 7));	
		
		System.out.println("Array is " + Arrays.toString(x));
		SortTools.insertSort(x, n);
		System.out.println("Array is " + Arrays.toString(x));
		*/
		System.out.println("Array is sorted: " + SortTools.isSorted(x, n));
		System.out.println("General insert 10 into array: " + Arrays.toString(SortTools.insertGeneral(x, 0, 144)));
		System.out.println("General insert 10 into array: " + Arrays.toString(SortTools.insertGeneral(x, 3, -5)));
		SortTools.insertInPlace(x, 5, 75);
		System.out.println("Place insert 5 into array: " + Arrays.toString(x));
		SortTools.insertSort(x,  n);
		System.out.println("Test1 is " + Arrays.toString(x));
		System.out.println("Array is sorted: " + SortTools.isSorted(x, n));


	}

}