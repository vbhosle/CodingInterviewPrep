package com.codechef.foundation.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Cops {

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		System.out.println((int)'a' - 'a');
		System.out.println((int)'z' - 'a');
		int testCases = reader.nextInt();
		int[] copsHouses;
		int m, speed, mins, housesCovered;

		while (testCases > 0) {
			m = reader.nextInt();
			speed = reader.nextInt();
			mins = reader.nextInt();
			housesCovered = speed * mins;
			copsHouses = new int[m];
			for (int i = 0; i < m; i++) {
				copsHouses[i] = reader.nextInt();
			}
			int count = totalSafeHouses(100, copsHouses, housesCovered);
			System.out.println(count);
			testCases--;
		}
	}

	static int totalSafeHouses(int totalHouses, int[] copsHouses, int housesCovered) {
		return totalSafeHousesOptimum(totalHouses, copsHouses, housesCovered);
	}

	static int totalSafeHousesBruteForce(int totalHouses, int[] copsHouses, int housesCovered) {
		boolean[] unsafeHouses = new boolean[totalHouses + 1];
		int low;
		int high;
		for (int i = 0; i < copsHouses.length; i++) {
			low = (copsHouses[i] - housesCovered) < 0 ? 0 : (copsHouses[i] - housesCovered);
			high = (copsHouses[i] + housesCovered) > 100 ? 100 : (copsHouses[i] + housesCovered);
			for (int j = low; j <= high; j++) {
				unsafeHouses[j] = true;
			}
		}

		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (unsafeHouses[i] == false) {
				count++;
			}
		}
		return count;
	}

	private static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	static int totalSafeHousesOptimum(int totalHouses, int[] copsHouses, int housesCovered) {
		Set<Integer> cops = new HashSet<>();
		for(Integer cop: copsHouses) {
			cops.add(cop);
		}
		int[] nextCopHouse = new int[totalHouses + 1];
		int[] prevCopHouse = new int[totalHouses + 1];
		// mark unsafe houses on right, traverse from right to left
		int latestHouseHavingCop = -1;
		for (int i = totalHouses; i >= 1; i--) {
			if(cops.contains(i)) {
				latestHouseHavingCop = i;
			}
			nextCopHouse[i] = latestHouseHavingCop;
		}
		
		latestHouseHavingCop = -1;
		for (int i = 1; i <= totalHouses; i++) {
			if(cops.contains(i)) {
				latestHouseHavingCop = i;
			}
			prevCopHouse[i] = latestHouseHavingCop;
		}

		int count = 0;
		for (int i = 1; i <= totalHouses; i++) {
			if((prevCopHouse[i] == -1 || (prevCopHouse[i] + housesCovered) < i) && (nextCopHouse[i] == -1 || (nextCopHouse[i] - housesCovered) > i)) count++;
		}
		
		return count;
	}
}
