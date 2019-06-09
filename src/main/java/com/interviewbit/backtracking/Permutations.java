package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(6);
		permutations.permute(list);
	}
	
	public List<List<Integer>> permute(List<Integer> A) {
		return permute(new ArrayList<>(), A);
	}

	public List<List<Integer>> permute(List<Integer> path, List<Integer> choices) {
		List<List<Integer>> result = new ArrayList<>();
		if(choices.size() == 0) {
			result.add(path);
			return result;
		}
		
		int len = choices.size();
		Integer choice;
		ArrayList<Integer> newPath;
		for (int i = 0; i < len; i++) {
			choice = choices.get(i);
			newPath = new ArrayList<>();
			newPath.addAll(path);
			newPath.add(choice);
			choices.remove(i);
			result.addAll(permute(newPath, choices));
			choices.add(i, choice); //add back
		}
		
		return result;
	}
	
//	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
//
//        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
//        
//        if (A == null || A.isEmpty()) return ret;
//
//        combine(A, 0, ret);
//
//        return ret;
//
//    }
//
//    private void combine(ArrayList<Integer> A, int index, ArrayList<ArrayList<Integer>> ret) {
//
//        if (index >= A.size() - 1) {
//            ret.add(new ArrayList<>(A));
//            return;
//        }
//
//        for (int i = index; i < A.size(); i++) {
//            java.util.Collections.swap(A, index, i);
//            combine(A, index + 1, ret);
//            java.util.Collections.swap(A, index, i);
//        }
//
//    }
}
