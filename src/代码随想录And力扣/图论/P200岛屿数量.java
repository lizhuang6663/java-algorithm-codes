package 代码随想录And力扣.图论;

import java.util.ArrayDeque;
import java.util.Deque;

// dfs（回溯）：连通性问题，bfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/number-of-islands/description/

// 相同问题：P1451求细胞数量
// 洛谷：https://www.luogu.com.cn/problem/P1451
// 使用dfs，并往四个方向延伸

public class P200岛屿数量 {

    // 方法一：dfs深搜（回溯）
//    int ans = 0;
//    int[][] isUsed;
//
//    public int numIslands(char[][] grid) {
//        isUsed = new int[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//
//                if (isUsed[i][j] == 0 && grid[i][j] != '0') {
//                    ans++;
//                    dfs(grid, i, j);
//                }
//
//            }
//        }
//
//        return ans;
//    }
//
//    public void dfs(char[][] grid, int i, int j) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || isUsed[i][j] == 1) {
//            return;
//        }
//
//        isUsed[i][j] = 1;
//
//        // 往四个方向递归
//        dfs(grid, i - 1, j);
//
//        dfs(grid, i + 1, j);
//
//        dfs(grid, i, j - 1);
//
//        dfs(grid, i, j + 1);
//    }


//    // 不使用 isUsed 数组，将算过的位置置为0
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//
//        int nr = grid.length;
//        int nc = grid[0].length;
//        int num_islands = 0;
//        for (int r = 0; r < nr; ++r) {
//            for (int c = 0; c < nc; ++c) {
//                if (grid[r][c] == '1') {
//                    ++num_islands;
//                    dfs2(grid, r, c);
//                }
//            }
//        }
//
//        return num_islands;
//    }
//
//    void dfs2(char[][] grid, int r, int c) {
//        int nr = grid.length;
//        int nc = grid[0].length;
//
//        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
//            return;
//        }
//
//        grid[r][c] = '0';
//        dfs2(grid, r - 1, c);
//        dfs2(grid, r + 1, c);
//        dfs2(grid, r, c - 1);
//        dfs2(grid, r, c + 1);
//    }


    // 方法二：bfs广搜
    int ans = 0;
    boolean[][] isUsed;
    int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};    // 移动的位置

    public int numIslands(char[][] grid) {
        isUsed = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (!isUsed[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ans++;
                }

            }
        }

        return ans;
    }


    public void bfs(char[][] grid, int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        isUsed[i][j] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int n = arr[0];
            int m = arr[1];

            for (int k = 0; k < 4; k++) {
                int x = n + move[k][0];
                int y = m + move[k][1];

                if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) continue;
                if (!isUsed[x][y] && grid[x][y] == '1') {
                    queue.offer(new int[]{x, y});
                    isUsed[x][y] = true;
                }
            }
        }

    }

}