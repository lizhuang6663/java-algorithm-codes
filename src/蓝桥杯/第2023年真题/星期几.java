package 蓝桥杯.第2023年真题;

import java.util.Scanner;

public class 星期几 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();

        if ((w + n % 7) % 7 != 0) {
            System.out.println((w + n % 7) % 7);
        }else {
            System.out.println(7);
        }

        scanner.close();
    }
}
