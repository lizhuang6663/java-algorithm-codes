package 代码随想录And力扣.贪心;

import java.util.Arrays;

// 贪心(两次贪心)
// 力扣：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/

public class P1005K次取反后最大化的数组和 {
    // 贪心（两次贪心）
    // 让数组和最大：局部最优：让绝对值大的负数变为正数，当前数值达到最大，整体最优：整个数组和达到最大。
    // 如果将负数都转变为正数了，K依然大于0。那么又是一个贪心：
    // 局部最优：只找数值最小的正整数进行反转，当前数值和可以达到最大（例如正整数数组{5, 3, 1}，反转1 得到-1 比 反转5得到的-5 大多了），全局最优：整个 数组和 达到最大。

    //第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
    //第二步：从前向后遍历，遇到负数将其变为正数，同时K--
    //第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
    //第四步：求和

    // 看起来像暴力，但是这是贪心的思想。
    // 如果没有贪心的思考方式（局部最优，全局最优），很容易陷入贪心简单题凭感觉做，贪心难题直接不会做，其实这样就锻炼不了贪心的思考方式了。
    //所以明知道是贪心简单题，也要靠贪心的思考方式来解题，这样对培养解题感觉很有帮助。

//    public int largestSumAfterKNegations(int[] nums, int K) {
//        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
//        nums = IntStream.of(nums)
//                .boxed()
//                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
//                .mapToInt(Integer::intValue).toArray();
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            //从前向后遍历，遇到负数将其变为正数，同时K--
//            if (nums[i] < 0 && K > 0) {
//                nums[i] = -nums[i];
//                K--;
//            }
//        }
//        // 如果K还大于0，那么反复转变数值最小的元素，将K用完
//
//        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
//        return Arrays.stream(nums).sum();
//    }


    // 或者：更好理解
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // 还不够k个
        if (k > 0) {
            Arrays.sort(nums);
            if (k % 2 == 1) {
                nums[0] = -nums[0];
            }
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }


}
