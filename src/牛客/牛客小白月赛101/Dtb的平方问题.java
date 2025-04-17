package 牛客.牛客小白月赛101;

import java.util.Arrays;
import java.util.Scanner;

// 贡献，前缀和（数据结构不好理解）（好像是前缀和套前缀和）
// 假设[L,R]是满足题意的区间，那么这段区间对答案的贡献就是[L,R]上的所有答案+1。
// 由于 n 比较小，直接 O(n^2) 遍历所有区间，考虑贡献即可。计算的实现多种多样，包括但不限于差分树状数组、线段树、差分。我的代码中用的是差分树状数组
// 牛客：https://ac.nowcoder.com/acm/contest/90072/D

public class Dtb的平方问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = scanner.nextInt();
            pre[i] += pre[i - 1];
        }

        FenwickTree<Integer> FT = new FenwickTree<>(n);
        // 双重循环遍历所有可能的子区间，检查区间和是否为完全平方数。如果是，则更新 Fenwick Tree。
        for (int L = 1; L <= n; L++) {
            for (int R = L; R <= n; R++) {
                if (check(pre[R] - pre[L - 1])) {
                    FT.add(L, 1);
                    if (R < n) FT.add(R + 1, -1);
                }
            }
        }

        while (q-- > 0) {
            int x = scanner.nextInt();
            System.out.println(FT.sum(x));
        }
        scanner.close();
    }

    // 检查 x 是否为完全平方数。
    public static boolean check(int x) {
        int t = (int) Math.sqrt(x);
        return t * t == x;
    }

}

// 树状数组：提供一个高效的数据结构用于处理前缀和（Prefix Sum）查询和更新操作。
class FenwickTree<T extends Number> {
    private int n;
    private T[] a;

    @SuppressWarnings("unchecked")
    public FenwickTree(int _n) {
        this.n = _n;
        this.a = (T[]) new Number[_n + 1];
        Arrays.fill(a, (T) new Integer(0)); // Assuming T is Integer for initialization
    }

    // 计算 x 的最低位 1 的位置，便于在树状数组中进行操作。
    private int lowbit(int x) {
        return x & -x;
    }

    // 用于在位置 pos 增加值 v。通过循环更新所有受影响的节点。
    public void add(int pos, T v) {
        for (int i = pos; i <= n; i += lowbit(i)) {
            a[i] = (T) Integer.valueOf(a[i].intValue() + v.intValue());
        }
    }

    // 用于初始化树状数组的大小，并将所有元素设置为 val。
    public void init(int n, T val) {
        this.n = n;
        Arrays.fill(a, 0, n + 1, val);
    }

    // 计算从 1 到 x 的前缀和。通过迭代访问相应的树状数组节点。
    public T sum(int x) {
        T ans = (T) new Integer(0); // Assuming T is Integer
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans = (T) Integer.valueOf(ans.intValue() + a[i].intValue());
        }
        return ans;
    }

    // 计算区间和，从 l 到 r。利用前缀和的性质，得出结果。
    public T rangeSum(int l, int r) {
        return l <= r ? (T) Integer.valueOf(sum(r).intValue() - sum(l - 1).intValue()) : (T) new Integer(0);
    }
}
