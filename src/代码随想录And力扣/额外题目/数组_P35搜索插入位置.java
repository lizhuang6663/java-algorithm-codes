package 代码随想录And力扣.额外题目;

public class 数组_P35搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;

        // 二分
        int left = 0, right = nums.length - 1;
        int index = 0;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
                index = right;
            } else {
                left = mid + 1;
                index = left;
            }
        }

        return index+1;
    }

}
