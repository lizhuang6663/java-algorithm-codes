package 校队.校队题库.不太理解和做错的;

import java.util.Scanner;

// 快速幂
// 为什么这道题的结果是求快速幂
public class P1014Bingbong的幸运排列 {
    public static int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            System.out.println((1 << (temp - 1)) % MOD - 1);
            System.out.println(ksm(2L, temp - 1) - 1);
        }
    }

    // 快速幂
    public static long ksm(long a, long b) {
        long result = 1;

        while (b > 0) {
            // 说明是奇数
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }

}
