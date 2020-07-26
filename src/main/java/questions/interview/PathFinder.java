package questions.interview;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class PathFinder {

	public static List<LinkedList<String>> walkFromStart(String[][] adjTable) {
		if (adjTable == null || adjTable.length < 2)
			throw new IllegalArgumentException("minimum two rows expected");

		int rows = adjTable.length;
		List<LinkedList<String>> paths = new ArrayList<>();

		String source = source(adjTable[0]);
		String destination = destination(adjTable[0]);

		for (int i = 1; i < rows; i++) {
			LinkedList<String> path = walk(adjTable, i, destination);
			if (!path.isEmpty()) {
				path.addFirst(destination);
				path.addFirst(source);
				paths.add(path);
			}
		}

		return paths;
	}

	private static LinkedList<String> walk(String[][] adjTable, int row, String tail) {
		if (row >= adjTable.length) {
			return new LinkedList<>();
		}

		String source = source(adjTable[row]);
		String destination = destination(adjTable[row]);

		if (source.equals(tail) && source != destination) {
			LinkedList<String> path = walk(adjTable, row + 1, destination);
			path.addFirst(destination);
			return path;
		} else {
			return new LinkedList<>();
		}

	}

	private static String source(String[] row) {
		return row[0];
	}

	private static String destination(String[] row) {
		return row[1];
	}
}
