package 洛谷.蓝桥杯.数学思维;

import java.util.Scanner;

// 求商：数学思维，公式推导
// P9240 [蓝桥杯 2023 省 B] 冶炼金属
// 蓝桥杯：https://www.luogu.com.cn/problem/P9240?contestId=162285

/*

公式推导：
B <= A获得木头/V < B+1
1/B >= V/A获得木头 > 1/(B+1)
A获得木头/B >= V > A获得木头/(B+1)

 */
public class P9240冶炼金属 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int min = 0;
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            min = Math.max(min, a / (b + 1) + 1);
            max = Math.min(max, a / b); // 将 a 分成 b 份，即求商，表示至多可以将 a 分成多少份才能满足每份不大于 b 的要求。
        }
        System.out.println(min + " " + max);
    }
}
