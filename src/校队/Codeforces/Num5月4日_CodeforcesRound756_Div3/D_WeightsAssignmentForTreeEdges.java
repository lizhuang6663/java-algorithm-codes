package 校队.Codeforces.Num5月4日_CodeforcesRound756_Div3;

import java.io.*;

// 权重，动态规划
// Codeforces:https://codeforces.com/contest/1611/problem/D
// 题解：https://codeforces.com/blog/entry/97288

public class D_WeightsAssignmentForTreeEdges {
    public static void main(String[] args) {
        int t = nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    public static void solve() {
        int n = nextInt();
        int[] b = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i < n + 1; i++) b[i] = nextInt();
        for (int i = 1; i < n + 1; i++) p[i] = nextInt();

        int[] dist = new int[n + 1];
        // 权重初始化
        for (int i = 1; i <= n; i++) dist[i] = -1;


        // p[1]：权重最小的点，也就是根节点；b[p[1]]：点p[1]的顶点应该是它自身
        // 如果1是根节点，那么权重最小的点应该是1，而且1的根节点是1，所以b[1] = 1；如果3是根节点，3的根节点应该是3，那么 b[3] = 3；
        // 因为 p[1] 是根节点，所以 b[p[1]] = p[1]
        if (b[p[1]] != p[1]) {
            out.println(-1);
            return;
        }

        // 给根节点的权重赋值
        dist[p[1]] = 0;
        for (int i = 2; i <= n; i++) {
            // 我们是按照 数组p 的顺序给权重赋值的，当循环到p[i] 时，p[i]的父节点（ p[i]的父节点：b[p[i]] ）的权重一定是被赋过值的（不是-1）
            // 如果发现p[i]的父节点权重是-1，那么说明给的b和p是错误的。
            if (dist[b[p[i]]] == -1) {
                out.println(-1);
                return;
            }

            // 元素p[i] 的权重要比 p[i-1] 的权重大
            dist[p[i]] = dist[p[i - 1]] + 1;
        }

        // 打印权重：根节点到子节点 - 根节点到父节点 = 父节点到子节点 -> dist[i] - dist[b[i]]
        for (int i = 1; i <= n; i++) {
            out.print(dist[i] - dist[b[i]] + " ");
        }
        out.println();
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
