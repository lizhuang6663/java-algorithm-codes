package 青训营.豆包;

// 动态规划
public class 数字翻译成字符串的可能性 {
    public static int solution(int num) {
        // 其中 dp[i] 表示从第 i 位数字到最后一位数字的翻译方式数量。我们的目标是计算 dp[0]。
        String s = String.valueOf(num);
        int n = s.length();
        if (n == 0) return 0;

        // dp[i] 表示从第 i 位到最后一位的翻译方法数
        int[] dp = new int[n + 1];
        dp[n] = 1; // 空字符串只有一种翻译方式

        // 从最后一个字符开始往前遍历，这样更容易处理两个字符的组合情况。
        for (int i = n - 1; i >= 0; i--) {
            // 单个字符的情况：只有一种情况，就是dp[i + 1]
            dp[i] = dp[i + 1];

            // 两个字符的情况
            if (i < n - 1) {
                int twoDigit = Integer.parseInt(s.substring(i, i + 2));
                if (twoDigit >= 10 && twoDigit <= 25) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(12258) == 5);  // 输出 5
        System.out.println(solution(1400112) == 6); // 输出 6
        System.out.println(solution(2110101) == 10); // 输出 10
        System.out.println(solution(25) == 2); // 输出 2
        System.out.println(solution(1023) == 4); // 输出 4
    }
}
