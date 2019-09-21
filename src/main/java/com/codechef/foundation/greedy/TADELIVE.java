package com.codechef.foundation.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TADELIVE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1 << 3);
		System.out.println(Integer.compare(10, 15));
	}

	public static long maxTip(int[] andyTips, int[] bobTips, int andyLimit, int bobLimit) {
		long[][] memo = new long[andyTips.length][andyLimit+1];
		for(long[] mem: memo) {
			Arrays.fill(mem, -1);
		}
		return maxTipGreedy(andyTips, bobTips, andyLimit, bobLimit);
//		return maxTip(0, 0, memo, andyTips, bobTips, andyLimit, bobLimit);
	}

	//runtime exception
	public static long maxTip(int i, int j, long[][] memo, int[] andyTips, int[] bobTips, int andyLimit, int bobLimit) {
		if(i == andyTips.length) return 0L;
		if( memo[i][j] != -1L) return memo[i][j];
		
		long res = 0L;
		int andyOrders = j;
		if(andyOrders + 1 <= andyLimit) {
			res = Math.max(res, andyTips[i] + maxTip(i+1, j+1, memo, andyTips, bobTips, andyLimit, bobLimit));
		}
		
		int bobOrders = i - j;
		if(bobOrders + 1 <= bobLimit) {
			res = Math.max(res, bobTips[i] + maxTip(i + 1, j, memo, andyTips, bobTips, andyLimit, bobLimit));
		}
		
		memo[i][j] = res;
		return res;
	}

	//ACCEPTED
	public static long maxTipGreedy(int[] andyTips, int[] bobTips, int andyLimit, int bobLimit) {
		long ans = 0L;
		Comparator<Integer> diffComparator = (a, b) -> {
			int diffA = getDiff(andyTips, bobTips, a);
			int diffB = getDiff(andyTips, bobTips, b);
			return Integer.compare(diffA, diffB);
		};
		List<Integer> sortedIndex = IntStream.rangeClosed(0, andyTips.length-1).boxed().sorted(diffComparator.reversed()).collect(Collectors.toList());
		int andyOrders = 0;
		int bobOrders = 0;
		for(int index: sortedIndex) {
			if(andyTips[index] > bobTips[index]) {
				if(andyOrders < andyLimit) {
					ans+= andyTips[index];
					andyOrders++;
				}
				else {
					ans+= bobTips[index];
					bobOrders++;
				}
			}
			else {
				if(bobOrders < bobLimit) {
					ans+= bobTips[index];
					bobOrders++;
				}
				else {
					ans+= andyTips[index];
					andyOrders++;
				}
			}
		}
		return ans;
	}

	// simply doing m-n may cause overflow or underflow
	private static int getDiff(int[] andyTips, int[] bobTips, Integer index) {
		int andyTip = andyTips[index];
		int bobTip = bobTips[index];
		int diff;
		if(andyTip > bobTip) {
			diff = andyTip - bobTip;
		}
		else {
			diff = bobTip - andyTip;
		}
		return diff;
	}
	
	
}
