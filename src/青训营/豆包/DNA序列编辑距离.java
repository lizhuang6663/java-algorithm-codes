package 青训营.豆包;

// 动态规划
public class DNA序列编辑距离 {
    public static int solution(String dna1, String dna2) {
        int m = dna1.length();
        int n = dna2.length();

        // dp[i][j] 表示将 dna1 的前 i 个字符转换成 dna2 的前 j 个字符所需的最少编辑操作数。最后得到的结果为 dp[m][n]，其中 m 和 n 分别是 dna1 和 dna2 的长度。
        int[][] dp = new int[m + 1][n + 1];

        // 行初始化：将 dna1 的前 i 个字符转换成空字符串，显然需要 i 次删除操作，因此 dp[i][0] = i。
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // 列初始化：将空字符串转换成 dna2 的前 j 个字符，需要 j 次插入操作，因此 dp[0][j] = j。
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 动态规划计算编辑距离
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 字符相同，不需要额外步骤
                if (dna1.charAt(i - 1) == dna2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // 字符不同：取删除、插入、替换操作中最小的+1
                    // dp[i - 1][j - 1] + 1 表示进行替换操作；
                    // dp[i - 1][j] + 1 表示对 dna1 删除一个字符；
                    // dp[i][j - 1] + 1 表示对 dna1 插入一个字符；
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    // 删除字符的逻辑：将 dna1 的第 i 个字符删除掉，剩下的是 dna1 的前 i-1 个字符。这样操作后，新的问题变成了将 dna1 的前 i-1 个字符转换成 dna2 的前 j 个字符的最小编辑距离。
                    // 插入字符的逻辑：在 dna1 中插入一个字符，使得 dna1[i] 对应 dna2[j]。插入操作让 dna1 的前 i 个字符不变，但变成了要和 dna2 的前 j-1 个字符进行匹配。
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution("AGCTTAGC", "AGCTAGCT") == 2);
        System.out.println(solution("AGCCGAGC", "GCTAGCT") == 4);
    }
}

