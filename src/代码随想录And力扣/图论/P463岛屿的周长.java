package 代码随想录And力扣.图论;


// dfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/island-perimeter/description/

public class P463岛屿的周长 {

    // 方法一：dfs
    // 做法：不要想的太复杂了，遍历每一个空格，遇到岛屿，计算其上下左右的情况，遇到水域或者出界的情况，就可以计算边了。
    int result;
    int[][] position = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && !visited[i][j])  dfs(grid, i, j);

            }
        }

        return result;
    }

    public void dfs(int[][] grid, int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int row = i + position[k][0];
            int col = j + position[k][1];

            // 遇到水域或者出界的情况，就可以计算边了。
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
                result++;
                continue;
            }

            // 必须没有使用过才可以dfs
            if (!visited[row][col]) dfs(grid, row, col);

        }
    }

    // 另一种写法
//    int[] dirx = {-1, 1, 0, 0}; // 上下左右 4 个方向
//    int[] diry = {0, 0, -1, 1};
//
//    public int islandPerimeter(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int res = 0; // 岛屿周长
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    for (int k = 0; k < 4; k++) {
//                        int x = i + dirx[k];
//                        int y = j + diry[k];
//                        // 当前位置是陆地，并且从当前位置4个方向扩展的“新位置”是“水域”或“新位置“越界，则会为周长贡献一条边
//                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
//                            res++;
//                            continue;
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }



    // 方法二：计算出总的岛屿数量，因为有一对相邻两个陆地，边的总数就减2，那么在计算出相邻岛屿的数量就可以了。result = 岛屿数量 * 4 - cover * 2;
//    public int islandPerimeter(int[][] grid) {
//        // 计算岛屿的周长
//        // 方法二 : 遇到相邻的陆地总周长就-2
//        int landSum = 0; // 陆地数量
//        int cover = 0; // 相邻陆地数量
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    landSum++;
//                    // 统计上面和左边的相邻陆地
//                    if(i - 1 >= 0 && grid[i-1][j] == 1) cover++;
//                    if(j - 1 >= 0 && grid[i][j-1] == 1) cover++;
//                }
//            }
//        }
//        return landSum * 4 - cover * 2;
//    }


}
