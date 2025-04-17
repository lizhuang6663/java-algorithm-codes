package 校队.Codeforces.Num4月25日_2022年中国大学生程序设计竞赛女生专场;

import java.io.IOException;
import java.io.*;

// 模拟（不是很明白）
// Codeforces：https://codeforces.com/gym/104081/problem/E

public class E睡觉{
    public static void main(String[] args) throws IOException {
        int o = nextInt();
        for (int i = 0; i < o; i++) {
            solve();
        }
        out.flush();
    }

    static void solve() {
        int x = nextInt();
        int t = nextInt();
        int k = nextInt();
        int n = nextInt();
        int d = nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }

        int xc = x, time = 0;
        boolean ok = false;
        for (int i = 0; i < n * n; i++) {
            // 清醒度
            if (nums[i % n] <= d) xc--;
            else xc++;

            // 次数
            if (xc <= k) time++;
            else time = 0;
            if (time >= t) {
                ok = true;
                break;
            }

            // 第一轮结束了，而且清醒度下降了，只要经过一定的轮数，就会有足够小的x
            if (i == n - 1 && xc < x) {
                ok = true;
                break;
            }
        }

        if (ok || time > n * 2)// time>n*2代表时间无限。因为它持续2轮都满足清醒度<=k,那么无限时间内一定可以
            out.println("YES");
        else
            out.println("NO");
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

    private static double next() {
        try {
            st.nextToken();
            return st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}





// 思路：主要是分情况讨论。我们经过一次循环，可以得到一个数字x1，由x1和原来的x的大小情况分类：
//（1）x1小于x，说明每经过一首歌的影响，x都会减小，那么一定存在若干遍后，x小到满足条件；
//（2）x1大于x，说明每经过一首歌的影响，x都会变大，那若存在满足情况的区间，那一定是在第一个区间最有可能满足条件，只需要在第一个区间内判断一下即可。
//（3）x1等于x，这样可以想到原来x的性质，如果原来是大于k的，那情况和第二种情况类似，判断第一个区间即可；但是若是原来是等于k的，
// 那极有可能第一段满足条件的区间和最后一段满足条件的区间的和是满足大于等于t的，所以要处理连续两个区间，当然要注意t的大小，如果t是大于等于n的，那必须两个个区间内的最大值要大于n才行。

// 案例出现错误
//public class E睡觉 {
//    public static void P24多路归并Ⅱ(String[] args) throws Exception {
//        Read scanner = new Read();
//        int T = scanner.nextInt();
//
//        while (T-- > 0) {
//            int x = scanner.nextInt();
//            int t = scanner.nextInt();
//            int k = scanner.nextInt();
//            int n = scanner.nextInt();
//            int d = scanner.nextInt();
//
//            x -= k;
//            int original = x;
//            int cnt = 0, max = -1;
//            int[] a = new int[2 * n + 1];
//
//            for (int i = 1; i <= n; i++) {
//                a[i] = scanner.nextInt();
//                if (a[i] <= d) a[i] = -1;
//                else a[i] = 1;
//                a[i + n] = a[i];
//                x += a[i];
//
//                if (x <= 0) cnt++;
//                else cnt = 0;
//
//                max = Math.max(max, cnt);
//            }
//
//            // 情况1:
//            if (x < original) {
//                System.out.println("YES");
//                continue;
//            }
//
//            // 情况2:
//            if (x > original) {
//                System.out.println(max >= t ? "YES" : "NO");
//                continue;
//            }
//
//            if (original > 0) {
//                System.out.println(max >= t ? "YES" : "NO");
//                continue;
//            }
//
//            // 情况3:
//            List<Integer> list = new ArrayList<>();
//            x = original;
//            cnt = 0;
//
//            for (int i = 1; i <= n; i++) {
//                x += a[i];
//                if (x <= 0) {
//                    cnt++;
//                } else {
//                    list.add(cnt);
//                    max = Math.max(cnt, max);
//                    cnt = 0;
//                }
//            }
//            list.add(cnt);
//            max = Math.max(cnt, max);
//
//            list.add(list.get(0) + list.get(list.size() - 1));
//            t = Math.min(t, n);
//            System.out.println(max >= t ? "YES" : "NO");
//        }
//    }
//}

