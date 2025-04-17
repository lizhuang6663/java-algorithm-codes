package 校队.Codeforces.Num9月27日_训练赛;

import java.util.Scanner;

// 思维：简单
// Codeforces：https://vjudge.net/contest/657988#problem/A

public class A_PhoneDesktop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = 0;

            int t = (b % 2 == 0) ? (b / 2) : (b / 2 + 1);

            if (t * 15 - b * 4 >= a) {
                result = t;
            } else {
                int i1 = a - (t * 15 - b * 4);

                if (i1 % 15 != 0) {
                    result = t + i1 / 15 + 1;
                } else {
                    result = t + i1 / 15;
                }
            }

            System.out.println(result);
        }

        scanner.close();
    }
}
