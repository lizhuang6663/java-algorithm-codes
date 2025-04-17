package 代码随想录And力扣.动态规划;

// 动态规划
// 力扣：https://leetcode.cn/problems/unique-paths/description/

public class P62不同路径 {
    // 方法一：深搜
    // ...

    // 方法二：动态规划
    // 1.下标：dp[i][j]：到(i,j)有几种方法
    // 2.递推公式：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    // 3.初始化：首先dp[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理。
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 空间优化：
    // 由于 f(i,j) 仅与第 i 行和第 i−1 行的状态有关，因此我们可以使用滚动数组代替代码中的二维数组，使空间复杂度降低为 O(n)。（不理解）
//    public int uniquePaths(int m, int n) {
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) dp[i] = 1;
//
//        for (int j = 1; j < m; j++) {
//            for (int i = 1; i < n; i++) {
//                dp[i] += dp[i - 1];
//            }
//        }
//        return dp[n - 1];
//    }


    // 方法三：数论
    // 从左上角移动到右下角一定需要移动 m + n - 2次，向下要走m-1次，向右要走n-1次，组合问题（从 m+n-2 中挑出来 m-1个）
    // 求组合的时候，要防止两个int相乘溢出！ 所以不能把算式的分子都算出来，分母都算出来再做除法。
    // 错误代码：
//    public int uniquePaths(int m, int n) {
//        int numerator = 1, denominator = 1;
//        int count = m - 1;
//        int t = m + n - 2;
//        while (count-- > 0) numerator *= (t--); // 计算分子，此时分子就会溢出
//        for (int i = 1; i <= m - 1; i++) denominator *= i; // 计算分母
//        return numerator / denominator;
//    }

    // 正确代码：需要在计算分子的时候，不断除以分母
//    public int uniquePaths(int m, int n) {
//        long  numerator = 1; // 分子
//        int denominator = m - 1; // 分母
//        int count = m - 1;
//        int t = m + n - 2;
//        while (count-- > 0) {
//            numerator *= (t--);
//            while (denominator != 0 && numerator % denominator == 0) {
//                numerator /= denominator;
//                denominator--;
//            }
//        }
//        return (int) numerator;
//    }

}
