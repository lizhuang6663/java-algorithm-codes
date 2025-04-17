package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;

// 回溯
// 洛谷：https://www.luogu.com.cn/problem/P1149

public class P1149火柴棒等式 {
    // 最后一个案例时间超限
//    static int result = 0;
//    static int[] num = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        backTracking(n - 4, 1, new int[4]);
//
//        System.out.println(result);
//    }
//
//
//    /**
//     * @param need 还需要多少个棍子
//     * @param l    当前是第几个数
//     * @param b    存挑选的数
//     */
//    public static void backTracking(int need, int l, int[] b) {
//        if (need == 0 && l == 4 && b[1] + b[2] == b[3]) {
//            result++;
////            System.out.println(b[1] + " " +  b[2] + " " +  b[3]);
//            return;
//        }
//
//        if (need < 0 || l == 4) return;
//
//        for (int i = 0; i <= 999; i++) {
//            // 棍子还够用
//            if (judgeNum(i) <= need) {
//                b[l] = i;
//
//                backTracking(need - judgeNum(i), l + 1, b);
//            }
//
//        }
//    }
//
//
//    // 判断某个数字需要多少根火柴
//    public static int judgeNum(int n) {
//        int temp = 0;
//
//        String str = String.valueOf(n);
//        for (int i = 0; i < str.length(); i++) {
//            temp += num[str.charAt(i) - '0'];
//        }
//
//        return temp;
//    }



    // 改进：打表
    static int result = 0;
    static int[] num = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static int[] num2;// 最终使用的数组

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        num2 = new int[1001];
        for (int i = 0; i < num.length; i++) {
            num2[i] = num[i];
        }
        // 把2位数火柴棒， 3位数火柴棒放入数组， 理论上可达到11111111，但因为数据弱四位就过了
        // 判断某个数字需要多少根火柴
        for (int i = 10; i <= 999; i++) {
            num2[i] = num2[i / 10] + num2[i % 10];
        }

        backTracking(n - 4, 1, new int[4]);

        System.out.println(result);
    }


    /**
     * @param need 还需要多少个棍子
     * @param l    当前是第几个数
     * @param b    存挑选的数
     */
    public static void backTracking(int need, int l, int[] b) {
        if (need == 0 && l == 4 && b[1] + b[2] == b[3]) {
            result++;
            return;
        }

        if (need < 0 || l == 4) return;

        for (int i = 0; i <= 999; i++) {
            // 棍子还够用
            if (num2[i] <= need) {
                b[l] = i;

                backTracking(need - num2[i], l + 1, b);
            }

        }
    }


}
