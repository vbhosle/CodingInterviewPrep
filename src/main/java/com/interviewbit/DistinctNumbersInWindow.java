package com.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctNumbersInWindow {

	public List<Integer> dNums(List<Integer> arr, int windowSize) {
		if(arr == null || arr.isEmpty() || windowSize <= 0) return Collections.emptyList();
		int len = arr.size();
		List<Integer> result = new ArrayList<>();
		CountingHashSet distinct = new CountingHashSet();
		for(int i = 0; i < windowSize && i <len; i++) {
			distinct.add(arr.get(i));
		}
		
		result.add(distinct.size());
		
		for (int i = windowSize; i < len; i++) {
			distinct.remove(arr.get(i-windowSize));
			distinct.add(arr.get(i));
			result.add(distinct.size());
		}
		
		return result;
	}
	
	private static class CountingHashSet{
		private Map<Integer, Integer> elements = new HashMap<>();
		
		public void add(Integer n) {
			Integer count = elements.get(n);
			elements.put(n, count == null? 1: count + 1);
		}
		
		public boolean remove(Integer n) {
			Integer count = elements.get(n);
			if(count == null) return false;
			if(count == 1) {
				elements.remove(n);
				return true;
			}
			
			elements.put(n, elements.get(n) - 1);
			return true;
		}
		
		public int size() {
			return elements.size();
		}
	}
	
}
