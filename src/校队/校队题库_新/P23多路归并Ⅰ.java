package 校队.校队题库_新;

import java.util.Scanner;

// 签到
// 校队题库：http://154.37.212.21/p/P23

public class P23多路归并Ⅰ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr1 = new long[n - 1];
        long[] arr2 = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = scanner.nextLong();
        }
        long minResult = 0;

        for (int i = 0; i < n - 1; i++) {
            arr2[i] = scanner.nextLong();
            minResult += Math.min(arr1[i], arr2[i]);
        }
        System.out.println(minResult);
    }
}
