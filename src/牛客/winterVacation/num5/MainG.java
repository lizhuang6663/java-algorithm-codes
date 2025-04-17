package 牛客.winterVacation.num5;

import java.util.Scanner;

// 写错了
public class MainG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        if (n == 1) {
            System.out.println(1);
        }

        if (n % 2 == 0) {
            if (judge(1 + n)) {
                for (int i = n; i >= 1; i--) {
                    System.out.print(i + " ");
                }
            } else {
                System.out.println(-1);
            }

        } else {
            if (judge(2 + n)) {
                System.out.print(1 + " ");
                for (int i = n; i >= 2; i--) {
                    System.out.print(i + " ");
                }
            } else {
                System.out.println(-1);
            }
        }

    }

    // 判断是否是质数
    public static boolean judge(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
              return false;
            }
        }
        return true;
    }
}



