package com.udemy.andrei.math;

import java.util.HashMap;
import java.util.Map;

//https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
// this problem is different than discussed in the course. 
public class SmallestMultipleWith0And1 {

	public static void main(String[] args) {
		
		assertMultiple(55, "110");
		
		assertMultiple(2, "10");

		assertMultiple(101, "101");
		
		assertMultiple(7, "1001");
	}

	public static void assertMultiple(int n, String expected) {
		String ans = multiple(n);
		assert expected.equals(ans): "smallest multiple of "+ n +" is " + expected + " but got " + ans;
	}

	public static String multiple(int n) {
//		if(isBinary(n)) return Integer.toString(n);
        Map<Integer, Integer> remainders = new HashMap<>();
        int currentRemainder = 0;
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = 1; i <= n; i++){
            currentRemainder = (currentRemainder*10 + 1) % n;
            
            if(currentRemainder == 0){
            	ans = nTimesNum(i, 1);
            	break;
            }
            
            if(remainders.containsKey(currentRemainder)){
                int j = remainders.get(currentRemainder);
                ans = nTimesNum( i-j, 1).append(nTimesNum(j, 0));
                break;
            }
            
            remainders.put(currentRemainder, i);
        }
        
        return ans.toString();
    }
    
    public static StringBuilder nTimesNum(int n, int num){
        StringBuilder s = new StringBuilder();
        for(int i = 1; i <= n; i++){
            s.append(num);
        }
        
        return s;
    }
    
    public static boolean isBinary(int n){
        int remainder = 0;
        do{
            remainder = n%10;
            if(remainder == 0 || remainder == 1) {
                n = n/10;
                continue;
            }
            else return false;
        }while(n > 1);
        return true;
    }
}
