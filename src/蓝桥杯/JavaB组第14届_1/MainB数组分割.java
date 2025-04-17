package 蓝桥杯.JavaB组第14届_1;

import java.util.Scanner;

// 组合公式
// 蓝桥杯：https://www.lanqiao.cn/problems/3535/learning/

public class MainB数组分割 {
    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int ji = 0;
            int ou = 0;
            // 统计偶数和奇数的个数
            for (int j = 0; j < n; j++) {
                if ((scanner.nextInt() & 1) == 1) {
                    ji++;
                } else {
                    ou++;
                }
            }

            // 用公式：2^ou * 2^(ji-1)
            if ((ji & 1) == 1) { // 如果奇数的个数为奇数个，一定不可能成功
                System.out.println(0);
            } else {
                long result = 1;

                for (int j = 0; j < ou; j++) {
                    result = result * 2 % MOD; // 如果改为 result = result << 1 % MOD，在蓝桥杯官网上结果却失败了只能通过高20%的案例
                }

                for (int j = 0; j < ji - 1; j++) {
                    result = result * 2 % MOD;
                }

                System.out.println(result);
            }
        }

        scanner.close();
    }
}
