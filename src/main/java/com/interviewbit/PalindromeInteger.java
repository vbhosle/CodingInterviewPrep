package com.interviewbit;

public class PalindromeInteger {

	public int isPalindrome(int A) {
        if(A < 0) return 0;
        return A == revert(A) ? 1: 0;
    }
    
    public int revert(int a){
        int n = a;
        int result = 0;
        while(n>0){
            result = result*10 + n%10;
            n = n/10;
        }
        return result;
    }
}
