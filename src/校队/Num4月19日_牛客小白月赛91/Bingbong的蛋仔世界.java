package 校队.Num4月19日_牛客小白月赛91;

import java.util.Scanner;

// 思维
// 牛客，校队比赛：https://ac.nowcoder.com/acm/contest/78807/C

public class Bingbong的蛋仔世界 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int result = 0;
        for (int i = 0; i < k; i++) {
            int nowRow = scanner.nextInt();
            int nowCol = scanner.nextInt();
            int should = Math.abs(n / 2 + 1 - nowRow) + Math.abs(m / 2 + 1 - nowCol);

            int temp = Math.max( n - (n/2 + 1),  m - (m/2 + 1));
            if (should <= temp) {
                result++;
            }

        }

        System.out.println(result);
    }
}
