package com.leetcode;

public class SearchInsertPosition {

	// TODO: Do it with binary search
	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;
		
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if(nums[i] >= target) {
				return i;
			}
		}
		
		return i;
	}
}
