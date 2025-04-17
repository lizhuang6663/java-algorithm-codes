package 校队.Codeforces.Num4月27日_2023ICPC江西省大赛_正式比赛;

import java.io.*;
import java.util.Arrays;

// 差分数组（不理解）
// 题解：https://blog.csdn.net/Zhouwen_/article/details/130837864
// Codeforces:https://codeforces.com/gym/104385/problem/K

// 给出一个长度为n的不递增序列，两种操作，第一种是改变数据，第二种是将序列分为k段，每一段的有效值为该段中最大减去最小，求这k段的所有有效值的最小和。
// 题解：先求出每两个数之间的差，记录在数组b[n]中。
// 若为第一种操作，发现仅仅是交换b[x]和 b[x-1]; 若为第二种操作，发现只要在产生最大差值的中间进行分段，这个差值就会失效。所以假如要分成k段，那么只需要排序，去掉前k-1大的差值，剩下相加；这部分操作的时间复杂度为O(nlogn)
// 由于可能会进行m次查询，所以需要用前缀和进行预处理操作。

// 先只考虑询问操作，我们容易发现，当在 i 和 i + 1 中间分割开，ai 是前一段的最小值，ai+1 是后一段的最大值，那么对答案的贡献就是ai+1 − ai。
// 那么直接将差分数组排序，取前 k − 1 小即可。然后考虑修改操作，容易发现，这修改就是交换差分数组相邻的两个元素，那么对答案就没有本质影响。时间复杂度:O(n log n)
public class KSplit {
    public static void main(String[] args) {
        // 存储相邻两个元素的差值：比如：30 20 18 13 2， 30-18 == 30-20+20-18
        int n = nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n]; // b 存储 a中相邻两个元素的差值
        int[] sum = new int[n];   // sum 存储b的前缀和

        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }
        // 存储差值
        for (int i = 1; i < n; i++) {
            b[i] = a[i] - a[i+1];
        }

        Arrays.sort(b); // 给 b 排序

        // 优化，求前缀和
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + b[i];
        }

        int m = nextInt();
        for (int i = 0; i < m; i++) {
            int select = nextInt();
            if (select == 0) {
                nextInt();
            }else {
                int k = nextInt();
                k--;
                System.out.println(sum[n - 1 - k]);
            }
        }
    }

    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    private static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static double nextDouble() {
        try {
            st.nextToken();
            return (double) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Long nextLong() {
        try {
            st.nextToken();
            return (long) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String next() {
        try {
            st.nextToken();
            return st.sval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
