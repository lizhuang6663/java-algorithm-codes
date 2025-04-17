package 蓝桥杯.JavaB组第15届;

import java.util.Scanner;

// 贪心，资源分配优化

public class D食堂 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            // a：2人寝，b：3人寝，c：4人寝
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            // x：4人桌，y：6人桌
            int x = scan.nextInt(), y = scan.nextInt();

            int result = 0;

            // 先放2个3人寝，完全把6人桌塞满（为了避免后面出现4人桌有一个空闲位置的情况）
            while (b >= 2 && y >= 1) {
                result += 6;
                b -= 2;
                y--;
            }

            // 然后减少2人寝，尝试把6人桌变为4人桌
            while (a >= 1 && y >= 1) {
                result += 2;
                a--;
                y--;
                x++;
            }


            // 现在的桌子数量就应该是4人桌了（没有6人桌：除了桌子非常充分的情况下，以及2、3人寝太少的情况）

            // 剩下的放置优先级为：4人寝、2个2人寝，3人寝，2人寝
            int num = x + y;
            while (c >= 1 && num >= 1) {
                result += 4;
                c--;
                num--;
            }

            while (a >= 2 && num >= 1) {
                result += 4;
                a -= 2;
                num--;
            }

            while (b >= 1 && num >= 1) {
                result += 3;
                b--;
                num--;
            }

            while (a >= 1 && num >= 1) {
                result += 2;
                a -= 2;
                num--;
            }

            System.out.println(result);
        }
        scan.close();
    }
}
