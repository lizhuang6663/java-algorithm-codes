package 代码随想录And力扣.动态规划;


// 动态规划
// 力扣：https://leetcode.cn/problems/climbing-stairs/description/

public class P70爬楼梯 {
    // dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶就是dp[i]。
    // dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶就是dp[i]了。
    // 所以，递推公式是 dp[i] = dp[i - 1] + dp[i - 2]

    // 优化空间：
    public  int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1,  b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }
}
