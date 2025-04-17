package 代码随想录And力扣.图论;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// dfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/making-a-large-island/description/

public class P827最大人工岛 {
    // 暴力:遍历地图 + 深搜岛屿，但是时间复杂度有点高
    // 优化：用一次深搜把每个岛屿的面积记录下来就好。
    // 第一步：一次遍历地图，得出各个岛屿的面积，并做编号记录。可以使用map记录，key为岛屿编号，value为岛屿面积
    // 第二步：在遍历地图，遍历0的方格（因为要将0变成1），并统计该1（由0变成的1）周边岛屿面积，将其相邻面积相加在一起，遍历所有 0 之后，就可以得出 选一个0变成1 之后的最大面积。
    int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 四个方向

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int mark = 2;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                // 只能修改1
                if (grid[i][j] == 1) {
                    int areaSize = 1 + dfs(grid, i, j, mark);
                    map.put(mark++, areaSize);
                }

            }
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 当前位置如果不是 0 那么直接跳过，因为我们只能把 0 变成 1
                if (grid[i][j] != 0) continue;

                // 防止同一个区域被重复计算
                Set<Integer> set = new HashSet<>();

                // 计算从当前位置开始获取的 1 的数量，初始化 1 是因为把当前位置的 0 转换成了 1
                int curSize = 1;

                // 向四周延伸
                for (int k = 0; k < 4; k++) {
                    int curRow = i + position[k][0];
                    int curCol = j + position[k][1];

                    if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid.length) continue;

                    int curMark = grid[curRow][curCol]; // 获取对应位置的标记

                    // 如果标记存在 set 中说明该标记被记录过一次，如果不存在 map 中说明该标记是无效标记(此时 curMark = 0)
                    if (set.contains(curMark) || !map.containsKey(curMark)) continue;
//                    if (curMark != 0) continue; // 这一步可以省略了，上面已经判断过了

                    set.add(curMark);
                    curSize += map.get(curMark);
                }
                result = Math.max(result, curSize);
            }
        }
        // 当 ans == Integer.MIN_VALUE 说明矩阵数组中不存在 0，全都是有效区域，返回数组大小即可
        return result == Integer.MIN_VALUE ? grid.length * grid.length : result;
    }


    /**
     * @param grid 矩阵数组
     * @param row  当前遍历的节点的行号
     * @param col  当前遍历的节点的列号
     * @param mark 当前区域的标记
     * @return 返回当前区域内 1 的数量
     */
    public int dfs(int[][] grid, int row, int col, int mark) {
        int ans = 0;

        grid[row][col] = mark;

        for (int i = 0; i < 4; i++) {
            int curRow = row + position[i][0];
            int curCol = col + position[i][1];
            if (curRow < 0 || curCol < 0 || curRow >= grid.length || curCol >= grid[0].length) continue;// 越界

            if (grid[curRow][curCol] == 1) ans += 1 + dfs(grid, curRow, curCol, mark);
        }
        return ans;
    }

}
