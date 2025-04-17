package 校队.Num5月5日_牛客周赛Round41;

import java.util.Scanner;

// 字符串，前缀和
// 牛客：https://ac.nowcoder.com/acm/contest/80742/D
// 题解：https://ac.nowcoder.com/discuss/1303169?type=101&order=1&pos=1&page=1&ncTraceId=&channel=-1&source_id=discuss_tag_nctrack

/*

    猜结论，尽量等分成 r e d 三份，red 子序列的个数最多。

    区间%3 !=0 时，要枚举所有情况。
    比如余数为 1, 3 个子区间长度可能是
    x+1, x, x
    x, x+1, x
    x, x, x+1
    余数为 2 时，分成 2 个 1，也是 3 种情况
    x+1, x+1, x
    x+1, x, x+1
    x, x+1, x+1

    知道了每个区间的长度，要想快速求解要修改几次把该区间全部变成 r / e /d, 可以使用前缀和。
    helper 函数的参数函数：l, r 是区间左右边界。x, y 分别是 r、e 2 个区间的长度。

 */

public class D小红的好串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        String s = scanner.next();

        // 存当前位置是什么字母
        int[][] g = new int[3][n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            g[0][i] = c == 'r' ? 1 : 0;
            g[1][i] = c == 'e' ? 1 : 0;
            g[2][i] = c == 'd' ? 1 : 0;
        }

        PrefixSum[] pre = new PrefixSum[3];
        for (int i = 0; i < 3; i++) {
            pre[i] = new PrefixSum(g[i]);
        }

        for (int k = 0; k < q; k++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            int N = r - l + 1; // 区间的长度

            if (N <= 2) {
                System.out.println(0);
                continue;
            }

            int x = N / 3;
            int y = N % 3;

            int res = 0;
            if (y == 0) {
                res = helper(l, r, x, x, pre);
            } else if (y == 1) {
                 res = helper(l, r, x, x, pre);
                res = Math.min(res, helper(l, r, x, x + 1, pre));
                res = Math.min(res, helper(l, r, x + 1, x, pre));
            } else {
                 res = helper(l, r, x + 1, x, pre);
                res = Math.min(res, helper(l, r, x, x + 1, pre));
                res = Math.min(res, helper(l, r, x + 1, x + 1, pre));
            }
            System.out.println(res);
        }

        scanner.close();
    }

    public static int helper(int l, int r, int x, int y, PrefixSum[] pre) {
        // n1:变成完美串之后'r'的数量，n2:变成完美串之后'e'的数量，n3:变成完美串之后'd'的数量
        int n1 = x, n2 = y, n3 = r - l + 1 - x - y;
        int cost1 = n1 - pre[0].getSum(l, l + x - 1);
        int cost2 = n2 - pre[1].getSum(l + x, l + x + y - 1);
        int cost3 = n3 - pre[2].getSum(l + x + y, r);
        return cost1 + cost2 + cost3;
    }
}


class PrefixSum {
    private final int n;
    private final int[] sum; // 前缀和

    public PrefixSum(int[] a) {
        this.n = a.length;
        this.sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
        }
    }

    // 返回sum区间l-r内存在字母的数量
    public int getSum(int l, int r) {
        if (l > r) {
            return 0;
        }
        return sum[r + 1] - sum[l];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int num : sum) {
            sb.append(num).append(" ");
        }
        return sb.toString();
    }
}

