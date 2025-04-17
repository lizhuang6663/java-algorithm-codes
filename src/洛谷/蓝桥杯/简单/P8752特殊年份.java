package 洛谷.蓝桥杯.简单;

import java.util.Scanner;

// 蓝桥杯：https://www.luogu.com.cn/problem/P8752
public class P8752特殊年份 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            int temp = scanner.nextInt();

            if ((temp % 10 == temp / 100 % 10 + 1) && (temp / 1000 == temp / 10 % 10)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
