package 代码随想录And力扣.力扣.进制位运算;


// 位运算
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/counting-bits/description/
public class P338比特位计数 {
    // 时间复杂度：O(n*logn)
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            // 统计1的个数
            int count = 0;
            int temp = i;
            while (temp != 0) {
                temp &= (temp - 1);
                count++;
            }

            result[i] = count;
        }

        return result;
    }


    // 代码优化
    // 动态规划...（暂时还没有学习动态规划）



}
