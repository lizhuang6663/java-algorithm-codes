package 校队.Codeforces.Num4月26日_第十届山东省ACM省赛;

import java.util.Scanner;

// 贪心
// Codeforces:https://codeforces.com/gym/104459/problem/F

public class FStonesinTheBucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            long sum = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                sum += arr[j];
            }

            // 相当于：把大于平均数的水桶里面的石头移动到小的水桶里面，多余的石头额外移除
            long result = 0;
            long aver = sum / n;
            for (int j = 0; j < n; j++) {
                if (arr[j] < aver) result += aver - arr[j];
            }
            result += sum % n;
            System.out.println(result);

            // 或者算多的，多的就直接包含移动的石头和需要移除的石头，所以不用  result += sum % n
//            long result = 0;
//            long aver = sum / n;
//            for (int j = 0; j < n; j++) {
//                if (arr[j] > aver) result += arr[j] - aver;
//            }
        }
    }
}

/*

4
3
1 1 0
4
2 2 2 2
3
0 1 4
1
1000000000

输出：
2
0
3
0

 */

