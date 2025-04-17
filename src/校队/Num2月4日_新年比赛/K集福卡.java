package 校队.Num2月4日_新年比赛;

import java.util.Scanner;

// 签到题：https://ac.nowcoder.com/acm/contest/73955/K

public class K集福卡 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < 4; j++) {
                long temp = scanner.nextLong();
                min = Math.min(min, temp);
            }

            long E = scanner.nextLong();
            System.out.println((E + min)/ 2);
        }

    }
}

/*

1
10 2 3 4 2

1
10 2 3 4 10000000000000000000

 */