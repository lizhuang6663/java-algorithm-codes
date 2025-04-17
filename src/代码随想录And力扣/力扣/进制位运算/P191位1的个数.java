package 代码随想录And力扣.力扣.进制位运算;

// 位运算
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/number-of-1-bits/description/
public class P191位1的个数 {
    public static void main(String[] args) {
        System.out.println(1 << 2); // 4（二进制为：100）
        System.out.println(4 & 8); // 0 （二进制运算：100 & 1000）
    }

    // 循环检查二进制位
    // 一共要循环32次
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            // n = 00000000000000000000000000001011
            // 1 << i：对数字1左移动，如1 << 2 结果是 100
            // 然后和 n 进行位运算符比较，i的值不断的增长，先比较个位，下一轮比较十位，再比较百位...
            // i == 0 的时候比较个位，如果结果 != 0 说明n的个位上是1，count++
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }


    // 代码可以优化：
    // 每次运算完之后，把 n 的二进制位中的最低位的 1 变为 0，循环就可能不需要一定循环32次了
    public int hammingWeight2(int n) {
        int count = 0;

        while (n != 0) {
            n &= n-1;
            count++;
        }

        return count;
    }
}
