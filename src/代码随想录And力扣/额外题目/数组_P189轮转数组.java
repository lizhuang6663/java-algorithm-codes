package 代码随想录And力扣.额外题目;


// 数组翻转
// 力扣：https://leetcode.cn/problems/rotate-array/description/

public class 数组_P189轮转数组 {
    // 方法一：暴力，借用了一个数组
//    public void rotate(int[] nums, int k) {
//        k = k%nums.length;
//
//        // 临时保存元素
//        int [] temp = new int[nums.length-k];
//        for (int i = 0; i < nums.length-k; i++) {
//            temp[i] = nums[i];
//        }
//
//        // 将后面的k个元素移动到前面
//        int index = 0;
//        for (int i = nums.length-k; i < nums.length; i++) {
//            nums[index++] = nums[i];
//        }
//
//        // 将 nums.length-k 个元素移动到后面
//        index = 0;
//        for (int i = k; i < nums.length; i++) {
//            nums[i] = temp[index++];
//        }
//    }


    // 方法二：反转
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

}
