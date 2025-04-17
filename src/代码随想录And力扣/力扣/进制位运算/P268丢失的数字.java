package 代码随想录And力扣.力扣.进制位运算;

// 异或运算符
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/missing-number/description/
public class P268丢失的数字 {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= i;
        }

        result ^= nums.length;
        return result;
    }

}
