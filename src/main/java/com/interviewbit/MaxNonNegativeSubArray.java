package com.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class MaxNonNegativeSubArray {
	public List<Integer> maxset(List<Integer> A) {
		ListSum maxList = new ListSum();
		ListSum currentList = new ListSum();

		int index = 0;
		while (index < A.size()) {
			while (index < A.size() && A.get(index) < 0) {
				index++;
			}

			while (index < A.size() && A.get(index) >= 0) {
				currentList.add(A.get(index));
				index++;
			}

			if ((maxList.sum < currentList.sum)
					|| ((maxList.sum == currentList.sum) && maxList.list.size() < currentList.list.size())) {
				maxList = currentList;
			}
			currentList = new ListSum();

		}
		return maxList.list;
	}

	public static class ListSum {
		List<Integer> list;
		long sum;

		public ListSum() {
			this.list = new ArrayList<>();
			this.sum = 0;
		}

		public void add(Integer i) {
			list.add(i);
			sum += i;
		}
	}
}
