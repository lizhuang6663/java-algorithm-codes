package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;

// 回溯或者暴力
// 洛谷：https://www.luogu.com.cn/problem/P3392

public class P3392涂条纹 {

    // 方法一：回溯
//    static int result = Integer.MAX_VALUE;
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        char[][] chars = new char[n][m];
//        for (int i = 0; i < n; i++) {
//            chars[i] = scanner.next().toCharArray();
//        }
//
//        // 第一行只能选白色
//        int temp = update(chars[0], 'W');
//        backTracking(chars, 2, 1, temp);
//
//        System.out.println(result);
//    }
//
//
//    /**
//     * @param chars
//     * @param row    现在到第几行了（row从1开始计数）
//     * @param select 上一行的选择 1:白色，2:蓝色，3:红色
//     */
//    public static void backTracking(char[][] chars, int row, int select, int change) {
//        if (row == chars.length+1) {
//            result = Math.min(result, change);
//            return;
//        }
//
//        // 下一行只能选择白色或是蓝色
//        if (select == 1 && row <= chars.length-2) {
//            // 1.选白色
//            int temp = update(chars[row-1], 'W');
//            backTracking(chars, row + 1, 1, change + temp);
//
//            // 2.选蓝色
//            temp = update(chars[row-1], 'B');
//            backTracking(chars, row + 1, 2, change + temp);
//        }
//
//        // 只能选择蓝色
//        if (select == 1 && row == chars.length-1) {
//            int temp = update(chars[row-1], 'B');
//            backTracking(chars, row + 1, 2, change + temp);
//        }
//
//        // 下一行只能选择蓝色或者红色
//        if ((select == 2 && row <= chars.length-1)) {
//            // 1.选蓝色
//            int temp = update(chars[row-1], 'B');
//            backTracking(chars, row + 1, 2, change + temp);
//
//            // 2.选红色
//            temp = update(chars[row-1], 'R');
//            backTracking(chars, row + 1, 3, change + temp);
//        }
//
//        // 下一行只能选择红色，或者是最后一行必须选择红色
//        if (select == 3 || row == chars.length) {
//            int temp = update(chars[row-1], 'R');
//            backTracking(chars, row + 1, 3, change + temp);
//        }
//
//    }
//
//    public static int update(char[] chars, char ch) {
//        int temp = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] != ch) temp++;
//        }
//        return temp;
//    }



    // 方法二：暴力
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int mi = Integer.MAX_VALUE;

        char[][] c = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = scanner.next();
            for (int j = 1; j <= m; j++) {
                c[i][j] = s.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n - 2; i++) { // 由于白色下面还有蓝色和红色，所以i（白与蓝的边界）枚举到（n-2）
            for (int j = i + 1; j <= n - 1; j++) { // j（蓝与红的边界）至少要比i大1，同理枚举到（n-1），这样可以减少枚举次数
                int ans = 0;

                // 从 1到i 全部换成白色
                for (int k = 1; k <= i; k++) {
                    for (int g = 1; g <= m; g++) {
                        if (c[k][g] != 'W') {
                            ans++;
                        }
                    }
                }

                // 从 i+1到j全部换成蓝色
                for (int k = i + 1; k <= j; k++) {
                    for (int g = 1; g <= m; g++) {
                        if (c[k][g] != 'B') {
                            ans++;
                        }
                    }
                }

                // 从 j+1到n全部换成蓝色
                for (int k = j + 1; k <= n; k++) {
                    for (int g = 1; g <= m; g++) {
                        if (c[k][g] != 'R') {
                            ans++;
                        }
                    }
                }

                mi = Math.min(ans, mi); // 更新
            }
        }

        System.out.println(mi);
    }
}