package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SievesPrimeNumbers {

	public List<Integer> sieve(int A) {
        boolean[] prime = new boolean[A+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = (int) Math.sqrt(A);
        for(int i = 2; i <= n; i++ ){
            for(int j = 2; i*j <= A; j++){
                prime[i*j] = false;
            }
        }
        
        for (int i = 0; i < prime.length; i++) {
			if(prime[i]) result.add(i);
		}
        
        return result;
    }
}
