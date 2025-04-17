package 校队.Codeforces.Num5月4日_CodeforcesRound756_Div3;

import java.io.*;

// 思维
// codeforces:https://codeforces.com/contest/1611/problem/C

public class C_PolycarpRecoversthePermutation {
    // 最大元素总是最后添加的，因此如果它不在第一个或最后一个位置，就没有答案。
    // 让我们来证明，如果最大元素位于排列的第一或最后一个位置，那么经过 n 次操作后，我们可以得到一个扩展排列。
    // 事实上，最大值元素将最后添加到所需的末尾，而所有其他元素将以相反的顺序添加。然后，如果答案存在，只需展开排列即可。
    public static void main(String[] args) {
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    public static void solve() {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        int end = 0, begin = 0, max = 0;
        if (arr[0] > arr[n - 1]) {
            end = n - 1;
            begin = 1;
            max = arr[0];
        } else {
            end = n - 2;
            begin = 0;
            max = arr[n - 1];
        }

        if (max != n) {
            out.println(-1);
            return;
        }

        for (int i = end; i >= begin; i--) {
            out.print(arr[i] + " ");
        }
        out.println(max);


         /*

        改良：将max加到前面或者后面都可以
         if (a[0] != n && a[n - 1] != n)
                cout << -1 << endl;
            else {
                for (int i = n - 1; i >= 0; i--)
                    cout << a[i] << " ";
                cout << endl;

         */
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
