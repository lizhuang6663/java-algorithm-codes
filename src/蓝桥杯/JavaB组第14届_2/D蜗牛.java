package 蓝桥杯.JavaB组第14届_2;

import java.util.Scanner;

// 动态规划
// dp数组必须开二维是因为有两个特殊状态，一个是在竹竿底部，另一个是在传送门处，只有二维数组才能保证当前状态是局部最优解。
// 另一个重点是确定状态转移方程，也是分成两个特殊状态，在竹竿底部时，可能是从此竹竿的传送门向下走到也可能是从上一根竹竿底部沿x轴走到此竹竿底部；
// 在传送门时，可能是从此竹竿底部向上走到传送门，也可能是从上根竹竿的传送门传送到，并且第二种情况要注意判断一根竹竿上可能对应高度不同的两个传送门。

public class D蜗牛 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // 存放竹竿坐标
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = scan.nextInt();
        }

        // 存放传送门
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i < n; i++) {
            a[i] = scan.nextInt();
            b[i + 1] = scan.nextInt();
        }

        // dp[i][0]：表示到达第i个位置的底部花费的时间
        // dp[i][1]：表示到达第i个位置的传送门花费的时间

        double[][] dp = new double[n + 1][2];
        dp[1][0] = x[1];
        dp[1][1] = x[1] + a[1] / 0.7;

        for (int i = 2; i <= n; i++) {
            // 1.从上一个节点的底部爬到当前节点的底部；2.从上一个节点的传送门位置传送到当前节点的传送门位置，然后爬到当前节点底部
            dp[i][0] = Math.min(dp[i - 1][0] + x[i] - x[i - 1], dp[i - 1][1] + b[i] / 1.3);

            if (i != n) {
                // 1.从上一个节点的底部爬到当前节点的底部，然后爬到当前节点的传送门位置；2.从上一个节点的传送门位置传送过来，然后再爬到当前节点到下一个节点的传送门位置
                double demo = 0;
                // 当前节点的传送门 a[i]（当前节点到达下一个节点），前一个节点到达当前节点的传送门高度 b[i]
                if (a[i] < b[i]) { // 需要接着往下爬
                    demo = (b[i] - a[i]) / 1.3;
                } else { // 需要接着向上爬
                    demo = (a[i] - b[i]) / 0.7;
                }
                dp[i][1] = Math.min(dp[i - 1][0] + x[i] - x[i - 1] + a[i] / 0.7, dp[i - 1][1] + demo);
            }
        }

        System.out.printf("%.2f\n", dp[n][0]);
        scan.close();
    }
}
