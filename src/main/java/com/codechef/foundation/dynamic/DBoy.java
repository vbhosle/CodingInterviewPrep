package com.codechef.foundation.dynamic;

import java.util.Arrays;

public class DBoy {

	public static void main(String[] args) {
		int[] houses = {1, 2, 3, 4};
		int[] stationCapacities = {1, 4, 5, 3};
		System.out.println(minRefills(houses, stationCapacities, 4));
		
		houses = new int[]{3, 4, 5};
		stationCapacities = new int[]{3, 4, 5};
		System.out.println(minRefills(houses, stationCapacities, 5));
		System.out.println(args[2]);
		
		System.out.println("####");
		int i = 0;
		for(int n = 5; i<=10; n ^= 5 ^ 5 ,i++)
			System.out.println(n);
	}

	public static int minRefills(int[] houses, int[] stationCapacities, int maxHouse) {
		Arrays.sort(stationCapacities);
		int N = stationCapacities.length;
		int[] minRefillForLiter = new int[1001];
		Arrays.fill(minRefillForLiter, Integer.MAX_VALUE);
		minRefillForLiter[0] = 0;
		int remaining;
		for (int i = 1; i <= maxHouse*2; i++) {
			for (int j = 0; j < N; j++) {
				if (stationCapacities[j] <= i) {
					remaining = i - stationCapacities[j];
					//we may not be able to refill exactly for remaining liters, so that value would remain Integer.MAX_VALUE
					if(minRefillForLiter[remaining] < Integer.MAX_VALUE){
					    minRefillForLiter[i] = Math.min(minRefillForLiter[i], 1 + minRefillForLiter[remaining]);
					}
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += minRefillForLiter[houses[i]*2];
		}

		return sum;
	}

}
