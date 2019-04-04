package com.codechef.cakewalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trisq {
	/*
	 * Max squares that fit in isosceles right angle triangle.
	 */
	public int maxSquaresTriangle(int base, int squareLen) {
		int touchPointsOnHypotenuse = base / squareLen - 1;
		if (touchPointsOnHypotenuse <= 0)
			return 0;
		return touchPointsOnHypotenuse + maxSquaresTriangle(base - 2, squareLen);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Trisq solver = new Trisq();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 1; i <= T; i++) {
			System.out.println(solver.maxSquaresTriangle(Integer.parseInt(reader.readLine()), 2));
		}
	}
}
