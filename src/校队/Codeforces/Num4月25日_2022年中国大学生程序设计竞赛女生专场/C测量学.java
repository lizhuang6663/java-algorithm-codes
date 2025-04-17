package 校队.Codeforces.Num4月25日_2022年中国大学生程序设计竞赛女生专场;

import java.util.Scanner;

// 签到题
// Codeforces：https://codeforces.com/gym/104081/problem/C

public class C测量学 {
    public static final double PI = 3.141592;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double R = scanner.nextDouble();
        double o = scanner.nextDouble();

        if (o > PI) o = 2 * PI - o;

        double minWai;
        double minNei;
        double result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            double temp = scanner.nextDouble();

            minWai = R * o; // 从最外边走
            minNei = 2 * (R - temp) + temp * o; // 从最内部走

            result = Math.min(result, Math.min(minWai, minNei));
        }

        System.out.printf("%.6f", result);
    }
}
