package com.codechef.foundation.dynamic;

import java.util.Comparator;

public class GRID {
	private static final char FREE = '.';
	private static final char ROCK = '#';
	
	public static void main(String[] args) {
		char[][] grid = new char[][] {
			{ROCK, FREE, FREE},
			{ROCK, FREE, FREE},
			{ROCK, FREE, FREE}
		};
		System.out.println(maxMirrors(grid));
		grid = new char[][] {
			{ROCK, FREE, ROCK},
			{ROCK, FREE, ROCK},
			{ROCK, FREE, ROCK}
		};
		System.out.println(maxMirrors(grid));
		grid = new char[][] {
			{FREE, FREE, FREE},
			{FREE, FREE, FREE},
			{FREE, FREE, FREE}
		};
		System.out.println(maxMirrors(grid));
	}
	
	public static int maxMirrors(char[][] grid){
	    int N = grid.length;
	    boolean[] columnHasRock = new boolean[N];
	    boolean isRockOnRight;
	    int count = 0;
	    // progress from bottom right to top left
	    for(int row = N - 1; row >= 0; row--){
	        isRockOnRight = false;
	       for(int col = N - 1; col >= 0; col--){
	            if(grid[row][col] == ROCK){
	                isRockOnRight = true;
	                columnHasRock[col] = true;
	            }
	            if(!isRockOnRight && !columnHasRock[col]){
	                count++;
	            }
	       } 
	    }
	    
	    return count;
	}

}
