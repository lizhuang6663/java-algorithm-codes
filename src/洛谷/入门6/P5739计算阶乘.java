package 洛谷.入门6;


import java.util.Scanner;

// 递归
public class P5739计算阶乘 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        System.out.println(jisuan(n));
    }
    public static long jisuan(Long n) {
        if (n == 1) return 1;
        return n* jisuan(n-1);
    }

}
