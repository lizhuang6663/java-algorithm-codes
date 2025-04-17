package 蓝桥杯.JavaB组第15届;

import java.util.Scanner;

// 数学概率问题

/*

每组有K个，一共有N/K组，每一个个体有病毒的概率为 p
那么每一组中没有病毒的概率为：(1-p)^K
那么每一组中有病毒的概率为：1-(1-p)^K

分两种情况：1.组中没有病毒，只需要检测1次；2.组中有病毒，需要检测K+1次
情况1：一共有N/K组，如果没有病毒那么需要检测： (1-p)^K * N/K * 1 次（没有病毒的组数 * 需要检测的次数）
情况2：一共有N/K组，如果有病毒那么需要检测： [1-(1-p)^K] * N/K * (K+1) 次（有病毒的组数 * 需要检测的次数）

总共需要检测的次数就是情况1 + 情况2，即：(1-p)^K * N/K + (1-p)^K * N/K * (K+1)
化简：
设 P = (1-p)^K
那么：总次数 = (P + (1-P)*(K+1) ) * N/K（也可以完全化简为 N + N/K - NP）

然后对K进行遍历，直到找到最合适的值

 */

public class E最优分组 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        double p = scan.nextDouble();

        int resK = 0;
        double total = Double.MAX_VALUE; // 记录总次数

        for (int K = 1; K <= N; K++) {
            if (N % K == 0) {

                // 临时记录总次数
                double demo = N +  (double) N / K - N * Math.pow((1-p), K);

                if (K == 1) {
                    demo = N; // 这种情况必须要手动设置一下，否则下面的判断会错误（因为如果K==1的时候不手动设置，那么demo就不等于N，这明显是错误的）
                }

                // 如果找到更小的总次数，那么就更新
                if (total > demo) {
                    total = demo;
                    resK = K;
                }

            }
        }

        System.out.println(resK);
        scan.close();
    }
}
