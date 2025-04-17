package 代码随想录And力扣.动态规划;

// 动态规划
// 力扣：https://leetcode.cn/problems/partition-equal-subset-sum/description/

public class P416分割等和子集 {
    // 方法一：二维（没通过）
//    public boolean canPartition(int[] nums) {
//        if (nums == null || nums.length == 0) return false;
//
//        int n = nums.length;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//        }
//
//        if ((sum & 1) == 1) return false;
//
//        int dp[][] = new int[n][sum / 2 + 1];
//
//        // 初始化
//        for (int j = nums[0]; j < sum / 2 + 1; j++) {
//            dp[0][j] = nums[0];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < dp.length; j++) {
//                // 放不下
//                if (nums[i] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
//                }
//            }
//        }
//
//        return dp[n-1][sum/2]  == sum/2;
//    }


    // 方法二：一维
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if ((sum & 1) == 1) return false;

        int dp[] = new int[sum / 2 + 1];

        for (int i = 0; i < len; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum / 2] == sum / 2;
    }

}
