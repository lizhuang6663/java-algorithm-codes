package 代码随想录And力扣.额外题目;


// 数组
// 力扣：https://leetcode.cn/problems/find-pivot-index/

public class 数组_P724寻找数组的中心下标 {
    // 方法：
    // 遍历一遍求出总和sum
    // 遍历第二遍求中心索引左半和leftSum：同时根据sum和leftSum 计算中心索引右半和rightSum；判断leftSum和rightSum是否相同

    // 注意数组：[2,1,-1] 的中心下标为0
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 总和
        }

        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum + nums[i]; // leftSum 里面已经有 nums[i]，多减了一次，所以加上
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1; // 不存在
    }

}
