package ctci.dynamic;

import java.util.*;

public class UniquePath3 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0 ,0},
                {0, 0, 0, 0},
                {0, 0, 2, -1},
        };
        System.out.println(uniquePathsIII(grid));
    }

    public static int uniquePathsIII(int[][] grid) {
        Point start = new Point(0, 0);
        int rows = grid.length;
        int columns = grid[0].length;
        int obstacles = 0;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(grid[row][column] == 1) {
                    start.row = row;
                    start.column = column;
                }
                if(grid[row][column] == -1)
                    obstacles++;
            }
        }


        return findPath(grid, new HashSet<>(), new LinkedList<>(), rows*columns - obstacles, start.row, start.column);
    }

    public static int findPath(int[][] grid, Set<Point> visited, LinkedList<Point> path, int pathLen, int row, int column) {
        if(row < 0 || column < 0 || row == grid.length || column == grid[0].length || grid[row][column] == -1)
            return 0;

        Point p = new Point(row, column);

        if(visited.contains(p))
            return 0;

        if(grid[row][column] == 2) {
            if(visited.size() == (pathLen - 1))
                return 1;
            else
                return 0;
        }

        visited.add(p);
        path.add(p);
        int upCount = findPath(grid, visited, path, pathLen,row - 1, column);
        int rightCount = findPath(grid, visited, path, pathLen, row, column + 1);
        int downCount = findPath(grid, visited, path, pathLen, row + 1, column);
        int leftCount = findPath(grid, visited, path, pathLen, row, column - 1);
        visited.remove(p);
        path.removeLast();
        int total = upCount + rightCount + downCount + leftCount;

        return total;
    }

    static class Point {
        int row;
        int column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public int hashCode() {
            int result = row;
            return 31 * result + column;
        }

        @Override
        public boolean equals(Object other) {
            Point otherPoint = (Point) other;
            return otherPoint.row == this.row && otherPoint.column == this.column;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }
}
