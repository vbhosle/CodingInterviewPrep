package clrs.dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//To make it easier to test the algorithm for any generic case, instead of returning the values we will return indexes
public class LongestMonotonicallyIncreasingSubsequence {

	public static int lislengthBruteForce(List<Integer> input) {
		return lisLengthBruteForce(-1, 0, input);
	}
	
	// Techie delight
	private static int lisLengthBruteForce(int previous, int current, List<Integer> input) {
		if(current == input.size())
			return 0;
		
		int lisLengthWithCurrentIncluded = 0;
		if(previous == -1 || input.get(current) >= input.get(previous)) {
			lisLengthWithCurrentIncluded = 1 + lisLengthBruteForce(current, current + 1, input);
		}
		
		int lisSizeWithCurrentExcluded = lisLengthBruteForce(previous, current+1, input);
		return Math.max(lisLengthWithCurrentIncluded, lisSizeWithCurrentExcluded);
	}
	
	public static int lislengthBruteForceMemoized(List<Integer> input) {
		int[][] dp = new int[input.size()+1][input.size()+1];
		for(int[] row: dp) 
			Arrays.fill(row, -1);
		return lislengthBruteForceMemoized(-1, 0, input, dp);
	}
	
	private static int lislengthBruteForceMemoized(int previous, int current, List<Integer> input, int[][] dp) {
		if(current == input.size())
			return 0;
		
		if(previous != -1 && dp[previous][current] > -1)
			return dp[previous][current];
		
		int lisLengthWithCurrentIncluded = 0;
		if(previous == -1 || input.get(current) >= input.get(previous)) {
			lisLengthWithCurrentIncluded = 1 + lislengthBruteForceMemoized(current, current + 1, input, dp);
		}
		
		int lisSizeWithCurrentExcluded = lislengthBruteForceMemoized(previous, current+1, input, dp);
		
		if(previous != -1)
			dp[previous][current] = Math.max(lisLengthWithCurrentIncluded, lisSizeWithCurrentExcluded);
		return Math.max(lisLengthWithCurrentIncluded, lisSizeWithCurrentExcluded);
	}

	public static List<Integer> lisUsingLCSAlgorithm(List<Integer> input) {
		List<Integer> sortedInput = new ArrayList<>(input);
		Collections.sort(sortedInput);
		return lcs(input, sortedInput);
	}

