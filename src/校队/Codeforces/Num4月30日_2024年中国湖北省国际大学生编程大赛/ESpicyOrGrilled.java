package 校队.Codeforces.Num4月30日_2024年中国湖北省国际大学生编程大赛;

import java.io.*;

// 签到题

public class ESpicyOrGrilled {
    public static void main(String[] args) {
        int T = nextInt();
        for (int i = 0; i < T; i++) {
            long n = nextLong();
            long x = nextLong();
            long a = nextLong();
            long b = nextLong();
            out.println(x * b + (n-x)*a);
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
