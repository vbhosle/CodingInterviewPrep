package com.techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// ONLY 50 points!
public class ThinkingHat {

	public static void main(String[] args) throws IOException {
		System.out.println(solve());
	}
	
	public static int solve() throws IOException {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			int N = Integer.parseInt(reader.readLine());
			int K = Integer.parseInt(reader.readLine());
			int[] prefix = new int[K];
			for (int i = 0; i < prefix.length; i++) {
				prefix[i] = Integer.parseInt(reader.readLine());
				
			}
			
			for (int i = 0; i < prefix.length; i++) {
				if(!(prefix[i]>=1 && prefix[i]<=N) ) return -1;
			}
			
			if(! (N>=1 && N<=30))
			{
				return -1;
			}
			
			if(K>N) return -1;
			
			//find rest of the numbers
			int[] suffix = new int[N-K];
			int[] sortedPrefix = Arrays.copyOf(prefix, prefix.length);
			int sortedPrefixIndex = 0;
			Arrays.sort(sortedPrefix);
			int j = 0;
			for (int i = 1; i <= N; i++) {
				if(sortedPrefixIndex < sortedPrefix.length && i == sortedPrefix[sortedPrefixIndex]) {
					sortedPrefixIndex++;
					continue;
				}
				suffix[j++] = i;
			}
			return permutationArr(prefix, suffix);
		}
		catch(Exception ex) {
			
		}
		
		return -1;
	}

	public static int permutationArr(int[] prefix, int[] suffix) {
		if (suffix == null || suffix.length == 0) {
			int result = eqS1S2(prefix)?1:0;
			return result;
		}

		int count = 0;
		for (int i = 0; i < suffix.length; i++) {
			int[] newPrefix = new int[prefix.length + 1];
			for (int j = 0; j < prefix.length; j++) {
				newPrefix[j] = prefix[j];
			}
			newPrefix[newPrefix.length - 1] = suffix[i];
			count += permutationArr(newPrefix, copyExcept(suffix, i));
		}
		return count;
	}

	public static int[] copyExcept(int[] arr, int skipIndex) {
		int[] result = new int[arr.length - 1];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != skipIndex) {
				result[j++] = arr[i];
			}
		}
		return result;
	}

	
	public static boolean eqS1S2(int[] arr) {
		int count = 0;
		int sum = 0;
		int tempSum = 0;
		for (int i = 0; i < arr.length; i++) {
			tempSum = (i + 1) - arr[i];
			sum += tempSum < 0 ? 0 : tempSum;
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					count++;
				}
			}
		}
		
		return sum == count;
	}

	// Unused 
	public static void permutation(String prefix, String suffix) {
		if (suffix == null || suffix.length() == 0) {
			System.out.println(prefix);
			return;
		}

		String before = "";
		String after = "";
		for (int i = 0; i < suffix.length(); i++) {
			before = suffix.substring(0, i);
			after = suffix.substring(i + 1, suffix.length());
			permutation(prefix + suffix.charAt(i), before + after);
		}
	}
	

	public static int getS1(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					count++;
				}
			}
		}

		return count;
	}

	public static int getS2(int[] arr) {
		int sum = 0;
		int tempSum = 0;
		for (int i = 0; i < arr.length; i++) {
			tempSum = (i + 1) - arr[i];
			sum += tempSum < 0 ? 0 : tempSum;
		}
		return sum;
	}
	
	// NEW
	public static void permute(int[] arr){
	    permuteHelper(arr, 0);
	}

	private static void permuteHelper(int[] arr, int index){
	    if(index >= arr.length - 1){ //If we are at the last element - nothing left to permute
	    	//System.out.println(Arrays.toString(arr));
	        //Print the array
	        System.out.print("[");
	        for(int i = 0; i < arr.length - 1; i++){
	            System.out.print(arr[i] + ", ");
	        }
	        if(arr.length > 0) 
	            System.out.print(arr[arr.length - 1]);
	        System.out.println("]");
	        return;
	    }
	    for(int i = index; i < arr.length; i++){ //For each index in the sub array arr[index...end]

	        //Swap the elements at indices index and i
	        int t = arr[index];
	        arr[index] = arr[i];
	        arr[i] = t;

	        //Recurse on the sub array arr[index+1...end]
	        permuteHelper(arr, index+1);

	        //Swap the elements back
	        t = arr[index];
	        arr[index] = arr[i];
	        arr[i] = t;
	    }
	}

}
