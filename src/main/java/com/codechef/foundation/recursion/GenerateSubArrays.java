package com.codechef.foundation.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateSubArrays {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
		List<List<Integer>> subLists = getSubLists(list);
		System.out.println(subLists);
	}

	public static List<List<Integer>> getSubLists(List<Integer> list) {
		return getSubLists(list, 0, list.size() - 1);
	}

	public static List<List<Integer>> getSubLists(List<Integer> list, int start, int end) {
		if(start > end) {
			List<List<Integer>> newList = new ArrayList<>();
			newList.add(new ArrayList<>());
			return newList;
		}
		final int number = list.get(start);
		List<List<Integer>> subList = getSubLists(list, start + 1, end);
		List<List<Integer>> subListsWithNumber = subList.stream().map(l -> new ArrayList<>(l)).collect(Collectors.toCollection(ArrayList::new));
		subListsWithNumber.forEach(l -> l.add(number));
		subList.addAll(subListsWithNumber);
		return subList;
		
	}

}
