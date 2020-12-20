package clrs.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class BreakingAString {

	public static int breakStringBruteForce(int stringLength, Set<Integer> breakPoints) {
		return breakStringBruteForce(breakPoints, 1, stringLength);
	}

	private static int breakStringBruteForce(Set<Integer> breakPoints, int left, int right) {
		if(left >= right) return 0;
		
		int stringLength = right - left + 1;
		int minCost = Integer.MAX_VALUE;
		boolean isBreakable = false;
		
		for(int breakPoint: breakPoints) {
			if(breakPoint >= left && breakPoint < right) {
				isBreakable = true;
				minCost = Math.min(minCost, stringLength + breakStringBruteForce(breakPoints, left, breakPoint) + breakStringBruteForce(breakPoints, breakPoint + 1, right));
			}
		}
		
		return isBreakable ? minCost : 0;
	}
	
	public static int breakStringMemoized(int stringLength, Set<Integer> breakPoints) {
		int[][] dp = new int[stringLength + 1][stringLength + 1];
		return breakStringMemoized(breakPoints, 1, stringLength, dp);
	}

	private static int breakStringMemoized(Set<Integer> breakPoints, int left, int right, int[][] dp) {
		if(left >= right) return 0;
		
		if(dp[left][right] > 0 ) return dp[left][right];
		
		int stringLength = right - left + 1;
		int minCost = Integer.MAX_VALUE;
		boolean isBreakable = false;
		
		for(int breakPoint: breakPoints) {
			if(breakPoint >= left && breakPoint < right) {
				isBreakable = true;
				minCost = Math.min(minCost, stringLength + breakStringMemoized(breakPoints, left, breakPoint, dp) + breakStringMemoized(breakPoints, breakPoint + 1, right, dp));
			}
		}
		
		dp[left][right] = isBreakable ? minCost : 0; 
		return dp[left][right];
	}
	
	public static Pair<Integer, List<Integer>> breakString(int stringLength, Set<Integer> breakPoints) {
		return breakString(breakPoints, 1, stringLength, new Pair[stringLength + 1][stringLength + 1]);
	}

	@SuppressWarnings("rawtypes")
	private static Pair<Integer, List<Integer>> breakString(Set<Integer> breakPoints, int left, int right, Pair[][] dp) {
		if(left >= right) return Pair.of(0, new ArrayList<>());
		
		if(dp[left][right] != null ) return dp[left][right];
		
		int stringLength = right - left + 1;
		Pair<Integer, List<Integer>> minCost = Pair.of(Integer.MAX_VALUE, new ArrayList<>());
		boolean isBreakable = false;
		
		for(int breakPoint: breakPoints) {
			
			if(breakPoint >= left && breakPoint < right) {
				isBreakable = true;
				Pair<Integer, List<Integer>> leftSubStringCost =  breakString(breakPoints, left, breakPoint, dp);
				Pair<Integer, List<Integer>> rightSubStringCost = breakString(breakPoints, breakPoint + 1, right, dp);
				if(minCost.getLeft() > stringLength + leftSubStringCost.getLeft() + rightSubStringCost.getLeft()) {
					minCost = Pair.of(stringLength + leftSubStringCost.getLeft() + rightSubStringCost.getLeft(), newList(breakPoint, leftSubStringCost.getRight(), rightSubStringCost.getRight()));
				}
			}
		}
		
		dp[left][right] = isBreakable ? minCost : Pair.of(0, new ArrayList<>()); 
		return dp[left][right];
	}

	private static List<Integer> newList(int breakPoint, List<Integer> breakPoints1, List<Integer> breakPoints2) {
		List<Integer> list = new ArrayList<>();
		list.add(breakPoint);
		list.addAll(breakPoints1);
		list.addAll(breakPoints2);
		return list;
	}
}
