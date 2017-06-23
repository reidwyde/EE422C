// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Jose Camacho
 * jac6493
 * <5-digit Unique No.>
 * Summer 2017
 * Slip days used: 
 */

package assignment1;
public class SortTools {

	public static boolean isSorted(int[] x, int n) {
		if(x.length == 0 || n == 0){ return false; }
		
		int check = x[0];
		for(int i = 0; i < n; i++){
			if(x[i] < check){
				return false;
			}
			check = x[i];
		}
		return true;
	}
	
	public static int find(int[] x, int n, int v){
		for(int i = 0; i < n; i++){
			if(x[i] == v){
				return i;
			}
		}
		
		return -1;
	}
	
	public static int[] insertGeneral(int[] x, int n, int v){
		// Have to add v in sorted manner, retest, don't feel good
		//Three cases: v < array, v > array, array < v < array
		if(find(x, n, v) == -1){
			int addV[] = new int[n + 1];
			
			if(n == 0){
				addV[0] = v;
				return addV;
			}
			
			if(x[n - 1] < v){
				for(int i = 0; i < n; i++){
					addV[i] = x[i];
				}
				addV[n] = v;
				return addV;
			}
			
			
			boolean add = false;
			for(int i = 0, j = 0; i < n + 1; i++, j++){
				if(x[j] > v && !add){
					addV[i] = v;
					add = true;
					j--;
				}
				else{
					addV[i] = x[j];
				}
				
			}
			
			return addV;
	}
		else{
			int noV[] = new int[n];
			for(int i = 0; i < n; i++){
				noV[i] = x[i];
			}
			return noV;
		}
		
	}
// Three cases to study: v should be in beginning of array, end of array, middle (maybe also end of ordered list like '17')
	public static int insertInPlace(int[] x, int n, int v){
		if(find(x, n, v) != -1){
			return n;
		}

		for(int i = 0; i < n + 1; i++){
			if(x[i] > v){
				for(int j = n; j != i; j--){
					x[j] = x[j - 1];					
				}
				x[i] = v;
				return n + 1;
			}
		}
		
		x[n] = v;
		return n + 1;
	}
	
	public static void insertSort(int[] x, int n){
		for(int i = 1; i < n; i++){
			int j = i;
			while(j > 0 && x[j] < x[j - 1]){
				int temp = x[j];
				x[j] = x[j - 1];
				x[j - 1] = temp;
				j--;
			}
		}
			
	}

}
