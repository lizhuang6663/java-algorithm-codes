package 代码随想录And力扣.贪心;


// 贪心，动态规划
// 力扣：https://leetcode.cn/problems/maximum-subarray/description/

//贪心贪的是哪里呢？
//如果 -2 1 在一起，计算起点的时候，一定是从 1 开始计算，因为负数只会拉低总和，这就是贪心贪的地方！
//局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
//全局最优：选取最大“连续和”
//局部最优的情况下，并记录最大的“连续和”，可以推出全局最优。

//从代码角度上来讲：遍历 nums，从头开始用 count 累积，如果 count 一旦加上 nums[i]变为负数，那么就应该从 nums[i+1]开始从 0 累积 count 了，因为已经变为负数的 count，只会拖累总和。
//这相当于是暴力解法中的不断调整最大子序和区间的起始位置。
//那有同学问了，区间终止位置不用调整么？ 如何才能得到最大“连续和”呢？
//区间的终止位置，其实就是如果 count 取到最大值了，及时记录下来了。例如如下代码：if (count > result) result = count;
//这样相当于是用 result 记录最大子序和区间和（变相的算是调整了终止位置）。

public class P53最大子数组和 {

    //方法一：暴力，时间超限
//    public int maxSubArray(int[] nums) {
//        int result = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//            int count  = 0;
//            for (int j = i; j < nums.length; j++) {
//                count += nums[j];
//                result = Math.max(result, count);
//            }
//        }
//        return result;
//    }


    //方法二：贪心
    // 贪心的思路为局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。从而推出全局最优：选取最大“连续和”
    //重点：不能让“连续和”为负数的时候加上下一个元素，而不是 不让“连续和”加上一个负数
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 1){
//            return nums[0];
//        }
//
//        int sum = Integer.MIN_VALUE;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++){
//            count += nums[i];
//            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
//
//            //如果和小于0，就重置 累加和
//            if (count < 0) count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
//        }
//        return sum;
//    }


    //方法三：动态规划
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            // 或者：
//            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 或者：
//    public int maxSubArray(int[] nums) {
//        int ans = Integer.MIN_VALUE;
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        ans = dp[0];
//
//        for (int i = 1; i < nums.length; i++){
//            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
//            ans = Math.max(dp[i], ans);
//        }
//
//        return ans;
//    }


    // 空间优化：
//    public int maxSubArray(int[] nums) {
//        int temp = 0, result = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            temp = Math.max(temp + nums[i], nums[i]);
//            result = Math.max(result, temp);
//        }
//
//        return result;
//    }

}
