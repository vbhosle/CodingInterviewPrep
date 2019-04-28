package com.interviewbit;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class MaxProd {
	public static void main(String[] args) {
//		21474836472147483647
//		9223372036854775807
//		String arr[] = new String[] {"3", "30", "34", "5", "9", "300"};
//		Arrays.sort(arr, new CustomComparator().reversed());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		Integer intArr[] = new Integer[] {3, 30, 34, 5, 9, 300};
		Arrays.sort(intArr, new CustomIntComparator().reversed());
		System.out.println(Arrays.toString(intArr));
		MaxProd solver = new MaxProd();
		System.out.println(solver.maxSpecialProduct(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9)));
	}
	
	static class CustomStringComparator implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			int int1 = Integer.parseInt(s1+s2);
			int int2 = Integer.parseInt(s2+s1);
			if(int1>=int2) {
				return 1;
			}
			return -1;
		}
		
	}
	static class CustomIntComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer i1, Integer i2) {
			String s1 = ""+i1;
			String s2 = ""+i2;
			BigInteger int1 = new BigInteger(s1+s2);
			BigInteger int2 = new BigInteger(s2+s1);
			return int1.compareTo(int2);
//			if(int1>=int2) {
//				return 1;
//			}
//			return -1;
		}
		
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
