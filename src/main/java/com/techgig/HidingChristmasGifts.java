package com.techgig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class HidingChristmasGifts {
	int totalHomes;
	String[][] shortestPathsCache;
	List<Set<Integer>> neighbors;

	public HidingChristmasGifts(int totalHomes) {
		this.totalHomes = totalHomes;
		shortestPathsCache = new String[totalHomes + 1][totalHomes + 1];
		neighbors = new ArrayList<>(totalHomes + 1);
		for (int i = 0; i <= totalHomes; i++) {
			neighbors.add(new HashSet<Integer>());
		}
	}

	public void findShortestPath(int src, int dest) {
		Queue<MinHeapNode> minHeap = new PriorityQueue<>();
		minHeap.add(new MinHeapNode(src, 0));
		for (int i = 1; i < totalHomes; i++) {
			if(i!=src) {
				minHeap.add(new MinHeapNode(i, Integer.MAX_VALUE));
			}
		}
		while (!minHeap.isEmpty()) {
			MinHeapNode u = minHeap.remove();
			
			//update distance to neighbouring vertices
			for(Integer v:neighbors.get(src)) {
				minHeap.removeIf(node -> ((u.distance + 1) < node.distance));
			}
		}
	}

	private static class MinHeapNode {
		int id;
		int distance;

		public MinHeapNode(int id, int distance) {
			this.id = id;
			this.distance = distance;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			MinHeapNode other = (MinHeapNode) obj;
			if (id != other.id)
				return false;
			return true;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

	}

}
