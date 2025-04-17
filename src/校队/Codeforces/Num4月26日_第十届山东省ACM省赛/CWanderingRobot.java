package 校队.Codeforces.Num4月26日_第十届山东省ACM省赛;

import java.util.Scanner;

// 模拟
// Codeforces:https://codeforces.com/gym/104459/problem/C

// 题意：
// 一个机器人，在一个二维平面上，刚开始的坐标是（0，0），我们给他n和k两个值，分别代表一组指令有几个命令，和命令循环执行多少次，在这过程中，求这个机器人与原点之间最大的曼哈顿距离。

public class CWanderingRobot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long T = scanner.nextLong();
        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            String A = scanner.next();

            long x = 0, y = 0;
            long max = -999999;
            for (int j = 0; j < n; j++) {
                if (A.charAt(j) == 'U')
                    y++;
                else if (A.charAt(j) == 'D')
                    y--;
                else if (A.charAt(j) == 'R')
                    x++;
                else if (A.charAt(j) == 'L')
                    x--;

                max = Math.max(max, Math.abs(x) + Math.abs(y));
            }

            x *= (k - 1);
            y *= (k - 1);
            for (int j = 0; j < n; j++) {
                if (A.charAt(j) == 'U')
                    y++;
                else if (A.charAt(j) == 'D')
                    y--;
                else if (A.charAt(j) == 'R')
                    x++;
                else if (A.charAt(j) == 'L')
                    x--;

                max = Math.max(max, Math.abs(x) + Math.abs(y));
            }
            System.out.println(max);
        }
    }
}
