package 洛谷.蓝桥杯.简单;

import java.util.Scanner;

// 蓝桥杯：https://www.luogu.com.cn/problem/P8753
public class P8753小平方 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (i * i % n < n * 1.0 / 2) {
                ans++;
            }

        }
        System.out.println(ans);
    }
}
