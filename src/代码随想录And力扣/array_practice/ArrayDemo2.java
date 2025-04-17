package 代码随想录And力扣.array_practice;

//数组2:二分查找
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
public class ArrayDemo2 {

    //方法一：暴力解决
    public int search1(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length-1] < target) return -1;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == target) return i;
        }
        return -1;
    }

    //方法二：二分查找
    public int search2(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length-1] < target) return -1;

        int left = 0, right = nums.length-1;
        while (left <= right){
            int middle = (right + left)/2;
//            int middle = left + ((right-left)>>1);
            // 推荐使用无符号右移： int middle = (left + right) >>> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            }else if (nums[middle] > target) {
                right = middle - 1;
            }else if (nums[middle] == target){
                return middle;
            }
        }
        return -1;
    }

    //方法三：二分查找(左闭右开)
    public int search3(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length-1] < target) return -1;

        int left = 0, right = nums.length;
        while (left < right){ // 左闭右开，如果这里是 <= 的话，如果我们查找不存在的元素，会陷入死循环
            int middle = left + ((right-left)>>1);

            if (nums[middle] == target){
                return middle;
            }else if (nums[middle] > target) {
                right = middle ;
            }else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return -1;
    }




}
