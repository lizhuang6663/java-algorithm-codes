package 洛谷.蓝桥杯.简单;

import java.util.Scanner;


// 蓝桥杯：https://www.luogu.com.cn/problem/P8748
public class P8748时间显示 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();

        time /= 1000;
        long shi = time / 60 / 60 % 24;
        long fen = time / 60 % 60;
        long miao = time % 60;

        System.out.printf("%02d:%02d:%02d", shi, fen, miao);

    }
}
