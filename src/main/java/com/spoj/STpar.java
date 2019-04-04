package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//WRONG ANSWER!!
public class STpar {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		STpar solver = new STpar();
		reader.readLine();
		String input = reader.readLine();
		int[] trucks = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(solver.canReorderTrucksWithSideStreet(trucks));
	}

	public String canReorderTrucksWithSideStreet(int trucks[]) {
		if (trucks == null || trucks.length == 0)
			return "no";

		int expectedTruck = 1;
		Deque<Integer> sideStreet = new ArrayDeque<>();

		for (int i = 0; i < trucks.length;) {

			while (i < trucks.length && trucks[i] == expectedTruck) {
				expectedTruck++;
				i++;
			}

			while (!sideStreet.isEmpty() && sideStreet.peek() == expectedTruck) {
				sideStreet.pop();
				expectedTruck++;
			}

			if (i < trucks.length) {
				sideStreet.push(trucks[i++]);
			}
		}

		while (!sideStreet.isEmpty() && sideStreet.peek() == expectedTruck) {
			sideStreet.pop();
			expectedTruck++;
		}

		return sideStreet.isEmpty()?"yes":"no";
	}

}
