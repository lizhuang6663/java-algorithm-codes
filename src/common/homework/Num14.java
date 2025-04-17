package common.homework;

import java.util.Scanner;

// 两两比赛：
// 校队：https://ac.nowcoder.com/acm/contest/72681/A

/**

    比赛有 n 个人参加（其中 n 为2的幂），每个参赛者根据资格赛和预赛、复赛的成绩，会有不同的积分。比赛采取锦标赛赛制，分轮次进行，设某一轮有 m 个人参加，那么参赛者会被分为 m/2 组，每组恰好 2 人，m/2 组的人分别厮杀。我们假定积分高的人肯定获胜，若积分一样，则随机产生获胜者。获胜者获得参加下一轮的资格，输的人被淘汰。重复这个过程，直至决出冠军。
    现在请问，参赛者小美最多可以活到第几轮（初始为第0轮）？

    输入描述:
    第一行一个整数 n (1≤n≤ 2^20)，表示参加比赛的总人数。
    接下来 n 个数字（数字范围：-1000000…1000000），表示每个参赛者的积分。小美是第一个参赛者。

    输出描述:小美最多参赛的轮次。

    输入:
    4
    4 1 2 3
    输出:2
*/


public class Num14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int xiaoMei = 0;
        int smallSum = 0;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (i == 0) xiaoMei = x;
            if (x <= xiaoMei) smallSum++;
        }

        int result = 0;
        while (smallSum > 1) {
            smallSum /= 2;
            result ++;
        }
        System.out.println(result);

    }
}



/*

4
4 1 2 3
2


8
4 1 2 3 5 6 7 8
2


4
1 1 1 1
2


4
3 1 2 3
2


8
4 1 2 4 5 6 7 8
2


8
4 1 2 3 4 6 7 8
2

8
1 1 1 1 1 1 1 1
3


8
4 1 2 3 4 4 7 8
2

 */
