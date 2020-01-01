package com.udemy.andrei.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountPrimeFactors {
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader reader = new FastReader();
		int testCases = reader.nextInt();
		int N;
		while(testCases > 0){
		    N = reader.nextInt();
		    System.out.println(primeFactors(N));
		    testCases --;
		}
	}
	
	public static int primeFactors(int n){
	    int countOfPrimeFactors = 0;
	    int d = 2;
	    while(n > 1 && d*d <= n){
	        int k = 0;
	        while(n%d == 0){
	            n = n/d;
	            k++;
	        }
	        
	        if(k > 0){
	            countOfPrimeFactors++;
	        }
	        d++;
	    }
	    
	    if(n > 1){
	        countOfPrimeFactors++;
	    }
	    
	    return countOfPrimeFactors;
	}
	
	
	private static class FastReader{
	    BufferedReader br;
	    StringTokenizer st;
	    
	    FastReader(){
	        br = new BufferedReader(new InputStreamReader(System.in));
	    }
	    
	    public String next() throws Exception{
	        if(st == null || !st.hasMoreElements()){
	            st = new StringTokenizer(br.readLine());
	        }
	        
	        return st.nextToken();
	    }
	    
	    public int nextInt() throws Exception{
	        return Integer.parseInt(next());
	    }
	    
	    public long nextLong() throws Exception{
	        return Long.parseLong(next());
	    }
	    
	    public String nextLine() throws Exception{
	        return br.readLine();
	    }
	}
}