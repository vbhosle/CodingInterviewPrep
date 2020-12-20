package clrs.dp;

import java.util.Arrays;
import java.util.Map;

public class EditDistance {
	
	public static enum EditOperation {
		ADD, DELETE, REPLACE
	}

	public static int minDistance(String word1, String word2, Map<EditOperation, Integer> operationCost) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return minDistance(word1, word2, operationCost, word1.length() - 1, word2.length() - 1, dp);
    }
    
    private static int minDistance(String word1, String word2, Map<EditOperation, Integer> operationCost, int i, int j, int[][] dp) {
        if(i == -1 && j == -1) return 0;
        if(i == -1) return j+1;
        if(j == -1) return i+1;
        if(dp[i][j] > -1) return dp[i][j];
        
        if(word1.charAt(i) == word2.charAt(j)) {
          dp[i][j] = minDistance(word1, word2, operationCost, i - 1,  j - 1, dp);  
        } 
        else {
          dp[i][j] = Math.min(
        		  minDistance(word1, word2, operationCost, i, j - 1, dp) + operationCost.get(EditOperation.ADD), // to understand this see Gaurav Sen's explanation https://www.youtube.com/watch?v=XJ6e4BQYJ24
        		  Math.min(minDistance(word1, word2, operationCost, i - 1, j, dp) + operationCost.get(EditOperation.DELETE), minDistance(word1, word2, operationCost, i - 1, j - 1, dp) + operationCost.get(EditOperation.REPLACE))
                );
        }
        
        return dp[i][j];
    }
}
