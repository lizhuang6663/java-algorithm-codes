package 校队.Codeforces.Num4月29日_2019陕西省大学生程序设计竞赛;

import java.io.*;

// 分类讨论
// Codeforces:https://codeforces.com/gym/104460/problem/F

public class FK_hourClock {
    // 分类讨论:
    // 1.如果 x+y=z，那任何 k>z 都可以.
    // 2.如果 y<=z，说明不能从 x 点到达 z 点.
    // 如果 x+y<=z+z，说明不能过一天后到达 z 点.
    // 3.其余情况直接输出 x+y-z 就好了，就当作只过了一天，或者还不到一天

    // 所以 x+y=z 或者 同时满足 y > z && x + y > z + z 才可以
    public static void main(String[] args) {
        int T = nextInt();
        for (int i = 0; i < T; i++) {
            long x = nextLong();
            long y = nextLong();
            long z = nextLong();

            // k 只要大于z就可以
            if (x + y == z) {
                System.out.println(z + 1);
                continue;
            }

            // 没有满足 y > z 的例子：0 1 3, 1 1 3, 3 1 3   （2 1 3 在 x + y == z 可以通过）
            // 没有满足 x + y > z + z 的例子：3 4 3, 3 3 3, 0 4 2
            if (y > z && x + y > z + z) {
                out.println(x + y - z);
            } else {
                out.println(-1);
            }
            out.flush();
        }
    }

    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    private static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static double nextDouble() {
        try {
            st.nextToken();
            return (double) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Long nextLong() {
        try {
            st.nextToken();
            return (long) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String next() {
        try {
            st.nextToken();
            return st.sval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

