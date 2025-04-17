package common.homework;

import java.util.*;


/*
http://oj.ecustacm.cn/problem.php?id=1323

首先，找到巧克力块中的最小边，将其设为left的初始值，将最大边设为right的初始值，然后计算一个中间值mid。
对于每块巧克力，计算可以切出边长为mid的正方形块的数量，然后将这些数量相加。
如果总数大于等于K，说明边长为mid的正方形可以满足小朋友们的需求，可以继续尝试更大的边长。否则，需要尝试更小的边长。
重复步骤2，直到left等于right，此时left即为最大的边长。

 */

public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] heights = new int[N];
        int[] widths = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
            widths[i] = scanner.nextInt();
        }

        int left = 1; // 最小边长
        int right = 100000; // 最大边长

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (isPossible(heights, widths, K, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    private static boolean isPossible(int[] heights, int[] widths, int K, int sideLength) {
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            count += (heights[i] / sideLength) * (widths[i] / sideLength);
        }
        System.out.println(sideLength + " " + count);
        return count >= K;
    }

}


/*

输入：
2 10
6 5
5 6

输出：2
 */