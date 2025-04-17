package 校队.Codeforces.Num4月26日_第十届山东省ACM省赛;

import java.util.Scanner;

// 模拟，签到题
// Codeforces：https://codeforces.com/gym/104459/problem/M

public class MSekiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (n == 0) {
                System.out.println(0);
                continue;
            }

            if (k > 32) {
                System.out.println(1);
            } else {
                for (int j = 0; j < k; j++) {
                    n = (n + 1) >> 1;
                }
                System.out.println(n);
            }
        }

    }
}

/*

4
10 1
7 1
10 2
7 2

5
4
3
2

 */