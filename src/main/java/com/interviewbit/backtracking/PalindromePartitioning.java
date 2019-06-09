package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
	public List<List<String>> partition(String str) {
		return partitionHelper(str, new HashMap<String, List<List<String>>>());
	}
	
	public List<List<String>> partitionHelper(String str, Map<String, List<List<String>>> cache) {
		if (str == null || str.length() == 0) {
			return new ArrayList<>();
		}

		if(cache.containsKey(str)) {
			//System.out.println("Cache hit for "+ str +"!");
			return cache.get(str);
		}
		
		List<List<String>> result = new ArrayList<>();
		for (int i = 1; i <= str.length(); i++) {
			String prefix = str.substring(0, i);
			if (isPalindrome(prefix)) {
				String suffix = str.substring(i);
				if (suffix.isEmpty()) {
					List<String> combo = new ArrayList<>();
					combo.add(prefix);
					result.add(combo);
				} else {
					List<List<String>> tempPartition = partitionHelper(suffix, cache);
					tempPartition.stream().filter(l -> isCompleteSolution(l, str, prefix)).forEach(list -> {
						ArrayList<String> l = new ArrayList<>();
						l.add(prefix);
						l.addAll(list);
						result.add(l);
					});
				}
			}
		}

		cache.put(str, result);
		return result;
	}

	private boolean isCompleteSolution(List<String> list, String str, String prefix) {
		int totalLength = list.stream().mapToInt(String::length).sum() + prefix.length();
		return totalLength == str.length();
	}

	private boolean isPalindrome(String substring) {
		StringBuilder sb = new StringBuilder(substring);
		return substring.equals(sb.reverse().toString());
	}
}
