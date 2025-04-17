package 代码随想录And力扣.贪心;

// 贪心，动态规划
// 力扣：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/

public class P122买卖股票的最佳时机II {

    // 方法一：暴力dfs（超时）
//    int res;
//    public int maxProfit(int[] prices) {
//        if (prices.length < 2) return 0;
//        res = 0;
//        dfs(prices, 0, 0, res);
//        return this.res;
//    }
//
//    /**
//     * @param prices 股价数组
//     * @param index  当前是第几天，从 0 开始
//     * @param status 0 表示不持有股票，1表示持有股票，
//     * @param profit 当前收益
//     */
//    private void dfs(int[] prices, int index, int status, int profit) {
//        if (index == prices.length) {
//            res = Math.max(res, profit);
//            return;
//        }
//
//        // 三种情况：
//        // 1.啥也不干
//        dfs(prices, index + 1, status, profit);
//
//        if (status == 0) {
//            // 2.可以尝试转向 1
//            dfs(prices, index + 1, 1, profit - prices[index]);
//
//        } else {
//            // 3.此时 status == 1，可以尝试转向 0
//            dfs(prices, index + 1, 0, profit + prices[index]);
//        }
//    }



    //方法二：贪心
    // 局部最优：收集每天的正利润，全局最优：求得最大利润。
    //最终利润是可以分解的，那如何分解呢？
    //假如第 0 天买入，第 3 天卖出，那么利润为：prices[3] - prices[0]。相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
    //此时就是把利润分解为每天为单位的维度，而不是从 0 天到第 3 天整体去考虑！
//    public int maxProfit(int[] prices) {
//        int result = 0;
//        for (int i = 1; i < prices.length; i++) {
//            result += Math.max(prices[i] - prices[i - 1], 0);
//        }
//        return result;
//    }



    // 方法三：动态规范
    // 题解：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solutions/38498/tan-xin-suan-fa-by-liweiwei1419-2/
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        // 0代表没有股票，1代表有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0]; // 买股票，钱是负的

        for (int i = 1; i < prices.length; i++) {
            // 这两行调换顺序也是可以的
            // 两种：上一把没有买股票；把上一把的股票卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 两种：上一把没有买股票，这一把买股票；上一把买了股票，这把啥也不干（一次只能买一股股票）
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[dp.length - 1][0];
    }


    // 空间优化：
//    public int maxProfit(int[] prices) {
//        int len = prices.length;
//        if (len < 2) {
//            return 0;
//        }
//
//        // cash：持有现金
//        // hold：持有股票
//        // 状态数组
//        // 状态转移：cash → hold → cash → hold → cash → hold → cash
//        int[] cash = new int[len];
//        int[] hold = new int[len];
//
//        cash[0] = 0;
//        hold[0] = -prices[0];
//
//        for (int i = 1; i < len; i++) {
//            // 这两行调换顺序也是可以的
//            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
//            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
//        }
//        return cash[len - 1];
//    }
//
//
//    // 再次优化：
//    public int maxProfit(int[] prices) {
//        int len = prices.length;
//        if (len < 2) {
//            return 0;
//        }
//
//        // cash：持有现金
//        // hold：持有股票
//        // 状态转移：cash → hold → cash → hold → cash → hold → cash
//
//        int cash = 0;
//        int hold = -prices[0];
//
//        int preCash = cash;
//        int preHold = hold;
//        for (int i = 1; i < len; i++) {
//            cash = Math.max(preCash, preHold + prices[i]);
//            hold = Math.max(preHold, preCash - prices[i]);
//
//            preCash = cash;
//            preHold = hold;
//        }
//        return cash;
//    }

}
