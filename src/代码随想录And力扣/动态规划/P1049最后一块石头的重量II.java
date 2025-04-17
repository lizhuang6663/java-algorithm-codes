package 代码随想录And力扣.动态规划;

// 动态规划
// 力扣：https://leetcode.cn/problems/last-stone-weight-ii/description/


public class P1049最后一块石头的重量II {

    // 方法一：一维
    // 最后dp[target]里是容量为target的背包所能背的最大重量。那么分成两堆石头，一堆石头的总重量是dp[target]，另一堆就是sum - dp[target]。
    // 在计算target的时候，target = sum / 2 因为是向下取整，所以sum - dp[target] 一定是大于等于dp[target]的。那么相撞之后剩下的最小石头重量就是 (sum - dp[target]) - dp[target]。

//    public int lastStoneWeightII(int[] stones) {
//        if (stones == null || stones.length == 0) return -1;
//        int n = stones.length;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += stones[i];
//        }
//
//        int target = sum / 2; // 向下取整
//        int dp[] = new int[target + 1];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = target; j >= stones[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
//            }
//        }
//
//        return sum - dp[target] - dp[target];
//    }


    // 方法二：二维
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) return -1;
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += stones[i];

        int target = sum/2;
        int dp [][] = new int[n][target+1];

        // 初始化
        for (int j = stones[0]; j <= target; j++) dp[0][j] = stones[0];
        //dp[i][0]默认初始化为0

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < stones[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]] + stones[i]);
            }
        }

        return sum - dp[n-1][target] - dp[n-1][target];
    }

}
