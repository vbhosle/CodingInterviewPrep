package google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class RabitHouse {
    public static void main(String[] args) throws Exception{
        FastReader reader = new FastReader();
        final int T = reader.nextInt();
        int R = 0;
        int C = 0;
        for(int testCase = 1; testCase <= T; testCase++) {
            R = reader.nextInt();
            C = reader.nextInt();

            Queue<Box> queue = new PriorityQueue<>(Comparator.comparingInt(Box::getHeight).reversed());
            int[][] grid = new int[R][C];

            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                        grid[row][col] = reader.nextInt();
                        queue.add(new Box(grid[row][col], row, col));
                }
            }

            long ans = 0L;

            while (!queue.isEmpty()) {
                Box box = queue.peek();
                int i = box.getRow();
                int j = box.getColumn();

                if (i + 1 < R && grid[i][j] - grid[i + 1][j] > 1) {
                    ans += grid[i][j] - grid[i + 1][j] - 1;
                    grid[i + 1][j] = grid[i][j] - 1;
                    queue.add(new Box(grid[i + 1][j], i + 1, j));
                }
                if (j + 1 < C && grid[i][j] - grid[i][j + 1] > 1) {
                    ans += grid[i][j] - grid[i][j + 1] - 1;
                    grid[i][j + 1] = grid[i][j] - 1;
                    queue.add(new Box(grid[i][j + 1], i, j + 1));
                }
                if (i - 1 >= 0 && grid[i][j] - grid[i - 1][j] > 1) {
                    ans += grid[i][j] - grid[i - 1][j] - 1;
                    grid[i - 1][j] = grid[i][j] - 1;
                    queue.add(new Box(grid[i - 1][j], i - 1, j));
                }
                if (j - 1 >= 0 && grid[i][j] - grid[i][j - 1] > 1) {
                    ans += grid[i][j] - grid[i][j - 1] - 1;
                    grid[i][j - 1] = grid[i][j] - 1;
                    queue.add(new Box(grid[i][j - 1], i, j - 1));
                }

                queue.poll();
            }

            System.out.println("Case #" + testCase + ": " + ans);
        }
    }
    static class Box {
        int height;
        int row;
        int column;

        public Box(int height, int row, int column) {
            this.height = height;
            this.row = row;
            this.column = column;
        }

        public int getHeight() {
            return height;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws Exception{
            if(st == null || !st.hasMoreElements()){
                st = new StringTokenizer(br.readLine());
            }

            return st.nextToken();
        }

        public int nextInt() throws Exception{
            return Integer.parseInt(next());
        }

        public long nextLong() throws Exception{
            return Long.parseLong(next());
        }

        public String nextLine() throws Exception{
            return br.readLine();
        }
    }
}
