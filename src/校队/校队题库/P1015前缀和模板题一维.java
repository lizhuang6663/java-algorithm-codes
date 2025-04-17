package 校队.校队题库;

import java.util.Scanner;

// 一维前缀和
public class P1015前缀和模板题一维 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // 下标从1开始
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = scanner.nextInt();
        }

        // 前缀和
        long[] result = new long[n+1];
        for (int i = 1; i < n+1; i++) {
            result[i] = result[i-1] + arr[i];
        }

        for (int i = 1; i <= q; i++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            System.out.println(result[R]- result[L-1]);
        }

    }
}
