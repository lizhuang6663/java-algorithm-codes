package common.homework;

import java.util.Scanner;

//洛谷：判断四舍五入
//https://www.luogu.com.cn/problem/P7258

public class Num10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int k = scanner.nextInt();

        int money = (int) Math.pow(10, k);
        //temp用来判断需要四舍 还是需要五入
        int temp = 5;

        if (money > 10) {
            temp = temp*(money/10);
        }

        int result = 0;

        //判断需要四舍 还是需要五入
        if (c % money >= temp) {
            result = c + (money - c%money);//五入
        }else {
            result = c - c%money;//四舍
        }

        System.out.println(result);
    }


    //再简洁一点（推荐）
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int k = scanner.nextInt();

        int money = (int) Math.pow(10, k);
        //temp用来判断需要四舍 还是需要五入,temp = 5 | 50 | 500 .....
        int temp = money/2;

        //判断需要四舍 还是需要五入
        if (c % money >= temp) {
            System.out.println((c/money + 1) * money);//五入
        }else {
            System.out.println(c/money * money);//四舍
        }


    }
}
