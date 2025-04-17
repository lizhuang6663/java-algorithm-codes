package 代码随想录And力扣.额外题目;


// 数组
// 力扣：https://leetcode.cn/problems/valid-mountain-array/

public class 数组_P941有效的山脉数组 {
    // 用双指针left，right，保证左边到中间，和右边到中间是递增的。left 和 right 最后会在中间重合。
    public boolean validMountainArray(int[] arr) {
        if (arr.length <= 2) return false;

        int left = 0, right = arr.length - 1;
        while (left < arr.length - 1 && arr[left + 1] > arr[left])
            left++;

        while (right > 0 && arr[right - 1] > arr[right])
            right--;

        // 特殊情况处理：整个数组都是递增或者递减
        if (left == arr.length - 1 || left == 0) return false;

        return left == right;
    }

}
