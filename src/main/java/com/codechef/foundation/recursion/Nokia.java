package com.codechef.foundation.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Nokia {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(unusedWire(3, 8));
		System.out.println(unusedWire(3, 9));
		System.out.println(unusedWire(2, 4));
		System.out.println(unusedWire(5, 25));
		System.out.println(unusedWire(10, 50));
		long end = System.currentTimeMillis();
		System.out.println("Total time: " + (end - start));
		
		start = System.currentTimeMillis();
		System.out.println(unusedWire01(3, 8));
		System.out.println(unusedWire01(3, 9));
		System.out.println(unusedWire01(2, 4));
		System.out.println(unusedWire01(5, 25));
		System.out.println(unusedWire01(10, 50));
		end = System.currentTimeMillis();
		System.out.println("Total time: " + (end - start));
		
		start = System.currentTimeMillis();
		System.out.println(unusedWire02(3, 8));
		System.out.println(unusedWire02(3, 9));
		System.out.println(unusedWire02(2, 4));
		System.out.println(unusedWire02(5, 25));
		System.out.println(unusedWire02(10, 50));
		end = System.currentTimeMillis();
		System.out.println("Total time: " + (end - start));
		
		start = System.currentTimeMillis();
		System.out.println(unusedWire03(3, 8));
		System.out.println(unusedWire03(3, 9));
		System.out.println(unusedWire03(2, 4));
		System.out.println(unusedWire03(5, 25));
		System.out.println(unusedWire03(10, 50));
		end = System.currentTimeMillis();
		System.out.println("Total time: " + (end - start));
	}

	public static int unusedWire(int spots, int wireLength) {
		ArrayList<Integer> freeSpots = IntStream.rangeClosed(1, spots).boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		return unusedWire(new TreeSet<>(Arrays.asList(0, spots + 1)), freeSpots, spots, wireLength);
	}

	// timeout
	public static int unusedWire(TreeSet<Integer> allocatedSpots, List<Integer> freeSpots, int totalSpots,
			final int remainingWire) {
		if (freeSpots.isEmpty()) {
//			System.out.println("Remaining wire for the combo: " + allocatedSpots + " = " + remainingWire);
			return remainingWire;
		}

		int min = remainingWire;
		boolean minSet = false;
		int newRemainingWire;
		for (int i = 0; i < freeSpots.size(); i++) {
			newRemainingWire = remainingWire;
			Integer allocatedSpot = freeSpots.remove(i);
			Integer rightLimit = allocatedSpots.ceiling(allocatedSpot);
			Integer leftLimit = allocatedSpots.floor(allocatedSpot);

			allocatedSpots.add(allocatedSpot);
			newRemainingWire -= (allocatedSpot - leftLimit) + (rightLimit - allocatedSpot);
			int finalRemainingWire = unusedWire(allocatedSpots, freeSpots, totalSpots, newRemainingWire);
			if (finalRemainingWire >= 0 && min > finalRemainingWire) {
				minSet = true;
				min = finalRemainingWire;
			}
			// add back
			freeSpots.add(i, allocatedSpot);
			allocatedSpots.remove(allocatedSpot);
		}

		return minSet ? min : -1;
	}

	public static int unusedWire01(int spots, int wireLength) {
		int[] freeSpots = new int[spots+1];
		Arrays.fill(freeSpots, 1);
		return unusedWire01(new TreeSet<>(Arrays.asList(0, spots + 1)), freeSpots, spots, wireLength);
	}

	// timeout
	public static int unusedWire01(TreeSet<Integer> allocatedSpots, int[] freeSpots, int totalSpots,
			final int remainingWire) {
		if (allocatedSpots.size() - 2 == totalSpots) {
			return remainingWire;
		}

		int min = remainingWire;
		boolean minSet = false;
		int newRemainingWire;
		for (int i = 1; i < freeSpots.length; i++) {
			if (freeSpots[i] == 1) {
				newRemainingWire = remainingWire;
				Integer allocatedSpot = i;
				freeSpots[i] = 0;
				Integer rightLimit = allocatedSpots.ceiling(allocatedSpot);
				Integer leftLimit = allocatedSpots.floor(allocatedSpot);

				allocatedSpots.add(allocatedSpot);
				newRemainingWire -= (allocatedSpot - leftLimit) + (rightLimit - allocatedSpot);
				int finalRemainingWire = unusedWire01(allocatedSpots, freeSpots, totalSpots, newRemainingWire);
				if (finalRemainingWire >= 0 && min > finalRemainingWire) {
					minSet = true;
					min = finalRemainingWire;
				}
				// add back
				freeSpots[i] = 1;
				allocatedSpots.remove(allocatedSpot);
			}
		}

		return minSet ? min : -1;
	}
	
	public static int unusedWire02(int spots, int wireLength) {
		int[] freeSpots = new int[spots+1];
		freeSpots[0] = 1;
		return unusedWire02(freeSpots, spots, wireLength);
	}

	// timeout
	public static int unusedWire02(int[] freeSpots, int remainingSpots,
			final int remainingWire) {
		if (remainingSpots == 0) {
			return remainingWire;
		}

		int min = remainingWire;
		boolean minSet = false;
		int newRemainingWire;
		for (int i = 1; i < freeSpots.length; i++) {
			if (freeSpots[i] == 0) {
				newRemainingWire = remainingWire;
				Integer allocatedSpot = i;
				freeSpots[i] = 1;
				Integer rightLimit = getRightLimit(freeSpots, allocatedSpot);
				Integer leftLimit = getLeftLimit(freeSpots, allocatedSpot);

				newRemainingWire -= (allocatedSpot - leftLimit) + (rightLimit - allocatedSpot);
				int finalRemainingWire = unusedWire02(freeSpots, --remainingSpots, newRemainingWire);
				if (finalRemainingWire >= 0 && min > finalRemainingWire) {
					minSet = true;
					min = finalRemainingWire;
				}
				// add back
				freeSpots[i] = 0;
				remainingSpots++;
			}
		}

		return minSet ? min : -1;
	}
	
	public static int getRightLimit(int[] freeSpots, int k) {
		int right = freeSpots.length;
		for(int i = k+1; i < freeSpots.length; i++) {
			if(freeSpots[i] == 1) return i;
		}
		return right;
	}
	
	public static int getLeftLimit(int[] freeSpots, int k) {
		int left = 0;
		for(int i = k - 1; i >= 1; i--) {
			if(freeSpots[i] == 1) return i;
		}
		return left;
	}
	
	//accepted
	//https://discuss.codechef.com/t/nokia-editorial/314
	public static int unusedWire03(int spots, int wireLength) {
		int max = (spots * (spots+3))/2;
		int min = findMinWireUsed(spots);
		if(wireLength < min) return -1;
		if(wireLength > max) return wireLength - max;
		return 0;
		
	}
	
	public static int findMinWireUsed(int n) {
		if(n <= 0) return 0;
		return n+1 + findMinWireUsed(n/2) + findMinWireUsed(n - n/2 - 1);
	}
}
