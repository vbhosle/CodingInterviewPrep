package com.codechef.foundation.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CNote {

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int testCases = reader.nextInt();
		int poetryLength, currentNotebookPages, money, notebooks;
		int[] pages, prices;
		
		while(testCases > 0) {
			poetryLength = reader.nextInt();
			currentNotebookPages = reader.nextInt();
			money = reader.nextInt();
			notebooks = reader.nextInt();
			pages = new int[notebooks];
			prices = new int[notebooks];
			for(int i = 0; i < notebooks; i++) {
				pages[i] = reader.nextInt();
				prices[i] = reader.nextInt();
			}
			System.out.println(isLuckyChef(poetryLength, currentNotebookPages, money, notebooks, pages, prices));
			testCases--;
		}
	}
	
	public static String isLuckyChef(int poetryLength, int currentNotebookPages, int money, int notebooks, int[] pages, int[] prices) {
		int requiredPages = poetryLength - currentNotebookPages;
		if(requiredPages <= 0) return "LuckyChef";
		if(money == 0 || notebooks == 0) return "UnluckyChef";
		
		for(int i = 0; i< notebooks; i++) {
			if(pages[i] >= requiredPages && prices[i] <= money) {
				return "LuckyChef";
			}
		}
		
		return "UnluckyChef";
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return str;
		}
	}
}
