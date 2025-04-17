package 洛谷.数学思维;

import java.util.Scanner;

// 四舍五入
// 洛谷：https://www.luogu.com.cn/problem/P7258
public class P7258SLATKISI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        int money = (int) Math.pow(10, k);
        //temp用来判断需要四舍 还是需要五入
        int temp = money / 2;

        int result = 0;

        //判断需要四舍 还是需要五入
        if (c % money >= temp) {
            result = (c / money + 1) * money;//五入
        } else {
            result = c / money * money;//四舍
        }

        System.out.println(result);



        int n = (int) Math.pow(10, k);
        // 四舍
        if (c % n < n / 2) {
            System.out.println(c / n * n);
        } else {
            System.out.println((c / n + 1) * n);
        }


    }
}
