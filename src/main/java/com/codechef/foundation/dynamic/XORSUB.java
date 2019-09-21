package com.codechef.foundation.dynamic;

public class XORSUB {

	public static void main(String[] args) {
		int[] A = new int[] {1, 2, 3};
		System.out.println(maxXorK(4, A));
	}

	public static int maxXorK(int k, int[] A){
	    int N = A.length;
	    int[] newA = new int[N+1];
	    for(int i = 0; i < N; i++){
	        newA[i+1] = A[i];
	    }
	    boolean[][] dp = new boolean[N+1][1024]; //one extra row for empty set
	    dp[0][0] = true;
	    
	    for(int i = 1; i <= N; i++){
	        for(int j = 0; j < 1024; j++){
	            dp[i][j] = dp[i-1][j] | dp[i-1][j ^ newA[i]];
	        }
	    }
	    
	    int max = Integer.MIN_VALUE;
	    for(int i = 1; i < N; i++){
	        for(int j = 1; j < 1024; j++){
	            if(dp[i][j]){
	                max = Math.max(max, k ^ j);
	            }
	        }
	    }
	    
	    return max;
	}
}
