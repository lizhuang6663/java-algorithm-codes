package 代码随想录And力扣.array_practice;

// 数组5:长度最小的子数组
// 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
// 力扣：https://leetcode.cn/problems/minimum-size-subarray-sum/description/

public class ArrayDemo5 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen2(7, nums));
    }



    // 方法一：暴力解法，一个for循环滑动窗口的起始位置，一个for循环为滑动窗口的终止位置，用两个for循环 完成了一个不断搜索区间的过程
    public static int minSubArrayLen1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int item = 0;

        for (int i = 0;i<nums.length;i++){//起始位置
            item = 0;
            for (int j = i;j<nums.length;j++){//终止位置
                item += nums[j];
                if (item >= target) {
                    int max = j - i + 1;
                    result = result > max ? max : result;
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }



    // 方法二：滑动窗口（类似于双指针）
    public static int minSubArrayLen2(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int item = 0;

        for (right = 0; right < nums.length; right++) {
            item += nums[right];

            while (item >= target){
                result = result > right - left + 1 ? right - left + 1 : result;
                item -= nums[left++];// 滑动窗口的精髓
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 方法三：前缀和 + 二分查找
    // 。。。

}
