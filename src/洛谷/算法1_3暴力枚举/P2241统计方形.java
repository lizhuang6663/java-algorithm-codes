package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;

// 枚举
// 洛谷：https://www.luogu.com.cn/problem/P2241

public class P2241统计方形 {
    // 方法一：
    // 思路：算出总共的组合情况，减去正方形的情况，就是长方形的情况
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 总共的结合情况：
        // 行有 n + 1 条边，列有 m + 1 条边
        // 从行的边数量 n + 1 中任选两条边，从列的边数量 m + 1 中任选两条边，相乘就是总共的组合情况
        // 排列组合 C_PolycarpRecoversthePermutation(n+1)2，C_PolycarpRecoversthePermutation(m+1)2

        long total = ((long) (n + 1) * n / 2) * ((long) (m + 1) * m / 2); // 总共的结合情况

        // 正方形的个数：
        long ans1 = 0;
        for (int i = 1; i <= Math.min(n, m); i++) {
            ans1 += (n + 1 - i) * (m + 1 - i);
            // 比如：n = 3, m = 4
            // 3*4 + 2*3 + 1*2
            // 道理和上面差不多：（但是这里是连续的1条边，连续的2条边，连续的3条边...，不能用排列组合了）
            // 边长为1：行有4条边，长度为1的有3种情况；行有5条边，长度为1的有5种情况
            // 边长为2：行有4条边，长度为2的有2种情况；行有5条边，长度为2的有3种情况
            // 边长为3：行有4条边，长度为3的有1种情况；行有5条边，长度为3的有2种情况
        }

        // 长方形的个数：
        long ans2 = total - ans1;
        System.out.println(ans1 + " " + ans2);
    }


    // 方法二：和方法一差不多
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        long ans1 = 0;
//        long ans2 = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                // 这个注释感觉可以忽略了，看方法一的注释就可以了
//                // 当一个方形阵列的边长为 n×m，其中 n 表示行数，m 表示列数时，
//                // 公式(m−i+1)×(n−i+1) 用于计算以阵列中的某个方形为基准，其右下方可容纳的方形数量。
//                // m−i+1 表示当前方形所在列到最右侧列的距离加上该方形本身。因为对角线上的方形到最右侧列的距离就是 i−1，所以 m−i+1 就是该方形右下方能够容纳的方形的列数。
//                // n−i+1 表示当前方形所在行到最底部行的距离加上该方形本身。因为对角线上的方形到最底部行的距离也是 i−1，所以 n−i+1 就是该方形右下方能够容纳的方形的行数。
//                // 因此，(m−i+1)×(n−i+1) 就是该方形右下方能够容纳的方形数量
//
//                if (i == j) {
//                    ans1 += (m - i + 1) * (n - i + 1);
//                } else {
//                    ans2 += (n - i + 1) * (m - j + 1);
//                }
//            }
//        }
//        System.out.println(ans1 + " " + ans2);
//        sc.close();
//    }


}

