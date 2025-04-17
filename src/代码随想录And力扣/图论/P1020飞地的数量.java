package 代码随想录And力扣.图论;


import java.util.ArrayDeque;
import java.util.Deque;

// bfs（回溯），bfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/number-of-enclaves/description/

// 从边缘开始找，找到挨着边缘的格子，把这个格子置为0，然后把联通着这个格子的1置为0，最后全部的格子减去值为1的格子的数量就是最后的结果
// (从周边找到陆地然后 通过 dfs或者bfs 将周边靠陆地且相邻的陆地都变成海洋，然后再去重新遍历地图的时候，统计此时还剩下的陆地就可以了。)

public class P1020飞地的数量 {
    // 方法一和方法二都可以使用标记数组，也可以不使用

    // 方法一：dfs（不使用标记数组）
//    int result = 0;
//    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//    public int numEnclaves( int[][] grid) {
//        // 遍历边缘的1
//        for (int i = 0; i < grid.length; i++) {
//            if (grid[i][0] == 1) dfs(grid, i, 0);
//            if (grid[i][grid[i].length - 1] == 1) dfs(grid, i, grid[i].length - 1);
//        }
//
//        for (int j = 1; j < grid[0].length - 1; j++) {
//            if (grid[0][j] == 1) dfs(grid, 0, j);
//            if (grid[grid.length - 1][j] == 1) dfs(grid, grid.length - 1, j);
//        }
//
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 1) {
//                    result++;
//                    System.out.println(i + " " + j);
//                }
//            }
//        }
//        return result;
//    }
//
//    public void dfs(int[][] grid, int i, int j) {
//        if (grid[i][j] != 1) {
//            return;
//        }
//
//        grid[i][j] = 0;
//
//        for (int k = 0; k < 4; k++) {
//            int x = i + dir[k][0];
//            int y = j + dir[k][1];
//
//            if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) continue;
//
//            if (grid[x][y] == 1) {
//                dfs(grid, x, y);
//            }
//        }
//    }


    // 方法二：bfs（不使用标记数组）
    int result = 0;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numEnclaves(int[][] grid) {
        // 遍历边缘的1
        for (int i = 0; i < grid.length; i++) {
            bfs(grid, i, 0);
            bfs(grid, i, grid[i].length - 1);
        }

        for (int j = 1; j < grid[0].length - 1; j++) {
            bfs(grid, 0, j);
            bfs(grid, grid.length - 1, j);
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result++;
//                    System.out.println(i + " " + j);
                }
            }
        }
        return result;
    }


    public void bfs(int[][] grid, int i, int j) {
        if (grid[i][j] != 1) return;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        grid[i][j] = 0;

        while (!deque.isEmpty()) {
            int[] temp = deque.poll();

            for (int k = 0; k < 4; k++) {
                int x = temp[0] + dir[k][0];
                int y = temp[1] + dir[k][1];

                if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) continue;

                if (grid[x][y] == 1) {
                    deque.add(new int[]{x, y});
                    grid[x][y] = 0;
                }
            }
        }

    }


}
