package 校队.Num4月28日_牛客小白月赛92;

import java.util.Scanner;

// 分解一元二次方程，求和
// 把一元二次方程分解开
// 牛客：https://ac.nowcoder.com/acm/contest/81126/D

public class D探索的时光 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n + 1];
        long A = 0, B = 0, C = 0;

        for (int i = 1; i < n + 1; i++) {
            arr[i] = scanner.nextLong();
            // 求出一元二次方程的三个系数
            A += arr[i];
            B += (long) i * arr[i];
            C += (long)i * (long)i * arr[i];
        }

        long result = Long.MAX_VALUE;
        // 遍历找出最合适的x
        for (int i = 1; i <= n; i++) {
            long res = (long) i * (long) i * A -  2L * (long) i * B + C;
            result = Math.min(result, res);
        }
        System.out.println(result);
    }
}
