package 校队.Num7月19日_牛客周赛;

import java.util.Scanner;

// 签到题

public class A树上游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num == 1) {
                System.out.println("Keduoli");
                continue;
            }

            if ((num & 1) == 1) {
                System.out.println("Bingbong");
            }else {
                System.out.println("Keduoli");
            }
        }
    }
}
