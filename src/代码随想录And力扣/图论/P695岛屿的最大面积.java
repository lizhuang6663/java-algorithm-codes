package 代码随想录And力扣.图论;


import java.util.ArrayDeque;
import java.util.Deque;

// dfs（回溯），bfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/max-area-of-island/description/

public class P695岛屿的最大面积 {

    // 方法一：dfs
//    int result = Integer.MIN_VALUE;
//    int count = 0;
//    boolean[][] isUsed;
//    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//    public int maxAreaOfIsland(int[][] grid) {
//        isUsed = new boolean[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//
//                if (!isUsed[i][j] && grid[i][j] == 1) {
//                    count = 0;
//                    dfs(grid, i, j);
//                    result = Math.max(result, count);
//                }
//
//            }
//        }
//
//        return result == Integer.MIN_VALUE ? 0 : result;
//    }
//
//    public void dfs(int[][] grid, int i, int j) {
//        if (isUsed[i][j] || grid[i][j] != 1) {
//            return;
//        }
//
//        isUsed[i][j] = true;
//        count++;
//
//        for (int k = 0; k < 4; k++) {
//            int x = i + dir[k][0];
//            int y = j + dir[k][1];
//
//            if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) {
//                continue;
//            }
//            dfs(grid, x, y);
//        }
//    }


    // 方法二：bfs
    int result = Integer.MIN_VALUE;
    int count = 0;
    boolean[][] isUsed;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        isUsed = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (!isUsed[i][j] && grid[i][j] == 1) {
                    count = 0;
                    bfs(grid, i, j);
                    result = Math.max(result, count);
                }

            }
        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }


    public void bfs(int[][] grid, int i, int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        isUsed[i][j] = true;
        count++;

        while (!deque.isEmpty()) {
            int[] arr = deque.poll();

            for (int k = 0; k < 4; k++) {
                int x = arr[0] + dir[k][0];
                int y = arr[1] + dir[k][1];

                if (x < 0 || y < 0 || x == grid.length || y == grid[x].length) continue;

                if (!isUsed[x][y] && grid[x][y] == 1) {
                    deque.add(new int[]{x, y});
                    isUsed[x][y] = true;
                    count++;
                }

            }
        }

    }


}
