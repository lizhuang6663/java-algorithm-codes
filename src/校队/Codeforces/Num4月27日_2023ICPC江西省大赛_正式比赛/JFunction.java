package 校队.Codeforces.Num4月27日_2023ICPC江西省大赛_正式比赛;

import java.io.*;

// 暴力
// Codeforces:https://codeforces.com/gym/104385/problem/J

// 操作一，添加一个新的二次函数。
// 操作二，问所有的二次函数里面，经过给定的 x，得到的 y的最小值是多少。

public class JFunction {
    public static void main(String[] args) {
        int n = nextInt();
        // 注意数据范围：1 <= a,b <= n，所以后面再添加a，b的时候，可以用数组，没有超出数组的范围
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = nextInt();
        }

        int m = nextInt();
        for (int i = 0; i < m; i++) {
            int select = nextInt();
            if (select == 0) {
                int a = nextInt();
                int b = nextInt();
                arr[a] = Math.min(arr[a], b);
            } else {
                int result = Integer.MAX_VALUE;
                int a = nextInt();
//                for (int j = 1; j < arr.length; j++) { // 时间超限，优化：
                for (int j = Math.max(1, a - 500); j <= Math.min(a + 100, n) ; j++) {
                    int temp = (a - j) * (a - j) + arr[j];
                    result = Math.min(result, temp);
                }
                out.println(result);
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
