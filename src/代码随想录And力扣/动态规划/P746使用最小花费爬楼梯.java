package 代码随想录And力扣.动态规划;

// 动态规划
// 力扣：https://leetcode.cn/problems/min-cost-climbing-stairs/
public class P746使用最小花费爬楼梯 {

    // 方式一：第一步不支付费用
    // 注意：到达 第 0 个台阶是不花费的，但从 第0 个台阶 往上跳的话，需要花费 cost[0]，所以初始化：
    // dp[0] = 0;
    // dp[1] = 0;
    // dp[i]：到达第i层台阶花费的最少费用
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1]; // 注意dp的长度
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[dp.length - 1];
    }

    // 方式二：第一步支付费用
//    public int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length]; // 注意dp的长度
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for (int i = 2; i < cost.length; i++) {
//            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
//        }
//        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
//        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
//    }

    // 空间优化：（第一步不支付费用）
//    public int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        int prev = 0, curr = 0;
//        for (int i = 2; i <= n; i++) {
//            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
//            prev = curr;
//            curr = next;
//        }
//        return curr;
//    }

}
