package 校队.Codeforces.Num4月30日_2024年中国湖北省国际大学生编程大赛;

import java.io.*;

/*

    2024年中国湖北省国际大学生编程大赛：https://codeforces.com/gym/105139/
    题解：https://codeforces.com/gym/105139/attachments/download/25287/Sol_ICPC_hubei_24.pdf


 */


// 签到题
public class ALongLive {
    public static void main(String[] args) {
        int T = nextInt();
        for (int i = 0; i < T; i++) {
            long x = nextLong();
            long y = nextLong();

            // num:根号里面的数，num 一定是整数
            long num = icm(x, y) / gcd(x, y);
            out.println(1 + " " + num);
            out.flush();
        }
    }

    public static long icm(long x, long y) {
        return (x * y) / gcd(x, y);
    }

    public static long gcd(long x, long y) {
        if (y == 0) return x;
        return gcd(y, x % y);
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


