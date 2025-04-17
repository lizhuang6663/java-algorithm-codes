package 代码随想录And力扣.动态规划;


// 动态规划
// 力扣：https://leetcode.cn/problems/fibonacci-number/description/

public class P509斐波那契数 {
    // 状态转移方程 dp[i] = dp[i - 1] + dp[i - 2];
    // 初始化：
    // dp[0] = 0;
    // dp[1] = 1;

//    public  int fib(int n) {
//        if (n == 0) return 0;
//        int [] dp = new int[n+1];
//
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//
//        System.out.println(dp[n]);
//        return dp[n];
//    }

    // 优化空间：
    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

}
