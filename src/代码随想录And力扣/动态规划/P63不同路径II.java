package 代码随想录And力扣.动态规划;

// 动态规划
// 力扣：https://leetcode.cn/problems/unique-paths-ii/description/

public class P63不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        // 初始化：如果(i, 0) 这条边有了障碍之后，障碍之后（包括障碍）都是走不到的位置了，所以障碍之后的dp[i][0]应该还是初始值0。
        // 注意：初始化的部分，很容易忽略了障碍之后应该都是0的情况。
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // (0, i) 同理
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 当(i, j)没有障碍的时候，再推导dp[i][j]，如果有障碍就是0，不推导
                if (obstacleGrid[i][j] == 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 空间优化：不理解
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int[] dp = new int[n];
//
//        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
//            dp[j] = 1;
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (obstacleGrid[i][j] == 1) {
//                    dp[j] = 0;
//                } else if (j != 0) {
//                    dp[j] += dp[j - 1];
//                }
//            }
//        }
//        return dp[n - 1];
//    }

}
