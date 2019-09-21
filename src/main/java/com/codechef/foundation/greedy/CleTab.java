package com.codechef.foundation.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CleTab {
	public static void main(String[] args) throws java.lang.Exception {

	}

	public static int minCleanups(int tables, int[] orders) {
//		System.out.println("Orders = " + Arrays.toString(orders));
//		System.out.println("Tables = " + tables);
		Set<Integer> occupiedTables = new HashSet<>(tables);
		int cleanups = 0;
		for (int i = 0; i < orders.length; i++) {
//			System.out.println("Get table for order " + orders[i]);
			if (!occupiedTables.contains(orders[i])) {
				if (occupiedTables.size() == tables) {
					int farthestInFuture = farthestInFuture(occupiedTables, orders, i);
					occupiedTables.remove(farthestInFuture);
					//System.out.println("Tables full, vacated customer " + farthestInFuture);
				}
				cleanups++;
//				System.out.println("Cleaned up .." + cleanups);
				occupiedTables.add(orders[i]);
			}
//			else {
//				System.out.println(" No cleanup required");
//			}
		}

		return cleanups;
	}

	
	
	public static int farthestInFuture(Set<Integer> occupiedTables, int[] orders, int currentIndex) {
		Map<Integer, Integer> seenAt = new HashMap<>();
		for (int i = currentIndex + 1; i < orders.length; i++) {
			if (occupiedTables.contains(orders[i]) && !seenAt.containsKey(orders[i])) {
				seenAt.put(orders[i], i);
			}
		}

		occupiedTables.stream().filter(t -> !seenAt.containsKey(t)).forEach(t -> seenAt.put(t, Integer.MAX_VALUE));
		Optional<Entry<Integer, Integer>> max = seenAt.entrySet().stream().max(Map.Entry.comparingByValue());
		
		return max.get().getKey();
	}
}