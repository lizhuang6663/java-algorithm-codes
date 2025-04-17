package 校队.Codeforces.Num4月30日_2024年中国湖北省国际大学生编程大赛;

import java.io.*;

// 分数取模，费马小定理
// Codeforces:https://codeforces.com/gym/105139/problem/J

public class JPointsOnTheNumberAxisA {
    // 对分数a/b进行模p运算，就等价于将分子a乘以分母b在模p下的逆元 b^(-1)。
    // a / b mod p = a * b(^-1) mod p， b^(-1) 表示b在模p下的逆元。
    // 费马小定理陈述如下：
    // 如果p是一个质数，a是不可被p整除的整数，那么：
    // a^(p-1) mod p = 1，这意味着 a^(p-1) 在模p下等于1。因此，如果我们将 a^(p-2) 乘以 a，得到a^(p-1)，即 a^(p-2) * a mod p = 1
    // 根据同余的性质，如果 a^(p-2) * a mod p = 1，那么 a^(p-2) 就是a在模p下的逆元。因此，我们可以得出结论：a^(p-2) 是a在模p下的逆元。
    // 同理 b^(p-2) * b mod p = 1，所以 1/b = b^(p-2) mod p
    // 所以: a / b % p = a * b^(p-2) % p
    // 主要计算 b^(p-2)(mod p)，可用快速幂计算
    static long MOD = 998244353;

    public static void main(String[] args) {
        out.println(fractionMod(4, 2 ,10000));
        out.println(4/2 % 10000);

        int n = nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nextLong();
        }

        out.println(fractionMod(sum, n, MOD));
        out.flush();
    }

    // a/b%p = a*b^(p-2)%p
    public static long fractionMod(long a, long b, long p) {
        return ((a % p) * ksm(b, p - 2, p)) % p;
    }

    // a 底数， k 指数， 求 a^k mod p
    public static long ksm(long a, long k, long p) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) == 1) res = res * a % p;
            a = a * a % p;
            k >>= 1;
        }
        return res;
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
