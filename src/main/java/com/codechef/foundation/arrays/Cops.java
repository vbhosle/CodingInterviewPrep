package com.codechef.foundation.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cops {

	public static void main(String[] args) {
		FastReader reader = new FastReader();

		int testCases = reader.nextInt();
		boolean[] unsafeHouses;
		int[] copsHouses;
		int m, speed, mins, housesCovered;
		
		while(testCases > 0) {
			m = reader.nextInt();
			speed = reader.nextInt();
			mins = reader.nextInt();
			housesCovered = speed * mins;
			unsafeHouses = new boolean[101];
			copsHouses = new int[m];
			for(int i = 1; i <= m; i++) {
				copsHouses[i] = reader.nextInt();
			}
			int count = totalSafeHousesBruteForce(unsafeHouses, copsHouses, m, housesCovered);
			System.out.println(count);
			testCases--;
		}
	}

	static int totalSafeHousesBinarySearch(boolean[] unsafeHouses, int[] copsHouses, int m, int housesCovered) {
		int count = 0;
		
		Arrays.sort(copsHouses);
		
		return count;
	}
	
	static boolean binarySearch(int[] copsHouses, int house, int housesCovered) {
		return binarySearch(copsHouses, 0, copsHouses.length, house, housesCovered);
	}
	
	static boolean binarySearch(int[] copsHouses, int min, int max, int house, int housesCovered) {
		if(min >= max) return true;
		int mid = (min + max)/2;
		int leftLimit = copsHouses[mid] - housesCovered;
		int rightLimit = copsHouses[mid] + housesCovered;
		if(house < leftLimit) return binarySearch(copsHouses, min, mid, house, housesCovered);
		if(house > rightLimit) return binarySearch(copsHouses, mid, max, house, housesCovered);
		return false;
	}
	
	static int binarySearchNearestGreat(int[] copsHouses, int house, int housesCovered) {
		int low = 0;
		int high = copsHouses.length;
		int mid;
		int max = copsHouses[copsHouses.length-1];
		while(low <= high) {
			mid = (low + high) / 2;
			if(house < copsHouses[mid]) {
				max = copsHouses[mid];
				high = mid;
			}
			else if(house > copsHouses[mid]) {
				break;
			}
		}
		
		return max;
	}
	
	static int binarySearchNearestSmall(int[] copsHouses, int house, int housesCovered) {
		int low = 0;
		int high = copsHouses.length;
		int mid;
		int min = copsHouses[0];
		while(low <= high) {
			mid = (low + high) / 2;
			if(house >= copsHouses[mid]) {
				min = copsHouses[mid];
				low = mid;
			}
			else if(house < copsHouses[mid]) {
				break;
			}
		}
		
		return min;
	}
	
	static int totalSafeHousesBruteForce(boolean[] unsafeHouses, int[] copsHouses, int m, int housesCovered) {
		int low;
		int high;
		for(int i = 1; i <= m; i++) {
			low = (copsHouses[i] - housesCovered) < 0 ? 0: (copsHouses[i] - housesCovered);
			high = (copsHouses[i] + housesCovered) > 100 ? 100: (copsHouses[i] + housesCovered);
			for(int j = low; j<= high; j++) {
				unsafeHouses[j] = true;
			}
		}
		
		int count = 0;
		for(int i = 1; i<= 100; i++) {
			if(unsafeHouses[i] == false) {
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
}
