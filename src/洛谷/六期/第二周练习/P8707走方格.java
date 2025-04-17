package 洛谷.六期.第二周练习;

import java.util.Scanner;

// dfs
// 洛谷，蓝桥杯：https://www.luogu.com.cn/problem/P8707?contestId=162817

public class P8707走方格 {
    static int n, m;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        dfs(1, 1);

        System.out.println(ans);
    }

    public static void dfs(int i, int j) {
        if (i == n && j == m) {
            ans++;
            return;
        }

        // 判断位置是否超界；判断这个位置行和列是否都是偶数
        // 向右走
        if (i < n && (((i + 1) & 1) == 1 || (j & 1) == 1)) {
            dfs(i + 1, j);
        }

        // 向下走
        if (j < m && ((i & 1) == 1 || ((j + 1) & 1) == 1)) {
            dfs(i, j + 1);
        }

    }

}

