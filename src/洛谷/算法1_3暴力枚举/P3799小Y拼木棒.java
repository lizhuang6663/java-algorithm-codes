package 洛谷.算法1_3暴力枚举;

import java.util.*;

// 暴力
// 洛谷：https://www.luogu.com.cn/problem/P3799
// 题解：https://www.luogu.com.cn/article/pvxrgkd9

public class P3799小Y拼木棒 {
    static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[(int) (5 * 1e3 + 5)];

        int begin = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int len = scanner.nextInt();
            begin = Math.min(begin, len);
            end = Math.max(end, len);
            arr[len]++;
        }

        long ans = 0;

        // 需要从begin+1开始，因为begin是最小的数，无论如何也不能作为两条边
        for (int i = begin + 1; i <= end; i++) { // 先找两个相同的数，作为两条边
            if (arr[i] > 1) { // 数量必须>1，要不然凑不成前面的两根木棍
                for (int j = begin; j <= i / 2; j++) { // 找另外两个数，作为第三条边（这两个数可能相同，也可能不相同），j不能超过i的一半，如果超过了就一定不能组成三条边相同的了
                    // 两条边都为i，那么另一条的两个数为 j 和 j-i
                    if (arr[j] != 0 && arr[i - j] != 0) { // 看看个数是不是为0

                        if (j == i - j && arr[j] >= 2) { // 如果两个是相等的，还需要注意这个够不够两根
                            ans = ans + (arr[i] * (arr[i] - 1) >> 1) * (arr[j] * (arr[j] - 1) >> 1) % MOD;
                        } else if (j != i - j) { // 要特别注意这个if，因为上边的条件中如果j == i - j但是a[j] < 2仍然会来到这个分支，所以我们必须保证j != i - j才能进行下一步计算
                            ans = ans + ((arr[i] * (arr[i] - 1) >> 1) * arr[j] * arr[i - j]) % MOD;
                        }

                        ans %= MOD;
                    }

                }
            }

        }

        System.out.println(ans);
    }

}
