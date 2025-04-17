package 校队.Codeforces.Num4月26日_第十届山东省ACM省赛;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 中位数，Floyd算法
// Codeforces:https://codeforces.com/gym/104459/problem/L

public class LMedian {
    // 定义两个二维数组 matrix[i][j] 和 num[2][n]
    // 其中 matrix[i][j] = 1 时代表第i个数严格大于第j个数，num[0][n] 代表比n小的数的个数，num[1][n] 代表比n大的数的个数。
    // 跑一遍floyd，对于每一个通路，都可以认为它的起点严格大于终点，即给matrix[start][end]赋值为1。
    // 考虑一下不可能存在的情况（如样例2的第一个数严格大于自身），即图中出现自环。
    // 再对matrix进行遍历，更新num数组。
    // 最后按要求输出即可。
    static int[][] matrix;
    static int[][] num;
    static int n;
    static boolean flag;

    public static void main(String[] args) {
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }

        out.flush();
    }

    public static void solve() {
        n = nextInt();
        int m = nextInt();

        // 初始化
        matrix = new int[n + 1][n + 1];
        num = new int[2][n + 1];
        flag = true;

        // 矩阵预处理
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            matrix[a][b] = 1;
        }

        floyd();

        // 没有自环
        if (flag) {
            for (int i = 1; i <= n; i++) {
                // 输出，当一个数比它大的数的个数 和 比它小的数的个数 都小于等于n/2时，可视该项为中间项
                if (num[0][i] <= n / 2 && num[1][i] <= n / 2) out.print(1);
                else out.print(0);
            }

        } else {
            for (int i = 0; i < n; i++) {
                out.print(0);
            }
        }
        out.println();
    }


    // floyd算法
    public static void floyd() {
        // floyd
        // 作用应该是：比如 3 > 2, 2 > 1 但是我们不知道3和1之间的关系，用三个for循环可以得到3>1
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) matrix[i][j] = 1;

        // 判断是否有自环
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == 1 && matrix[j][i] == 1) {
                    flag = false;
                    return;
                }
            }
        }

        // 维护更新num数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == 1) {
                    num[0][i]++;
                    num[1][j]++;
                }
            }
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


