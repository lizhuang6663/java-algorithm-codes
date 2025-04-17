package 校队.校队题库_新;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P28接龙数列 {
    // 动态规划。时间超限：
    // 从中删除多少个数，可以使剩下的序列是接龙序列。把问题转换为：找到连续的、最长的接龙序列。然后n-这个序列的长度。
//    public static void main(String[] args) {
//        int n = nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = nextInt();
//        }
//
//        // dp[i] 表示以第 i 个数字为结尾的最长接龙子序列的长度。
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[j] % 10 == getFirstNum(arr[i])) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        System.out.println(n - res);
//    }

    // 哈希+贪心
    public static void main(String[] args) {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        // 存储以某个数结尾的最长接龙子序列的长度。
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num : arr) {
            int firstDigit = getFirstNum(num); // 当前数字的首位
            int lastDigit = num % 10; // 当前数字的末尾

            // 查找以当前数字首位 firstDigit 为尾数的最长接龙子序列长度，如果不存在则返回 0。curLength：当前数字可以接在这个序列后面，因此当前序列长度加 1。
            int curLength = map.getOrDefault(firstDigit, 0) + 1;

            // 更新以当前数字尾数结尾的最长序列长度
            // 当前数字的末尾 lastDigit 会作为新的接龙序列的尾数。
            // map.put(lastDigit, ...)：更新尾数 lastDigit 对应的最长接龙子序列长度，取已有长度和 curLength 中的最大值。
            map.put(lastDigit, Math.max(map.getOrDefault(lastDigit, 0), curLength));

            // 更新全局最长长度
            maxLength = Math.max(maxLength, curLength);
        }

        // 结果是总长度减去最长接龙序列长度
        System.out.println(n - maxLength);
    }


    // 找到一个数字的开头数字
    public static int getFirstNum(int a) {
        while (a >= 10) {
            a /= 10;
        }
        return a;
    }

    static OutputStream outputStream = System.out;
    static PrintWriter out = new PrintWriter(outputStream);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
    static StringTokenizer tokenizer = null;

    static String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    static String nextLine() {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static Double nextDouble() {
        return Double.parseDouble(next());
    }

    static BigInteger nextBigInteger() {
        return new BigInteger(next());
    }
}
