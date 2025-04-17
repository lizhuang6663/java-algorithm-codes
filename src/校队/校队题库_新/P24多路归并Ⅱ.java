package 校队.校队题库_新;

import java.util.Scanner;

// 动态规划，三维
// 校队题库：http://154.37.212.21/p/P24
// 【2024河南科技学院新生训练赛(三)-哔哩哔哩】 https://b23.tv/3l6GFGr

public class P24多路归并Ⅱ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 读取道路长度a和b
        long[] a = new long[n + 5];
        long[] b = new long[n + 5];
        // 从索引1开始
        for (int i = 1; i <= n - 1; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n - 1; i++) {
            b[i] = scanner.nextInt();
        }

        long[][][] f = new long[n + 5][3][3]; // 三个索引：n：位置；3:走哪一条路；3:第几次走这条路
        for (int i = 2; i <= n; i++) {
            // 走a
            // 第i个位置：走道路1(也就是a路)，这是第1次走道路1
            f[i][1][1] = Math.min(f[i - 1][2][1], f[i - 1][2][2]) + a[i - 1];
            // 第i个位置：走道路1(也就是a路)，这是第2次走道路1
            f[i][1][2] = f[i - 1][1][1] + a[i - 1]; // 这是第二次走a，所以上一次一定也是走a

            // 走b
            // 第i个位置：走道路2(也就是b路)，这是第1次走道路2
            f[i][2][1] = Math.min(f[i - 1][1][1], f[i - 1][1][2]) + b[i - 1];
            // 第i个位置：走道路2(也就是b路)，这是第2次走道路2
            f[i][2][2] = f[i - 1][2][1] + b[i - 1];
        }

        // 四个：走a路，这是第1次；走a路，这是第2次；走b路，这是第1次；走b路，这是第2次

        long result = Long.MAX_VALUE;
        for (int i = 1; i <= 2; i++) { // 那条路
            for (int j = 1; j <= 2; j++) { // 第几次
                result = Math.min(result, f[n][i][j]);
            }
        }
        System.out.println(result);
    }
}
