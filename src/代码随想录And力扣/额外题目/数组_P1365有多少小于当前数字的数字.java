package 代码随想录And力扣.额外题目;

import java.util.*;

// 数组
// 力扣：https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/description/

public class 数组_P1365有多少小于当前数字的数字 {
    // 方法一：暴力
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int [] arr = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int res = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] < nums[i]) res++;
//            }
//            arr[i] = res;
//        }
//        return arr;
//    }

    // 方法二：使用map
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            arr[i] = map.get(nums[i]);
        }

        return arr;
    }

}
