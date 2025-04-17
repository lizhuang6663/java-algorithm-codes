package 校队.Codeforces.Num4月29日_2019陕西省大学生程序设计竞赛;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 做法：用减法减去重复的，而不是用加法一个个加
// Codeforces:https://codeforces.com/gym/104460/problem/C

public class C0689 {
    // 首先总共有 (n+1)*n/2 个子串；
    // 其次,只要它包含了 0,8,69,这样的就一定能够变回原来的字符串,所以我们可以再+1,所以最开始答案为:(n+1)*n/2+1种.
    // 特殊情况：全部是6 或者 全部是9
    // 如果原字符串里都是 6 ，那么翻转任何一个区间都会把 6变成9，，不可能得到原字符串。原字符串都是9的情况同理，所以 全部是6 或者 全部是9 不用额外+1。
    // 例子： 0689 -> 选择 0 翻转为 0689；选择 8 翻转为 0689。
    // 但如果全为6或者9就不行了，如 6666 -> 选择第一个6 翻转为 9666，不能再选择第一个6了，因为已经选过第一个6了，所以变不回去


    // 去重：
    // 如果一个子串为0890，翻转"0890"和翻转"89"是一样的，因为他两边都是0，没有影响，同理，两边都为8也是这种的情况，要去重。
    // 下面的代码中 ans -= (a + 1) * a / 2 和 ans -= (c + 1) * c / 2 去重（总情况-两边为0或者8的情况）
    // 和去除 两端为0或者8 的原理一样，两边为6和9也是重复的。翻转"60899"和翻转"089"一样，去重：ans -= b * d（一个6和一个9组合的情况有b*d种）

    public static void main(String[] args) {
        int T = nextInt();
        for (int i = 0; i < T; i++) {
            String s = next();

            long n = s.length();
            long a = 0, b = 0, c = 0, d = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '0') {
                    a++;
                } else if (s.charAt(j) == '6') {
                    b++;
                } else if (s.charAt(j) == '8') {
                    c++;
                } else if (s.charAt(j) == '9') {
                    d++;
                }
            }

            long ans = (n + 1) * n / 2; // 总情况
            if (b != n && d != n) {
                ans++;
            }
            // 去重
            ans -= (a + 1) * a / 2;
            ans -= (c + 1) * c / 2;
            ans -= b * d;
            out.println(ans);
        }
        out.flush();
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

/*

#include <bits/stdc++.h>

const int N = 1e6 + 10;

std::string s;

int cnt[20];
void solve() {
    std::cin >> s;
    memset(cnt, 0, sizeof(cnt));

    long long ans = 0;
    unsigned int len = s.size();
    for (unsigned int i = 0; i < s.size(); i ++ ) {
        if (s[i] != '0') ans += cnt[0];
        if (s[i] != '6') ans += cnt[9];
        if (s[i] != '8') ans += cnt[8];
        if (s[i] != '9') ans += cnt[6];
        if (s[i] == '6') ans ++;
        if (s[i] == '9') ans ++;
        cnt[s[i] - '0'] ++;
    }
    if (cnt[6] != len && cnt[9] != len) ans ++;
    std::cout << ans << '\n';
}
int P24多路归并Ⅱ() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    int T;
    std::cin >> T;
    while (T --) {
        solve();
    }
    return 0;
}



 */