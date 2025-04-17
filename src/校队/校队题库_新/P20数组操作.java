package 校队.校队题库_新;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 差分数组
// 校队题库：http://154.37.212.21/p/P20

public class P20数组操作 {
    public static void main(String[] args) {
        // 读取数组长度 n 和操作次数 q
        int n = nextInt();
        int q = nextInt();
        long[] arr = new long[n + 10];
        for (int i = 1; i <= n; i++) {
            arr[i] = nextLong();
        }

        long[] diff = new long[n + 10];// 差分数组
        long[] inc = new long[n + 10]; // 增量数组
        for (int i = 1; i <= q; i++) {
            int l = nextInt();
            int r = nextInt();
            long x = nextLong();

            // 更新差分数组
            diff[l] += x;
            // 在 r + 1 位置减去 x + (r - l) 的目的是抵消之前在 [l, r] 区间内累积的线性增量。具体而言：
            // x 是在 l 位置开始的固定增量；
            // (r - l) 是 [l, r] 区间内多出来的线性递增量。
            diff[r + 1] -= x + (r - l); // 在 r+1 位置减去 x + (r - l)，使区间 [l, r] 的递增作用在 r+1 后停止。
            inc[l + 1] += 1; // 从 l+1 位置开始，每步加 1
            inc[r + 1] -= 1;  // 在 r+1 之后，取消之前的步进增量
        }

        // 根据差分数组和增量数组计算最终结果
        for (int i = 1; i <= n; i++) {
            inc[i] += inc[i - 1];
            diff[i] += diff[i - 1] + inc[i];
            arr[i] += diff[i];

            System.out.print(arr[i] + " ");
        }
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
