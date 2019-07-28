package com.interviewbit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidPath {

	static class Point {
		final int x;
		final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public double distance(Point other) {
			return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		public List<Point> getNeighbors() {
			return Arrays.asList(
								  new Point(x - 1, y + 1), new Point(x, y + 1), new Point(x + 1, y + 1)
								  , new Point(x - 1, y), new Point(x, y), new Point(x + 1, y)
								  , new Point(x - 1, y - 1), new Point(x, y - 1), new Point(x + 1, y - 1)
								 );
		}

	}

	static class Circle {
		int radius;
		Point center;

		public Circle(int radius, int centerX, int centerY) {
			this.radius = radius;
			this.center = new Point(centerX, centerY);
		}

		public boolean isWithinCircle(Point p) {
			return p.distance(center) <= radius;
		}
	}

	public String solve(int x, int y, int N, int R, List<Integer> circlesX, List<Integer> circlesY) {
		final Queue<Point> queue = new LinkedList<>();
		final Set<Point> visited = new HashSet<>();

		final Set<Circle> circles = IntStream.rangeClosed(0, circlesX.size() - 1)
											 .boxed()
											 .map(i -> new Circle(R, circlesX.get(i), circlesY.get(i)))
											 .collect(Collectors.toSet());
		
		Point currentPoint = null;
		final Point finalPoint = new Point(x, y);
		
		queue.add(new Point(0, 0));

		while (!queue.isEmpty() && !finalPoint.equals(currentPoint = queue.remove())) {
			visited.add(currentPoint);
			queue.addAll(
						currentPoint.getNeighbors().stream()
						.filter(p -> (p.x >= 0 && p.x <= x) && (p.y >= 0 && p.y <= y))
						.filter(p -> !visited.contains(p) && !queue.contains(p))
						.filter(p -> circles.stream().noneMatch(c -> c.isWithinCircle(p)))
						.collect(Collectors.toList())
						);
		}

		if (currentPoint.equals(finalPoint)) {
			return "YES";
		}
		
		return "NO";
	}

}
