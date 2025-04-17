package 青训营.豆包;

import java.util.Arrays;

// 动态规划（应该也可以用优先队列 PriorityQueue<Integer>）
// dp[i][j] 表示在第 i 天时，拥有 j 份食物的情况下所需的最小花费。我们需要找到第 M 天拥有至少 1 份食物的最小花费。

public class 补给站最优花费问题 {
    public static int solution(int M, int N, int[][] supplyStations) {
        int maxFood = M + 1; // 最大可能的食物数是M + 1，因为每一天需要一份
        int[][] dp = new int[M + 1][maxFood + 1];
        // 初始化 dp 数组，设置为一个较大的值
        for (int i = 0; i <= M; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 初始状态，第0天补给站的成本
        dp[0][1] = 0;

        // 记录补给站信息
        int[] supplyCost = new int[M + 1];
        Arrays.fill(supplyCost, -1);
        for (int[] station : supplyStations) {
            supplyCost[station[0]] = station[1];
        }

        // 逐天更新dp数组
        for (int day = 0; day < M; day++) {
            for (int food = 1; food <= maxFood; food++) {
                if (dp[day][food] == Integer.MAX_VALUE) {
                    continue;
                }

                // 不购买新食物，仅消耗一天的食物
                dp[day + 1][food - 1] = Math.min(dp[day + 1][food - 1], dp[day][food]);

                // 若该天有补给站，可以选择购买
                if (supplyCost[day] != -1) {
                    for (int buy = 1; food + buy <= maxFood; buy++) {
                        int newCost = dp[day][food] + buy * supplyCost[day];
                        dp[day + 1][food + buy - 1] = Math.min(dp[day + 1][food + buy - 1], newCost);
                    }
                }
            }
        }

        // 找到第M天至少剩1份食物的最小花费
        int result = Integer.MAX_VALUE;
        for (int food = 1; food <= maxFood; food++) {
            result = Math.min(result, dp[M][food]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(5, 4, new int[][]{{0, 2}, {1, 3}, {2, 1}, {3, 2}}) == 7);
        System.out.println(solution(6, 5, new int[][]{{0, 1}, {1, 5}, {2, 2}, {3, 4},{5,1}}) == 6);
        System.out.println(solution(4, 3, new int[][]{{0, 3}, {2,2}, {3, 1}}) == 9);
    }
}
