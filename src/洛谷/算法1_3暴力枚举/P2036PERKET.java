package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;

// 回溯
// 洛谷：https://www.luogu.com.cn/problem/P2036

public class P2036PERKET {
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        backTracking(arr, 0, 1, 0);
        System.out.println(result);
    }


    public static void backTracking(int[][] arr, int startIndex, int suan, int ku) {
        if (startIndex != 0) {
            result = Math.min(result, Math.abs(suan - ku));
        }

        for (int i = startIndex; i < arr.length; i++) {
            suan = suan * arr[i][0];
            ku += arr[i][1];

            backTracking(arr, i + 1, suan, ku);

            suan = suan / arr[i][0];
            ku -= arr[i][1];
        }
    }


}
