package com.hackerrank.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewYearChaos {
	//22 pts
	public String minimumBribes1(int[] q) {
		if(q == null || q.length == 0) return "0";
		//count bribes done by each
		int count[] = new int[q.length+1];
		int bribes = 0;
		int currentLocn;
		for(int i = 0; i < q.length; i++) {
			currentLocn = indexOf(q, i+1);
			
			if(currentLocn != i) {
				//shift the people before i+1 backwards 
				//optional: put i+1 at it's original position
				for(int j = currentLocn; j > i; j--) {
					count[q[j-1]] ++;
					bribes++;
					if(count[q[j-1]] > 2) return "Too chaotic";
					q[j] = q[j-1];
				}
			}
		}
		
		return ""+bribes;
	}
	
	//fails
	public String minimumBribes2(int[] q) {
		if(q == null || q.length == 0) return "0";
		
		for (int i = 0; i < q.length; i++) {
			if((q[i] - (i+1))>2) {
				return "Too chaotic";
			}
		}
		
//		it is better to count how many times
//        # P has RECEIVED a bribe, by looking at who is
//        # ahead of P.  P's original position is the value
//        # of P.
//        # Anyone who bribed P cannot get to higher than
//        # one position in front if P's original position,
//        # so we need to look from one position in front
//        # of P's original position to one in front of P's
//        # current position, and see how many of those 
//        # positions in Q contain a number large than P.
//        # In other words we will look from P-1 to i-1,
//        # which in Python is range(P-1,i-1+1), or simply
//        # range(P-1,i).  To make sure we don't try an
//        # index less than zero, replace P-1 with
//        # max(P-1,0)
        
		int bribes = 0;
		int oneAheadOfOrg; 
		for (int i = 0; i < q.length; i++) {
			if(q[i] < (i+1)) {
				oneAheadOfOrg = Math.max(q[i] - 1 - 1, 0);
				for (int j = oneAheadOfOrg; j < i; j++) {
					if(q[j]>q[i]) {
						bribes++;
					}
				}
			}
		}
		
		return ""+bribes;
	}
	
	public String minimumBribes(int[] q) {
		if(q == null || q.length == 0) return "0";
		int count[] = new int[q.length+1];
		int index[] = new int[q.length+1];
		int bribes = 0;
		int currentLocn;
		
		//pre-compute index
		for (int i = 0; i < q.length; i++) {
			index[q[i]] = i;
		}
		for(int i = 0; i < q.length; i++) {
			currentLocn = index[i+1];
			
			if(currentLocn != i) {
				//shift the people before i+1 backwards 
				//optional: put i+1 at it's original position
				for(int j = currentLocn; j > i; j--) {
					count[q[j-1]] ++;
					bribes++;
					if(count[q[j-1]] > 2) return "Too chaotic";
					q[j] = q[j-1];
					index[q[j]] = j;//update index
				}
			}
		}
		
		return ""+bribes;
	}
	
	public int indexOf(int[]q, int n) {
		if(q == null || q.length == 0) return -1;
		for (int i = 0; i < q.length; i++) {
			if(q[i] == n) return i;
		}
		
		return -1;
	}
}
