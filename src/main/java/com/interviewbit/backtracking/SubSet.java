package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SubSet {
	 	
	public List<List<Integer>> subsets(List<Integer> A) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>()); // empty set
		result.addAll(subsets(new ArrayList<>(), A));
		return result;
	}
	
	//Do a DFS
//	    [] 
//	   / | \
//	  1  2  3
//	 /  \
//	1,2  1,3
//	/
//	1,2,3
	public List<List<Integer>> subsets(List<Integer> currentSet, List<Integer> remainder) {
		List<List<Integer>> result = new ArrayList<>();
		if(remainder.size() == 0) {
			return result;
		}
		for (int i = 0; i < remainder.size(); i++) {
			List<Integer> newSet = new ArrayList<>();
			newSet.addAll(currentSet);// 1,2
			newSet.add(remainder.get(i)); // add 3
			result.add(newSet); // (1,2,3)
			List<Integer> subList = new ArrayList<>(remainder.subList(i+1, remainder.size()));
			result.addAll(subsets(newSet, subList));
		}
		
		return result;
	}
	
	// Unordered sublist
	public List<List<Integer>> subsetsUnOrdered(List<Integer> A) {
		if(A.isEmpty()) {
			List<List<Integer>> list = new ArrayList<>();
			list.add(new ArrayList<>());
			return list;
		}
		List<List<Integer>> tempCombos = subsets(A.subList(0, A.size()-1));
		ArrayList<List<Integer>> newCombos = tempCombos.stream().map(
				combo -> generateNewCombos(A.get(A.size()-1), combo))
							.collect(Collectors.toCollection(ArrayList::new));
		tempCombos.addAll(newCombos);
		return tempCombos;
	}

	private List<Integer> generateNewCombos(Integer n, List<Integer> combo) {
		List<Integer> temp =  new ArrayList<>();
		temp.addAll(combo); 
		temp.add(n);
		return temp;
	}
}
