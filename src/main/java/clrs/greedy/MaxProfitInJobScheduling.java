package clrs.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

//https://leetcode.com/problems/maximum-profit-in-job-scheduling
public class MaxProfitInJobScheduling {

	//extend clrs.dp.ActivitySelection.maxCompatibleActivitiesV1 - O(n^2) - exceeds time limit on leetcode
	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if(startTime == null || startTime.length == 0) return 0;
        List<Job> jobs = new ArrayList<>();
        int n = startTime.length;
        
        for(int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        Collections.sort(jobs, Comparator.comparingInt(job -> job.end));
        
        int[] totalProfit = new int[n];
        totalProfit[0] = jobs.get(0).profit;
        
        int maxProfit = 0;
        for(int i = 1; i < n; i++) {
            Job currentJob = jobs.get(i);
            int currentMaxProfit = currentJob.profit;
            for(int j = 0; j < i; j++) {
                if(currentJob.start >= jobs.get(j).end && currentMaxProfit < (totalProfit[j] + currentJob.profit)) {
                    currentMaxProfit = totalProfit[j] + currentJob.profit;
                }
            }
            
            totalProfit[i] = currentMaxProfit;
            if(currentMaxProfit > maxProfit)
                maxProfit = currentMaxProfit;
        }
        
        return maxProfit;
    }
	
	//nlogn optimize above O(n^2) dp problem by using binary search
	public static int jobSchedulingOptimized(int[] startTime, int[] endTime, int[] profit) {
        if(startTime == null || startTime.length == 0) return 0;
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>(n);
        
        
        for(int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        Collections.sort(jobs, Comparator.comparingInt(job -> job.end));
        
        TreeMap<Integer, Integer> totalProfits = new TreeMap<>();
        totalProfits.put(0, 0);
        
        for(int i = 0; i < n; i++) {
            Job currentJob = jobs.get(i);
            int currentProfit = totalProfits.floorEntry(currentJob.start).getValue() + currentJob.profit;
            if(currentProfit > totalProfits.lastEntry().getValue()) 
                totalProfits.put(currentJob.end, currentProfit);
        }
        
        return totalProfits.lastEntry().getValue();
    }
    
    static class Job {
        int start;
        int end;
        int profit;
        
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
