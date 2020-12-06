package clrs.dp;

public class LongestCommonSubsequence {

	public static int recursiveLCSLengthBruteForce(String seq1, String seq2) {
		int[][] lengthOfLCS = new int[seq1.length() + 1][seq2.length()+1];
		return recursiveLCSLengthBruteForce(seq1, seq2, seq1.length(), seq2.length(), lengthOfLCS);
	}

	private static int recursiveLCSLengthBruteForce(String seq1, String seq2, int i, int j, int[][] lengthOfLCS) {
		if(i == 0 || j == 0)
			lengthOfLCS[i][j] = 0;
		
		else if(seq1.charAt(i- 1) == seq2.charAt(j - 1)) {
			lengthOfLCS[i][j] = 1 + recursiveLCSLengthBruteForce(seq1, seq2, i - 1, j - 1, lengthOfLCS);
		}
		else {
			lengthOfLCS[i][j] = Math.max(recursiveLCSLengthBruteForce(seq1, seq2, i - 1, j, lengthOfLCS)
										, recursiveLCSLengthBruteForce(seq1, seq2, i, j - 1, lengthOfLCS));
		}
		
		return lengthOfLCS[i][j];
	}
	
	private enum Direction {
		UP, LEFT, ACROSS;
	}
	
	public static String lcsV1(String seq1, String seq2) {
		int m = seq1.length();
		int n = seq2.length();
		int[][] len = new int[m+1][n+1];
		Direction[][] trail = new Direction[m+1][n+1];
		
		for(int i = 1; i <= m; i++) {
			len[i][0] = 0;
		}
		
		for(int i = 1; i <= n; i++) {
			len[0][i] = 0;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
					len[i][j] = 1 + len[i - 1][j - 1];
					trail[i][j] = Direction.ACROSS;
				}
				else if(len[i - 1][j] >= len[i][j - 1]){
					len[i][j] = len[i - 1][j];
					trail[i][j] = Direction.UP;
				}
				else {
					len[i][j] = len[i][j - 1];
					trail[i][j] = Direction.LEFT;
				}
			}
		}
		
		return buildSequenceV1(trail, seq1, m, n).toString();
	}

	private static StringBuilder buildSequenceV1(Direction[][] trail, String seq, int i, int j) {
		if(i == 0 || j == 0)
			return new StringBuilder();
		
		if(trail[i][j] == Direction.ACROSS) {
			return buildSequenceV1(trail, seq, i - 1, j - 1).append(seq.charAt(i - 1));
		}
		else if(trail[i][j] == Direction.UP) {
			return buildSequenceV1(trail, seq, i - 1, j);
		}
		
		return buildSequenceV1(trail, seq, i, j - 1);
	}
	
	public static String lcsV2(String seq1, String seq2) {
		int m = seq1.length();
		int n = seq2.length();
		int[][] len = new int[m+1][n+1];
		
		for(int i = 1; i <= m; i++) {
			len[i][0] = 0;
		}
		
		for(int i = 1; i <= n; i++) {
			len[0][i] = 0;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
					len[i][j] = 1 + len[i - 1][j - 1];
				}
				else if(len[i - 1][j] >= len[i][j - 1]){
					len[i][j] = len[i - 1][j];
				}
				else {
					len[i][j] = len[i][j - 1];
				}
			}
		}
		
		return buildSequenceV2(len, seq1, seq2, m, n).toString();
	}
	
	private static StringBuilder buildSequenceV2(int[][] len, String seq1, String seq2, int i, int j) {
		if(len[i][j] == 0)
			return new StringBuilder();
		
		if(seq1.charAt(i-1) == seq2.charAt(j-1)) {
			return buildSequenceV2(len, seq1, seq2, i - 1, j - 1).append(seq1.charAt(i-1));
		}
		else if(len[i - 1][j] > len[i][j - 1]) {
			return buildSequenceV2(len, seq1, seq2, i - 1, j);
		}
		
		return buildSequenceV2(len, seq1, seq2, i, j - 1);
	}
	
	//compute the length of an LCS using only 2*min(m, n) entries in the c table
	public static int lcsLength(String seq1, String seq2) {
		if(seq1.length() > seq2.length()) 
			return lcsLength(seq2, seq1);
		
		int m = seq1.length();
		int n = seq2.length();
		int[] prev = new int[m+1];
		int[] curr = new int[m+1];
		
		for(int i = 1; i <= n; i++) {
			int[] temp = prev;
			prev = curr;
			curr = temp;
			for(int j = 1; j <= m; j++) {
				if(seq2.charAt(i-1) == seq1.charAt(j-1)) {
					curr[j] = 1 + prev[j - 1];
				}
				else if(prev[j] >= curr[j - 1]) {
					curr[j] = prev[j];
				}
				else {
					curr[j] = curr[j - 1];
				}
			}
				
		}
		
		return curr[m];
	}
}
