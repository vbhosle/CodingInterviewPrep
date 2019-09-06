package com.codechef.foundation.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Nokia {

	public static void main(String[] args) {
		System.out.println(unusedWire(3, 8));
		System.out.println(unusedWire(3, 9));
		System.out.println(unusedWire(2, 4));
		System.out.println(unusedWire(5, 25));
	}

	public static int unusedWire(int spots, int wireLength) {
		ArrayList<Integer> freeSpots = IntStream.rangeClosed(1, spots).boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		return unusedWire(new TreeSet<>(Arrays.asList(0, spots + 1)), freeSpots, spots, wireLength);
	}

	// timeout
	public static int unusedWire(TreeSet<Integer> allocatedSpots, List<Integer> freeSpots, int totalSpots,
			final int remainingWire) {
		if(freeSpots.isEmpty()) {
//			System.out.println("Remaining wire for the combo: " + allocatedSpots + " = " + remainingWire);
			return remainingWire;
		}
		
		int min = remainingWire;
		boolean minSet = false;
		int newRemainingWire;
		for(int i = 0; i < freeSpots.size(); i++) {
			newRemainingWire = remainingWire;
			Integer allocatedSpot = freeSpots.remove(i);
			Integer rightLimit = allocatedSpots.ceiling(allocatedSpot);
			Integer leftLimit = allocatedSpots.floor(allocatedSpot);
			
			allocatedSpots.add(allocatedSpot);
			newRemainingWire -= (allocatedSpot - leftLimit) + (rightLimit - allocatedSpot);
			int finalRemainingWire = unusedWire(allocatedSpots, freeSpots, totalSpots, newRemainingWire);
			if(finalRemainingWire >= 0 && min > finalRemainingWire) {
				minSet = true;
				min = finalRemainingWire;
			}
			//add back
			freeSpots.add(i, allocatedSpot);
			allocatedSpots.remove(allocatedSpot);
		}

		return minSet? min: -1;
	}
}
