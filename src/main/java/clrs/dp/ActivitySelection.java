package clrs.dp;

import java.util.Arrays;

// this problem has O(n) greedy solution
public class ActivitySelection {
	
	// Dynamic programming solution as per CLRS recurrence. O(n^2) space and time complexity
	public static int maxCompatibleActivities(int[][] intervals) {
		int[][] dp = new int[intervals.length + 2][intervals.length + 2];
        for(int[] row: dp) 
            Arrays.fill(row, -1);
        
        Arrays.sort(intervals, (int[] interval1, int[] interval2) -> interval1[1] - interval2[1]);
        
        //i = 0 and j = intervals.length + 1 when we assume array index starting with 1 
        return maxCompatibleActivities(intervals, 0, intervals.length + 1, Integer.MIN_VALUE, Integer.MAX_VALUE, dp);
	}
	
	private static int maxCompatibleActivities(int[][] intervals, int i, int j, int endTimeOfActivityI, int startTimeOfActivityJ, int[][] dp) {
        if(i > j) return 0;
        if((i+1) == j) return 0;
        if(dp[i][j] >= 0) return dp[i][j];
        
        int max = 0;
        for(int k = i + 1; k < j; k++) {
            int currentStart = intervals[k-1][0]; //k varies from 1 to intervals.length + 1 but array index ranges from 0 to intervals.length - 1
            int currentEnd = intervals[k-1][1];
            if(currentStart >= endTimeOfActivityI && currentEnd <= startTimeOfActivityJ) {
                int currentMax = maxCompatibleActivities(intervals, i, k, endTimeOfActivityI, currentStart, dp) + maxCompatibleActivities(intervals, k, j, currentEnd, startTimeOfActivityJ, dp) + 1;
                if(currentMax > max) {
                    max = currentMax;
                }
            }
        }
        
        dp[i][j] = max;
        
        return dp[i][j];
    }
	
	public static int maxCompatibleActivitiesIterative(int[][] intervals) {
		int n = intervals.length;
		int[][] dp = new int[n + 2][n + 2];
        
        Arrays.sort(intervals, (int[] interval1, int[] interval2) -> interval1[1] - interval2[1]);
        
        for(int len = 2; len <= n + 1; len++) {
        	for(int i = 0; i <= n + 1 - len; i++) {
        		int j = i + len;
        		dp[i][j] = 0;
        		for(int k = i + 1; k < j; k++) {
        			int startTimeOfActivityJ = Integer.MAX_VALUE;
        			int endTimeOfActivityI = Integer.MIN_VALUE;
        			if(i >= 1) {
        				endTimeOfActivityI = intervals[i-1][1];
        			}
        			if(j <= n) {
        				startTimeOfActivityJ = intervals[j-1][0];
        			}
        			
        			if(intervals[k-1][0] >= endTimeOfActivityI && intervals[k-1][1] <= startTimeOfActivityJ) {
        				int currentCount = dp[i][k] + dp[k][j] + 1;
        				if(currentCount > dp[i][j])
        					dp[i][j] = currentCount;
        			}
        		}
        	}
        }
        
        return dp[0][n+1];
	}
	
	// longest increasing subsequence style dp, thanks to techie delight
	public static int maxCompatibleActivitiesV1(int[][] intervals) {
		Arrays.sort(intervals, (int[] interval1, int[] interval2) -> interval1[1] - interval2[1]);
		int maxActivities[] = new int[intervals.length];
		Arrays.fill(maxActivities, 1);
		int max = 1;
		for(int i = 1; i < intervals.length; i++) {
			for(int j = 0; j < i; j++) {
				if(intervals[i][0] >= intervals[j][1] && maxActivities[i] <= maxActivities[j]) {
					maxActivities[i] = 1 + maxActivities[j];
				}
			}
			if(maxActivities[i] > max)
				max = maxActivities[i];
		}
		
		return max;
	}
	
}
