package com.interviewbit;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MaxProd {
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		int x = (int) ((100000*100000L)%1000000007);
		System.out.println(x);
		MaxProd solver = new MaxProd();
		System.out.println(solver.maxSpecialProduct(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9)));
	}
    public int maxSpecialProduct(List<Integer> A) {
        if(A == null || A.size() <= 2) return 0;
    	int n = A.size();
        int[] prevs = prevMax(A, n);
        int[] nexts = nextMax(A, n);
//        System.out.println("prevs");
//        System.out.println(prevs[n-2]);
//        System.out.println(nexts[n-2]);
//        print1D(prevs);
//        print1D(nexts);
        int mod = 1000000007;
        long max = 0;
        long prod = 0;
        for(int i=0;i<n;i++) {
                prod = 1L*prevs[i]*nexts[i];
				if(prod>max) {
					max = prod;
				}
        }
        return (int) (max%mod);
    }
    // A : [ 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 ]
    private int[] prevMax(List<Integer> A, int n) {
        int[] prevs = new int[n];
        Deque<Integer> s = new ArrayDeque<>(n);
        int i = 0;
        while(i < n) {
            if(!s.isEmpty() && A.get(i) >= A.get(s.peek())) {
                s.pop();
            } else if(s.isEmpty()) {
                s.push(i);
                prevs[i] = 0;
                i++;
            } else {
                prevs[i] = s.peek();
                s.push(i);
                i++;
            }
        }
        return prevs;
    }
    
    private int[] nextMax(List<Integer> A, int n) {
        int[] nexts = new int[n];
        Deque<Integer> s = new ArrayDeque<>(n);
        int i = n-1;
        while(i >= 0) {
            if(!s.isEmpty() && A.get(i) >= A.get(s.peek())) {
                s.pop();
            } else if(s.isEmpty()){
                s.push(i);
                nexts[i] = 0;
                i--;
            } else {
                nexts[i] = s.peek();
                s.push(i);
                i--;
            }
        }
        return nexts;
    }
    
    private void print1D(int[] x) {
        for(int i: x) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
}
