package common.incomplete;


import java.util.Scanner;


// 动态规划（不会）
// 校队比赛：https://ac.nowcoder.com/acm/contest/73229/F

public class Num4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long[] arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }

        long[][] f = new long[n + 1][m];
        for (int i = 1; i <= n; i++) {
            f[i][(int) (arr[i] % m)] = arr[i];
        }

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j] + "   ");
            }
            System.out.println();
        }


        for (int i = 1; i <= n; i++) {
            int k = (int) (arr[i] % m);

            for (int j = 0; j < m; j++) {
                int v = (j + k) % m;
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                f[i][v] = Math.max(f[i][v], f[i - 1][v]);
                if (f[i - 1][j] != 0) {
                    f[i][v] = Math.max(f[i][v], f[i - 1][j] + arr[i]);
                }
            }
        }
        System.out.println(f[n][0]);

    }
}


