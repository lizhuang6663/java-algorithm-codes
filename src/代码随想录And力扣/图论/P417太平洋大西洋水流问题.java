package 代码随想录And力扣.图论;

import java.util.*;

// dfs，bfs（三维标记数组）
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/pacific-atlantic-water-flow/

public class P417太平洋大西洋水流问题 {

    // 方法一：dfs
//    boolean[][][] visited;
//    List<List<Integer>> result = new ArrayList<>();
//    int[][] position = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        int rowSize = heights.length, colSize = heights[0].length;
//        visited = new boolean[rowSize][colSize][2];
//
//        // 假设太平洋的标记为 1，大西洋为 0
//        for (int row = 0; row < rowSize; row++) {
//            visited[row][colSize - 1][0] = true;
//            visited[row][0][1] = true;
//
//            dfs(heights, row, colSize - 1, 0);
//            dfs(heights, row, 0, 1);
//        }
//
//        for (int col = 0; col < colSize; col++) {
//            visited[rowSize - 1][col][0] = true;
//            visited[0][col][1] = true;
//
//            dfs(heights, rowSize - 1, col, 0);
//            dfs(heights, 0, col, 1);
//        }
//
//        for (int row = 0; row < rowSize; row++) {
//            for (int col = 0; col < colSize; col++) {
//                // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
//                if (visited[row][col][0] && visited[row][col][1]) {
//                    result.add(Arrays.asList(row, col));
//                    // 或者：result.add(List.of(row, col));
//                }
//
//            }
//        }
//
//        return result;
//    }
//
//
//    /**
//     * @param heights 题目给定的二维数组
//     * @param row     当前位置的行号
//     * @param col     当前位置的列号
//     * @param sign    记录是哪一条河，两条河中可以一个为 0，一个为 1
//     */
//    public void dfs(int[][] heights, int row, int col, int sign) {
//        for (int i = 0; i < 4; i++) {
//            int curRow = row + position[i][0];
//            int curCol = col + position[i][1];
//
//            // 越界
//            if (curRow < 0 || curCol < 0 || curRow == heights.length || curCol == heights[0].length) continue;
//
//            // 高度不合适或者已经被访问过了
//            if (heights[row][col] > heights[curRow][curCol] || visited[curRow][curCol][sign]) continue;
//
//            visited[curRow][curCol][sign] = true;
//            dfs(heights, curRow, curCol, sign);
//        }
//    }


    // 方法二：bfs
    boolean[][][] visited;
    List<List<Integer>> result = new ArrayList<>();
    int[][] position = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Deque<int[]> deque = new ArrayDeque<>(); // 队列，保存的数据为 [行号, 列号, 标记]
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length, colSize = heights[0].length;
        visited = new boolean[rowSize][colSize][2];

        // 假设太平洋的标记为 1，大西洋为 0
        for (int row = 0; row < rowSize; row++) {
            visited[row][colSize - 1][0] = true;
            visited[row][0][1] = true;

            deque.add(new int[]{row, colSize - 1, 0});
            deque.add(new int[]{row, 0, 1});
        }

        for (int col = 0; col < colSize; col++) {
            visited[rowSize - 1][col][0] = true;
            visited[0][col][1] = true;

            deque.add(new int[]{rowSize - 1, col, 0});
            deque.add(new int[]{0, col, 1});
        }

        bfs(heights);

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                if (visited[row][col][0] && visited[row][col][1]) {
                    result.add(Arrays.asList(row, col));
                }

            }
        }

        return result;
    }


    public void bfs(int[][] heights) {
        while (!deque.isEmpty()) {
            int[] curPos = deque.poll();

            for (int[] current: position) {
                int row = curPos[0] + current[0], col = curPos[1] + current[1], sign = curPos[2];

                // 越界
                if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) continue;

                // 高度不合适或者已经被访问过了
                if (heights[row][col] < heights[curPos[0]][curPos[1]] || visited[row][col][sign]) continue;
                visited[row][col][sign] = true;
                deque.add(new int[]{row, col, sign});
            }
        }

    }


}
