package com.interviewbit;

import java.util.Arrays;
import java.util.List;

public class PaintersPartition {

	public static void main(String[] args) {
		System.out.println(Arrays.asList(6, 4, 9, 1, 6, 3, 0).stream().reduce(Math::max).get());
	}

	public int paint(int painters, int timeToPaintUnit, List<Integer> boardLengths) {
		long low = boardLengths.stream().mapToLong(Integer::intValue).max().getAsLong();
		long high = boardLengths.stream().mapToLong(Integer::intValue).sum();
		long mid = 0;
		long ans = high;
		int paintersRequired = 0;

		while (low <= high) {
			mid = low + (high - low) / 2;
			paintersRequired = paintersRequiredToCompleteIn(mid, boardLengths);
			if (paintersRequired <= painters) {
				ans = mid;
				high = mid - 1;

			} else {
				low = mid + 1;
			}

		}

		return (int) (((ans % 10000003) * (timeToPaintUnit % 10000003)) % 10000003);
	}

	public int paintersRequiredToCompleteIn(long time, final List<Integer> boardLengths) {
		int painters = 1;
		long currentWork = 0;
		long proposedWork = 0;
		for (int i = 0; i < boardLengths.size(); i++) {
			proposedWork = currentWork + boardLengths.get(i);
			if (proposedWork <= time) {
				currentWork = proposedWork;
			} else {
				painters++;
				currentWork = boardLengths.get(i);
			}
		}

		return painters;
	}
}
