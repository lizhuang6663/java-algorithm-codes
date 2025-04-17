package 校队.校队题库.不太理解和做错的;

import java.util.*;


// 子序列字符串
public class P1005BOBGOOD {
    static long MOD = (long) 1e9 + 7;
    static int N = (int) 2e5 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solve(s);
    }


    public static void solve(String s) {
        long[] dp1 = new long[N];

        // 统计每个位置及其后面出现了多少次的 "!"
        for (int i = s.length() - 1; i >= 0; i--) {
            dp1[i] = dp1[i + 1];
            if (s.charAt(i) == '!') dp1[i]++;
        }

        long ans = 0;
        long[] dp2 = new long[7];
        //0:B   1:BO    2:BOB   3:BOBG    4:BOBGO   5:BOBGOO    6.BOBGOOD

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                dp2[0]++;
                dp2[0] %= MOD;
                dp2[2] += dp2[1];
                dp2[2] %= MOD;
            }
            if (s.charAt(i) == 'O') {
                dp2[1] += dp2[0];
                dp2[1] %= MOD;
                dp2[5] += dp2[4];
                dp2[5] %= MOD;
                dp2[4] += dp2[3];
                dp2[4] %= MOD;
            }
            if (s.charAt(i) == 'G') {
                dp2[3] += dp2[2];
                dp2[3] %= MOD;
            }
            if (s.charAt(i) == 'D') {
                dp2[6] += dp2[5];
                dp2[6] %= MOD;
                if (dp2[6] != 0) {
                    //  BOBGOOD的排列种类 * 感叹号的排列种类
                    // 使用Math.pow() 方法 或者 使用 (1 << dp1[i]) - 1 都不正确（不知道为什么，可能是数据变大就出现了错误）
                    ans = (ans + (dp2[5] * (ksm(2, dp1[i]) - 1) % MOD)) % MOD;
                }
            }
        }

        System.out.println(ans);
    }


    public static long ksm(long a, long b) {
        long result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b /= 2;

        }
        return result;
    }

}