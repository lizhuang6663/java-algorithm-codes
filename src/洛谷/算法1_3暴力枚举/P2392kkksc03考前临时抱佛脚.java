package 洛谷.算法1_3暴力枚举;

import java.util.*;

// dfs：数据量低，1<=s1,s2,s3,s4<=20，时间复杂度2^20
// 洛谷：https://www.luogu.com.cn/problem/P2392

public class P2392kkksc03考前临时抱佛脚 {
    static int[] subject = new int[4];
    static int[][] times = new int[4][];
    static int left;//左脑
    static int right;//右脑
    static int minn;//某一门科目最小时间

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            subject[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            times[i] = new int[subject[i]];
            for (int j = 0; j < subject[i]; j++) {
                times[i][j] = scanner.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            left = 0;
            right = 0;
            minn = Integer.MAX_VALUE;
            dfs(i, 0);
            result += minn;
        }
        System.out.println(result);
    }

    static void dfs(int i, int j) {
        // Left += times[i][j];：这行代码表示左脑花费了 times[i][j] 的时间来复习当前科目的第 j 道题目。
        // dfs(i, j+1);：然后，程序递归地调用 dfs 函数，继续处理当前科目的下一道题目（即 j+1）。
        // Left -= times[i][j];：递归调用返回后，程序会撤销左脑复习当前题目所花费的时间，以便尝试其他的复习方案。
        // Right += times[i][j];：这行代码表示右脑花费了 times[i][j] 的时间来复习当前科目的第 j 道题目。
        // dfs(i, j+1);：然后，程序递归地调用 dfs 函数，继续处理当前科目的下一道题目（即 j+1）。
        // Right -= times[i][j];：递归调用返回后，程序会撤销右脑复习当前题目所花费的时间，以便尝试其他的复习方案。

        // 这门课的题目遍历完了
        if (j == subject[i]) {
            minn = Math.min(Math.max(left, right), minn); // Math.max(left, right)：必须是左右脑中耗时最长的一个脑子去和minn比较
            return;
        }

        left += times[i][j];
        dfs(i, j + 1);
        left -= times[i][j];

        right += times[i][j];
        dfs(i, j + 1);
        right -= times[i][j];
    }
}

/*

1 2 1 3
5
4 3
6
2 4 3

20


1 3 1 3
5
4 3 2
6
2 4 3

21


1 6 1 2
3
3 8 4 3 1 5
5
4 2

24


1 1 1 6
5
4
6
1 1 1 1 1 10000

10015

*/


