package 校队.校队题库.不太理解和做错的;

import java.util.Scanner;


// gcd：最大公因数
// 时间超限
public class P1031GCD计划 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (judge(gcd(i, j))) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    // 最大公因数
    public static int gcd(int n1, int n2) {
        for (int i = Math.min(n1, n2); i > 0; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }

        return -1;
    }

    // 判读是否是素数
    public static boolean judge(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

