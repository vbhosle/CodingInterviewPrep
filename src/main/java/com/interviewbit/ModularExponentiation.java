package com.interviewbit;

public class ModularExponentiation {

	public int Mod(int A, int B, int C) {
        if(A == 0) return 0;
        if(B == 0){
            return 1;
        }
        if(B % 2 == 0){
            long temp = modulo(Mod(A, B/2, C), C);
            return modulo(temp*temp,C);
        }
        else{
        	long temp = modulo(A,C);
            return modulo(temp*Mod(A, B-1, C), C);
        }
    }
    
    public static int modulo(long x, long n){
        if(x<0) return (int) ((x % n + n) % n);
        return (int) (x%n);
    }
}
