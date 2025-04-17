package 蓝桥杯.第2023年真题;

import java.util.Arrays;
import java.util.Scanner;

public class 清理水域 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], 1);
        }


        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int r1 = scanner.nextInt();
            int c1 = scanner.nextInt();
            int r2 = scanner.nextInt();
            int c2 = scanner.nextInt();


            for (int j = r1-1; j <= r2-1 ; j++) {
                for (int k = c1-1; k <= c2-1 ; k++) {
                    arr[j][k] = 0;
                }
            }

        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) ans++;
            }
        }

        System.out.println(ans);

        scanner.close();
    }
}
