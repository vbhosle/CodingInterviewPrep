package com.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllFactors {

	public List<Integer> allFactors(int A) {
		List<Integer> factors = new ArrayList<Integer>();
        factors.add(1);
        if(A == 1) return factors;
        factors.add(A);
        int n = (int)Math.sqrt(A);
        for(int i = 2; i<=n; i++){
            if(A%i == 0){
                factors.add(i);
                if(i != A/i)
                    factors.add(A/i);
            }
        }
        Collections.sort(factors);
        return factors;
    }
}
