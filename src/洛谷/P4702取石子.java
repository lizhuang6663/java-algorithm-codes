package 洛谷;

import java.util.Scanner;

// 洛谷：https://www.luogu.com.cn/problem/P4702

public class P4702取石子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + scanner.nextInt()) % 10;
//            sum += scanner.nextInt();
        }


        // 这里只需要看二进制的个位数，所以可以 sum %= 10，不用开long
        // 奇数
        if ((sum & 1) == 1) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }

    }
}
