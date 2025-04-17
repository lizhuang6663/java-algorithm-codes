package 校队.Codeforces.Num5月4日_CodeforcesRound756_Div3;

import java.io.*;

// 思维
// Codeforces：https://codeforces.com/contest/1611/problem/B

public class B_TeamComposition {
    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int a = nextInt();
            int b = nextInt();

            out.println(Math.min((a + b) / 4 , Math.min(a, b)));
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
