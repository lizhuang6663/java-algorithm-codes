package 洛谷.六期.第二周练习;

import java.util.Scanner;

// 前缀和，合并同类项
// 洛谷，蓝桥杯：https://www.luogu.com.cn/problem/P8772?contestId=162817

public class P8772求和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 前缀和
        int[] prefix = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }


        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) arr[i] * (prefix[n] - prefix[i + 1]);
        }

        System.out.println(result);

    }
}
