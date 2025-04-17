package 代码随想录And力扣.动态规划;

// 动态规划
// 力扣：https://leetcode.cn/problems/integer-break/description/

public class P343整数拆分 {
    // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
    // 递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j))
    // 可以想 dp[i]最大乘积是怎么得到的呢？
    // 其实可以从1遍历j，然后有两种渠道得到dp[i].一个是j * (i - j) 直接相乘。一个是j * dp[i - j]，相当于是拆分(i - j)，对这个拆分不理解的话，可以回想dp数组的定义。
    // 也可以这么理解，j * (i - j) 是单纯的把整数拆分为两个数相乘，而j * dp[i - j]是拆分成两个以及两个以上的个数相乘。
    // dp的初始化：dp[2] = 1
    // 确定遍历顺序：
    // dp[i] 是依靠 dp[i - j]的状态，所以遍历i一定是从前向后遍历，先有dp[i - j]再有dp[i]。

    // j的结束条件是 j < i - 1 ，其实 j < i 也是可以的，不过可以节省一步，例如让j = i - 1，的话，其实在 j = 1的时候，这一步就已经拆出来了，重复计算，所以 j < i - 1
    public int integerBreak(int n) {
        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) { // j:拆分出来的数，j的范围到 j<i，也没错，只是后面会重复计算，不过我们可以优化为j <= i - j,也可以 j <= i / 2
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j])); // 状态转移方程
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }


    // 方法二：贪心，每次拆成n个3，如果剩下是4，则保留4，然后相乘
//    public int integerBreak(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 1;
//        if (n == 3) return  2;
//        if (n == 4) return 4;
//        int result = 1;
//        while (n > 4) {
//            result *= 3;
//            n -= 3;
//        }
//        result *= n;
//        return result;
//    }

}
