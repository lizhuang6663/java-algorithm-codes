package 代码随想录And力扣.额外题目;


// 数组
// 力扣：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/

public class 数组_P34在排序数组中查找元素的第一个和最后一个位置 {
    // 方法一：模拟
//    public int[] searchRange(int[] nums, int target) {
//        int[] arr = new int[]{-1, -1};
//
//        for (int i = 0; i < nums.length ; i++) {
//            if ((i == 0 && nums[i] == target) || (i >= 1 && nums[i - 1] != target && nums[i] == target)) {
//                arr[0] = i;
//            }
//
//            if ((i == nums.length - 1 && nums[i] == target) || (i <= nums.length - 2 && nums[i] == target && nums[i+1] != target)) {
//                arr[1] = i;
//            }
//        }
//        return arr;
//    }

    // 方法二：二分法
    // 寻找target在数组里的左右边界，有如下三种情况：
    //情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
    //情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
    //情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
    int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    // 方法三：先二分，然后向左右滑动找到边界
    // 1、首先，在 nums 数组中二分查找 target；
    // 2、如果二分查找失败，则 binarySearch 返回 -1，表明 nums 中没有 target。此时，searchRange 直接返回 {-1, -1}；
    // 3、如果二分查找成功，则 binarySearch 返回 nums 中值为 target 的一个下标。然后，通过左右滑动指针，来找到符合题意的区间
//    public int[] searchRange(int[] nums, int target) {
//        int index = binarySearch(nums, target); // 二分查找
//        // nums 中不存在 target，直接返回 {-1, -1}
//        if (index == -1)  return new int[]{-1, -1};
//
//        // nums 中存在 target，则左右滑动指针，来找到符合题意的区间
//        int left = index;
//        int right = index;
//
//        // 向左滑动，找左边界
//        while (left - 1 >= 0 && nums[left - 1] == nums[index]) { // 防止数组越界。逻辑短路，两个条件顺序不能换
//            left--;
//        }
//        // 向右滑动，找右边界
//        while (right + 1 < nums.length && nums[right + 1] == nums[index]) { // 防止数组越界。
//            right++;
//        }
//
//        return new int[]{left, right};
//    }
//
//    // 二分查找
//    public int binarySearch(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1; // 不变量：左闭右闭区间
//
//        while (left <= right) { // 不变量：左闭右闭区间
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1; // 不变量：左闭右闭区间
//            }
//        }
//        return -1; // 不存在
//    }



    // 或者二分法

    /*

func searchRange(nums []int, target int) []int {
	result := []int{-1, -1}

	result[0] = findLeftIndex(nums, target)
	result[1] = findRightIndex(nums, target)

	return result
}

func findLeftIndex(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	result := -1

	for left <= right {
		mid := left + (right-left)/2

		if nums[mid] == target {
			result = mid
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return result
}

func findRightIndex(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	result := -1

	for left <= right {
		mid := left + (right-left)/2

		if nums[mid] == target {
			result = mid
			left = mid + 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return result
}

     */

}
