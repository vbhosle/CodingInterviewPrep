package com.dream;

import java.util.Arrays;
import java.util.List;

public class PlusMult {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		String plusMult = plusMult(Arrays.asList(1));
		System.out.println(plusMult);
	}
	
	static final String EVEN = "EVEN";
    static final String ODD = "ODD";
    static final String NEUTRAL = "NEUTRAL";

    static enum OPERATION{
        MULTIPLY, ADD
    }

    public static String plusMult(List<Integer> A) {
        if(A == null || A.isEmpty()) return NEUTRAL;
        long rEven = getAlternateSum(A, 0);
        long rOdd = getAlternateSum(A, 1);
        if(rOdd > rEven) return ODD;
        if(rEven > rOdd) return EVEN;
        return NEUTRAL;
    }

    public static int getAlternateSum(List<Integer> A, int start){
        if(A.size() < (start+1)) return 0;
        int result = A.get(start);
        OPERATION op = OPERATION.MULTIPLY;

        for(int i = start+2; i < A.size(); i += 2){
            switch(op){
                case MULTIPLY: 
                    result = mod(mod(result, 2) * mod(A.get(i), 2), 2);
                    op = OPERATION.ADD;
                    break;
                case ADD:
                    result = mod(mod(result, 2) + mod(A.get(i), 2) ,2);
                    op = OPERATION.MULTIPLY;
                    break;
            }
        }

        return result % 2;
    }

    // takes care of negative numbers
    public static int mod(int n, int m){
        return (n % m + m) % m;
    }

}
