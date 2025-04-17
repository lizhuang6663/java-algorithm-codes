package 前缀和和差分;

import java.util.Scanner;

public class 二维差分 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        // 将a看作二维前缀和数组，将b看作二维差分数组
        int[][] a = new int[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int[][] b = new int[n + 2][m + 2];

        // 构建二维差分
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                b[i][j] = a[i][j] - a[i - 1][j] - a[i][j - 1] + a[i - 1][j - 1];
                // 或者：
//                b[i][j] += a[i][j];
//                b[i + 1][j] -= a[i][j];
//                b[i][j + 1] -= a[i][j];
//                b[i + 1][j + 1] += a[i][j];
            }
        }

        // 将选中的子矩阵中的每个元素的值加上c
        for (int i = 0; i < q; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int c = scanner.nextInt();

            // 在x1到x2，y1到y2之间加上c
            // 这里的坐标不要写错了
            b[x1][y1] += c;
            b[x2 + 1][y1] -= c;
            b[x1][y2 + 1] -= c;
            b[x2 + 1][y2 + 1] += c;
        }

        // 重构二维前缀和数组(重新给数组a赋值)
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*

3 4 3
1 2 2 1
3 2 2 1
1 1 1 1
1 1 2 2 1
1 3 2 3 2
3 1 3 4 1

2 3 4 1
4 3 4 1
2 2 2 2


 */