package com.interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

	public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
		if (newInterval.start > newInterval.end) {
			int temp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = temp;
		}
		ArrayList<Interval> overlappingList = new ArrayList<>();
		int insertIndex = 0;
		boolean insertionIndexSet = false;
		int index = 0;
		for (Interval interval : intervals) {
			if (newInterval.start <= interval.end && newInterval.end >= interval.start) {
				if (!insertionIndexSet) {
					insertIndex = index;
					insertionIndexSet = true;
				}
				overlappingList.add(interval);
			}

			index++;
		}
		
		ArrayList<Interval> result = new ArrayList<>(intervals);
		result.add(insertIndex, mergeOverlappingList(overlappingList, newInterval));
		return result.stream().filter(x -> !overlappingList.contains(x))
				.sorted((i1, i2) -> Integer.compare(i1.start, i2.start)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    ArrayList<Interval> ans = new ArrayList<Interval>();
	    //Base case when intervals has 0 size
	    if (intervals.isEmpty()) {
	        ans.add(newInterval);
	        return ans;
	    }

	    //bad design of Interval class allows for invalid intervals.
	    //turn it into a correct interval before proceeding.
	    if(newInterval.start > newInterval.end){
	        newInterval = new Interval(newInterval.end, newInterval.start);
	    }

	    int currentIndex = 0;
	    while(currentIndex < intervals.size() && intervals.get(currentIndex).end < newInterval.start) {
	        ans.add(intervals.get(currentIndex));
	        currentIndex++;
	    }
	    while(currentIndex < intervals.size() && intervals.get(currentIndex).start <= newInterval.end) {
	        newInterval = new Interval(Math.min(intervals.get(currentIndex).start, newInterval.start),
	                Math.max(intervals.get(currentIndex).end, newInterval.end));
	        currentIndex++;
	    }
	    ans.add(newInterval);
	    while (currentIndex < intervals.size()) {
	        ans.add(intervals.get(currentIndex++));
	    }
	    return ans;
	}

	Interval mergeOverlappingList(List<Interval> overlappingList, Interval newInterval) {
		if (overlappingList.isEmpty())
			return newInterval;
		Interval first = overlappingList.get(0);
		Interval last = overlappingList.get(overlappingList.size() - 1);
		if (newInterval.start >= first.start && newInterval.start <= first.end) {
			newInterval.start = first.start;
		}
		if (newInterval.end >= last.start && newInterval.end <= last.end) {
			newInterval.end = last.end;
		}
		return newInterval;
	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			Interval that = (Interval) obj;
			return (this.start == that.start && this.end == that.end);
		}

		public String toString() {
			return "(" + start + ", " + end + ")";
		}
	}

}
