package clrs.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

	public static int maxCompatibleActivities(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[1]));
		
		int max = 1;
		int[] lastSelectedActivity = intervals[0];
		
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] >= lastSelectedActivity[1]) {
				lastSelectedActivity = intervals[i];
				max++;
			}
		}
		
		return max;
	}
}
