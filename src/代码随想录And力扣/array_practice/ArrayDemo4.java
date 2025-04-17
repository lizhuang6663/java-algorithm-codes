package 代码随想录And力扣.array_practice;

import java.util.Arrays;

//数组4:有序数组的平方
//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
public class ArrayDemo4 {

    //方法一：暴力解法
    public int[] sortedSquares1(int[] nums) {
        int[] target;
        for (int i = 0;i<nums.length;i++){
            nums[i] = nums[i] * nums[i] ;
        }
        Arrays.sort(nums);

        //或：
//        for(int i = 0;i<nums.length;i++){
//            for (int j = nums.length-1;j>i;j--){
//                int item ;
//                if (nums[i] > nums[j]) {
//                    item = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = item;
//                }
//            }
//        }

        return nums;
    }


    //方法二：双指针法:数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
    //如果A[i] * Num19[i] < Num19[j] * Num19[j] 那么result[k--] = Num19[j] * Num19[j]; 。
    //如果A[i] * Num19[i] >= Num19[j] * Num19[j] 那么result[k--] = Num19[i] * Num19[i]; 。
    public int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length-1;
        int left = 0,right = nums.length-1;

        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[index] = nums[right] * nums[right--];
//                right--;
            } else {
                result[index] = nums[left] * nums[left++];
//                left++;
            }
            index--;

            //或
//            if (nums[left] * nums[left] < nums[right] * nums[right]) {
//                result[index--] = nums[right] * nums[right--];
//            } else {
//                result[index--] = nums[left] * nums[left++];
//            }

        }
        return result;
    }


}
