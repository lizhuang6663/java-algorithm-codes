package 校队.Codeforces.Num4月27日_2023ICPC江西省大赛_正式比赛;

import java.io.*;

// 异或运算符（要用快读，快写）
// Codeforces:https://codeforces.com/gym/104385/problem/I

// 操作一，选定树上两个点 x,y，对 x 到 y 的路径上的边权，都异或 z
// 操作二，问树上的点 x 连接的两条边，异或和是多少。

public class ITree {
    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int q = nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int x = nextInt();
            int y = nextInt();
            int w = nextInt(); // x 到 y 的距离
            arr[x] ^= w;
            arr[y] ^= w;
        }

        for (int i = 0; i < q; i++) {
            int select = nextInt();

            if (select == 1) {
                int x = nextInt();
                int y = nextInt();
                int z = nextInt(); // 要异或的值

                arr[x] ^= z;
                arr[y] ^= z;
            } else {
                int x = nextInt();
                out.println(arr[x]); // 打印连接到 x 的所有边的值的位相 xor
            }
        }
        out.flush();
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
