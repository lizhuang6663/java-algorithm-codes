package 校队.Num7月19日_牛客周赛;

import java.io.*;

// 数学思维，倒着看（也可以看作：用位运算的思路，二进制上有多少个1，就需要加几次的1，有几位就是要*2几次，由于存在共同的一次，所以再减1就可以）
// 牛客：https://ac.nowcoder.com/acm/contest/86711/B

public class B数的操作 {
    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            long n = nextLong();
            long num = 0;

            while (n != 0) {
                if (n % 2 == 0) {
                    n/=2;
                }else {
                    n --;
                }
                num ++;
            }
            out.println(num);
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

