package clrs.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class RodCutProblem {
	
	public static long bruteForceRodCut(int length, List<Integer> prices) {
		if(length == 0)
			return 0;
		long maxRevenue = Long.MIN_VALUE;
		
		for(int i = 1; i <= length; i++) {
			maxRevenue = Math.max(maxRevenue, prices.get(i) + bruteForceRodCut(length - i, prices));
		}
		
		return maxRevenue;
	}
	
	public static long recursiveMemoizedRodCut(int length, List<Integer> prices) {
		long[] memRevenues = new long[length+1];
		Arrays.fill(memRevenues, Long.MIN_VALUE);
		return recursiveMemoizedRodCut(length, prices, memRevenues);
	}
	
	private static long recursiveMemoizedRodCut(int length, List<Integer> prices, long[] memRevenues) {
		if(memRevenues[length] >= 0)
			return memRevenues[length];
		
		long maxRevenue = Long.MIN_VALUE;
		
		if(length == 0)
			maxRevenue = 0L;
	
		else
			for(int i = 1; i <= length; i++) {
				maxRevenue = Math.max(maxRevenue,  prices.get(i) + recursiveMemoizedRodCut(length - i, prices, memRevenues));
			}
		
		memRevenues[length] = maxRevenue;
		return maxRevenue;
	}
	
	public static long interativeDpRodCut(int length, List<Integer> prices) {
		long[] memRevenues = new long[length+1];
		memRevenues[0] = 0;
		
		for(int j = 1; j <= length; j++) {
			long q = Long.MIN_VALUE;	
			for(int i = 1; i <= j; i++) {
				q = Math.max(q, prices.get(i) + memRevenues[j-i]);
			}
			
			memRevenues[j] = q;
		}
		
		return memRevenues[length];
	}
	
	public static Pair<Long, List<Integer>> interativeDpRodCutWithReconstructedSolution(int length, List<Integer> prices) {
		long[] memRevenues = new long[length+1];
		memRevenues[0] = 0;
		int[] firstCuts = new int[length+1];
		
		for(int j = 1; j <= length; j++) {
			long maxRevenue = Long.MIN_VALUE;	
			for(int i = 1; i <= j; i++) {
				if(maxRevenue < prices.get(i) + memRevenues[j-i]) {
					maxRevenue = prices.get(i) + memRevenues[j-i];
					firstCuts[j] = i;
				}
			}
			
			memRevenues[j] = maxRevenue;
		}
		
		return Pair.of(memRevenues[length], reconstructSolution(firstCuts));
	}

	private static List<Integer> reconstructSolution(int[] firstCuts) {
		int length = firstCuts.length - 1;
		List<Integer> cuts = new ArrayList<>();
		
		while(length > 0) {
			cuts.add(firstCuts[length]);
			length = length - firstCuts[length];
		}
		
		return cuts;
	}
	
	public static Pair<Long, List<Integer>> interativeDpRodCutWithCost(int length, List<Integer> prices, int cost) {
		long[] memRevenues = new long[length+1];
		memRevenues[0] = cost;
		int[] firstCuts = new int[length+1];
		
		for(int j = 1; j <= length; j++) {
			long maxRevenue = Long.MIN_VALUE;	
			for(int i = 1; i <= j; i++) {
				if(maxRevenue < prices.get(i) + memRevenues[j-i] - cost) {
					maxRevenue = prices.get(i) + memRevenues[j-i] - cost;
					firstCuts[j] = i;
				}
			}
			
			memRevenues[j] = maxRevenue;
		}
		
		return Pair.of(memRevenues[length], reconstructSolution(firstCuts));
	}
}
