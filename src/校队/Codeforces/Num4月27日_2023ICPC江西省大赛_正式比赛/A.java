package 校队.Codeforces.Num4月27日_2023ICPC江西省大赛_正式比赛;

import java.util.Scanner;

/*
    2023（ICPC）江西省大赛——正式比赛
    2023 (ICPC) Jiangxi Provincial Contest -- Official Contest
    比赛链接：https://codeforces.com/gym/104385

    题解：https://www.acwing.com/blog/content/38214/
    https://codeforces.com/gym/104385/attachments/download/21326/a657cde8de794f5f8359c1f1747cc9b9.pdf

 */

// 签到题

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            long N = scanner.nextLong();
            long S = scanner.nextLong();
            long V = scanner.nextLong();
            if (S * V >= N) System.out.println(1);
            else System.out.println(0);
        }
    }
}

