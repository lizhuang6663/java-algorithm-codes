package 校队.校队题库.不太理解和做错的;

import java.util.Scanner;

// 二维滑动窗口
// 时间超限（只通过了两个测试）
public class P1011滑动窗口模板题二维 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 行
        int m = scanner.nextInt(); // 列
        int x = scanner.nextInt(); // 窗口的宽
        int y = scanner.nextInt(); // 窗口的高

        int[][] arr = new int[n][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[m];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        long result = 0; // 总和
        for (int i = 0; i <= n - x; i++) {
            for (int j = 0; j <= m - y; j++) {

                // 找到这个窗口中的最大值
                int max = Integer.MIN_VALUE;
                for (int k = i; k < i + x; k++) {
                    for (int l = j; l < j + y; l++) {
                        max = Math.max(max, arr[k][l]);
                    }
                }
                result += max;
            }
        }

        System.out.println(result);

    }
}
