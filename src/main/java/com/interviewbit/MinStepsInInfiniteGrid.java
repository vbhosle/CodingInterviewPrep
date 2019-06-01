package com.interviewbit;

import java.util.List;

public class MinStepsInInfiniteGrid {

	public int coverPoints(List<Integer> A, List<Integer> B) {
		int totalSteps = 0;
		int currentPointIdx, nextPointIdx;
		int size = A.size();
		
		for (int i = 1; i < size; i++) {
			currentPointIdx = i - 1;
			nextPointIdx = i;
			totalSteps += minStepsBetweenPoints(A.get(currentPointIdx), B.get(currentPointIdx), A.get(nextPointIdx), B.get(nextPointIdx));
		}
		
		return totalSteps;
	}

	public int minStepsBetweenPoints(int sx, int sy, int ex, int ey) {
		int steps = 0;
		while (!((sx == ex) && (sy == ey))) {
			int horizontalDistance = Math.abs(sx - ex);
			int verticalDistance = Math.abs(sy - ey);

			if (verticalDistance == 0 || verticalDistance == horizontalDistance)
				return steps + horizontalDistance;
			if (horizontalDistance == 0)
				return steps + verticalDistance;

			int horizontalStep = (sx - ex) > 0 ? -1 : 1;
			int verticalStep = (sy - ey) > 0 ? -1 : 1;

			if (horizontalDistance == verticalDistance) {
				// move diagonally
				sx = sx + horizontalStep;
				sy = sy + verticalStep;
			} else if (horizontalDistance > verticalDistance) {
				// move horizontally
				sx = sx + horizontalStep;
			} else {
				sy = sy + verticalStep;
			}
			steps++;
		}

		return steps;
	}
}