	private static List<Integer> lcs(List<Integer> seq1, List<Integer> seq2) {
		int m = seq1.size();
		int n = seq2.size();

		int[][] len = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (seq1.get(i - 1) == seq2.get(j - 1)) {
					len[i][j] = len[i - 1][j - 1] + 1;
				} else {
					len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
				}
			}
		}

		return buildSequence(len, seq1, seq2, m, n);
	}

	private static List<Integer> buildSequence(int[][] len, List<Integer> seq1, List<Integer> seq2, int i, int j) {
		if (i == 0 || j == 0)
			return new LinkedList<>();

		if (seq1.get(i - 1) == seq2.get(j - 1)) {
			List<Integer> sequence = buildSequence(len, seq1, seq2, i - 1, j - 1);
			sequence.add(i - 1);
			return sequence;
		} else if (len[i - 1][j] > len[i][j - 1]) {
			return buildSequence(len, seq1, seq2, i - 1, j);
		}

		return buildSequence(len, seq1, seq2, i, j - 1);
	}

	public static List<Integer> lisPatienceSortModifiedForNonDecreasing(List<Integer> input) {
		List<Node> pileList = new ArrayList<>();

		for (int i = 0; i < input.size(); i++) {
			Node node = new Node(i, input.get(i), null);

			int ceilIndex = ceilIndex(pileList, input.get(i));

			if (ceilIndex == -1) {
				Node prev = getLast(pileList);
				node.prev = prev;
				pileList.add(node);
			} else if (input.get(i).equals(pileList.get(ceilIndex).value)) {
				node.prev = pileList.get(ceilIndex);
				pileList.set(ceilIndex, node);
			} else {
				Node prev = ceilIndex == 0 ? null : pileList.get(ceilIndex - 1);
				node.prev = prev;
				pileList.set(ceilIndex, node);
			}

		}

		return buildLisIndexList(pileList);
	}

	//Back To Back SWE Channel https://www.youtube.com/watch?v=fV-TF4OvZpk
	public static List<Integer> lisV1(List<Integer> input) {
		if(input.isEmpty()) return Collections.emptyList();
		
		int[] len = new int[input.size()];
		int[] extendedFrom = new int[input.size()];
		Arrays.fill(len, 1);
		extendedFrom[0] = -1;
		
		int globalMaxLengthEndsAtIndex = 0;
		for(int right = 1; right < input.size(); right++) {
			int maxLen = len[right];
			for(int left = 0; left < right; left++) {
				if(input.get(left) <= input.get(right)) {
					int newLen = len[left] + 1;
					if(newLen > maxLen) {
						maxLen = newLen;
						extendedFrom[right] = left;
					}
				}
			}
			
			len[right] = maxLen;
			if(maxLen > len[globalMaxLengthEndsAtIndex])
				globalMaxLengthEndsAtIndex = right;
		}
		
		Deque<Integer> stack = new ArrayDeque<>();
		int currentIndex = globalMaxLengthEndsAtIndex;
		
		do {
			stack.push(currentIndex);
			currentIndex = extendedFrom[currentIndex];
		}while(currentIndex != -1);
		
		List<Integer> indexList = new ArrayList<>(stack.size());
		while (!stack.isEmpty()) {
			indexList.add(stack.pop());
		}

		return indexList;
	}
	
	private static List<Integer> buildLisIndexList(List<Node> pileList) {
		Node current = pileList.get(pileList.size() - 1);
		Deque<Integer> indexStack = new ArrayDeque<>();
		while (current != null) {
			indexStack.push(current.index);
			current = current.prev;
		}

		List<Integer> indexList = new ArrayList<>(indexStack.size());
		while (!indexStack.isEmpty()) {
			indexList.add(indexStack.pop());
		}

		return indexList;
	}

	private static int ceilIndex(List<Node> pileList, int n) {
		if (pileList.isEmpty())
			return -1;

		int ceilIndex = -1;
		int low = 0;
		int high = pileList.size() - 1;
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (n > pileList.get(mid).value) {
				low = mid + 1;
			} else {
				ceilIndex = mid;
				high = mid - 1;
			}
		}

		return ceilIndex;
	}

	// nlogn
	// YouTube Stable Sort channel https://www.youtube.com/watch?v=22s1xxRvy28
	public static List<Integer> lisUsingPatienceSortStrictlyIncreasing(List<Integer> input) {
		List<Integer> pileList = new ArrayList<>();
		List<Integer> linkedIndexList = new ArrayList<>();

		for (int i = 0; i < input.size(); i++) {
			int ceilIndex = ceilIndex(input, pileList, input.get(i));
			if (ceilIndex == -1) {
				if (!pileList.isEmpty())
					linkedIndexList.add(getLast(pileList));
				pileList.add(i);
			} else {
				pileList.set(ceilIndex, i);
			}
		}

		linkedIndexList.add(getLast(pileList));
		return linkedIndexList;
	}

	private static <T> T getLast(List<T> list) {
		if (list.isEmpty())
			return null;
		return list.get(list.size() - 1);
	}

	// for sorted list
	public static int ceilIndex(List<Integer> values, List<Integer> sortedIndexList, int n) {
		if (sortedIndexList.isEmpty())
			return -1;

		int low = 0;
		int high = sortedIndexList.size() - 1;
		int ceilIndex = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (n > values.get(sortedIndexList.get(mid))) {
				low = mid + 1;
			} else {
				ceilIndex = mid;
				high = mid - 1;
			}
		}

		return ceilIndex;
	}

	static class Node {
		int index;
		int value;
		Node prev;

		Node(int index, int value, Node prev) {
			this.index = index;
			this.value = value;
			this.prev = prev;
		}

		@Override
		public String toString() {
			return String.format("index=%d, value=%d, prevValue=%d", index, value, prev != null ? prev.value : null);
		}
	}
}
