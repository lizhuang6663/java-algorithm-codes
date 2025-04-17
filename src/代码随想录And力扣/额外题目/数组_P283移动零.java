package 代码随想录And力扣.额外题目;


// 数组
// 力扣：https://leetcode.cn/problems/move-zeroes/description/

// 相似题目：
// 27. 移除元素：https://leetcode.cn/problems/remove-element/description/

public class 数组_P283移动零 {
    public void moveZeroes(int[] nums) {
        int slowIndex = 0,  fastIndex= 0;

        // 把不为0的元素往前移
        for (fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        // 后面的元素归零
        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
