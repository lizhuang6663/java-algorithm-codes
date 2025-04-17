package 洛谷.蓝桥杯.数学思维;

import java.util.Scanner;

// 凑平方：数学思维（这种题不要硬凑平方）
// 把数字进行质因数分解，把奇数次方的质数求乘积就是答案

public class P8754完全平方数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long result = 1;
        // 减小时间，Math.sqrt(n)：否则时间超限
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int ans = 0;
            while (n % i == 0) {
                ans++;
                n /= i;
            }

            // 如果是奇数
            if ((ans & 1) == 1) { // ans % 2 != 0
                result *= i;
            }

        }

        if (n != 0 && n != 1) {
            result *= n;
        }
        System.out.println(result);

    }
}
