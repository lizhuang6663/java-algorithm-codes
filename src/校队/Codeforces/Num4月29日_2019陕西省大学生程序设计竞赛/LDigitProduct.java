package 校队.Codeforces.Num4月29日_2019陕西省大学生程序设计竞赛;

import java.io.*;

// 签到题

public class LDigitProduct {
    static int MOD = (int) (1e9 + 7);
    public static void main(String[] args) {
        int T = nextInt();
        for (int i = 0; i < T; i++) {
            long l = nextLong();
            long r = nextLong();

            long result = 1;
            boolean flag = false;
            for (long j = l; j <= r; j++) {
                // 写的有点麻烦了，不用转换为字符串，直接用数字 /= 10 就可以了，如果存在0就为0
                String s = String.valueOf(j);
                if (s.contains("0")) {
                    flag = true;
                    break;
                }
                for (int k = 0; k < s.length(); k++) {
                    result = result * (s.charAt(k) - '0') % MOD;
                }
            }

            if (flag) {
                System.out.println(0);
            } else {
                System.out.println(result);
            }

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

