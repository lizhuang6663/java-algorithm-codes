package 代码随想录And力扣.动态规划;

import java.util.Scanner;

// 动态规划
// 卡码网：https://kamacoder.com/problempage.php?pid=1046

public class 携带研究材料 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] weights = new int[m];
        for (int i = 0; i < m; i++) {
            weights[i] = scanner.nextInt();
        }

        int[] values = new int[m];
        for (int i = 0; i < m; i++) {
            values[i] = scanner.nextInt();
        }

        testWeightBagProblem(weights, values, n);
//        testWeightBagProblem2(weights, values, n);
    }

    // 方法一：二维
    /**
     * 动态规划获得结果
     *
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[goods - 1][bagSize]);
    }


    // 方法二：一维
    // 倒序遍历是为了保证物品i只被放入一次！。但如果一旦正序遍历了，那么物品0就会被重复加入多次！从后往前循环，每次取得状态不会和之前取得状态重合，这样每种物品就只取一次了。
    // 两个嵌套for循环的顺序，代码中是先遍历物品嵌套遍历背包容量，不可以先遍历背包容量嵌套遍历物品。
    public static void testWeightBagProblem2(int[] weight, int[] value, int bagSize) {
        int dp[] = new int[bagSize + 1];
        int wLen = weight.length;

        for (int i = 0; i < wLen; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(dp[bagSize]);
    }

}

/*

6 1
2 2 3 1 5 2
2 3 1 5 4 3

5

 */