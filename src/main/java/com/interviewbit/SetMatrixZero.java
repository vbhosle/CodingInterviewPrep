package com.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SetMatrixZero {

	public static void main(String args[]) {
		List<List<Integer>> a = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(0);
		row1.add(0);
		List<Integer> row2 = new ArrayList<>();
		row2.add(1);
		row2.add(0);
		a.add(row1);
		a.add(row2);
		new SetMatrixZero().setZeroes(a);
	}

	//another approach will be to segregate positive and negative numbers using quick sorts two pointers n swap
	//when element is found negate the corresponding index
	
	public void setZeroes(List<List<Integer>> a) {
		if(a == null || a.size() == 0) return;
		int rows = a.size();
		int columns = a.get(0).size();
		ArrayList<Integer> allRows = IntStream.range(0, a.size()).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		Set<Integer> zeroRows = new HashSet<>();
		Set<Integer> zeroColumns = new HashSet<>();
		
		for (int i = 0; i < rows; i++) {
			for(int j=0; j< columns; j++) {
				if(a.get(i).get(j) == 0) {
					zeroRows.add(i);
					zeroColumns.add(j);
				}
			}
		}
		
		for(Integer row: zeroRows) {
			for (int i = 0; i < columns; i++) {
				a.get(row).set(i, 0);
			}
		}
		allRows.removeAll(zeroRows);
		for (Integer row: allRows) {
			for(Integer column: zeroColumns) {
				a.get(row).set(column, 0);
			}
		}
    }
}
