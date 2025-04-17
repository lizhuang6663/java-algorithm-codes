package 代码随想录And力扣.力扣.进制位运算;

// 位运算
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/reverse-bits/description/
public class P190颠倒二进制位 {

    // 时间复杂度：O(logn)
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32 && n != 0 ;i++) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;// java中没有无符号整数类型，因此对 n 的右移操作应使用逻辑右移。
        }

        return result;
    }

}
