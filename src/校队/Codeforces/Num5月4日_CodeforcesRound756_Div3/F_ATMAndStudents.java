package 校队.Codeforces.Num5月4日_CodeforcesRound756_Div3;

import java.io.*;

// 前缀和，段落树 时间复杂度O(n*logn)（没看懂）
// Codeforces:https://codeforces.com/contest/1611/problem/F
// 题解：https://codeforces.com/blog/entry/97288

/*

#include "iostream"
#include "vector"

using namespace std;

typedef long long ll;

#define forn(i, n) for (int i = 0; i < int(n); i++)

vector<ll> t, a;
ll s, tl;

const ll MAX = 1000000000000000LL;

void build(int v, int l, int r) {
    if (l == r)
        t[v] = a[l];
    else {
        int m = (l + r) / 2;
        build(v * 2, l, m);
        build(v * 2 + 1, m + 1, r);
        t[v] = min(t[v * 2], t[v * 2 + 1]);
    }
}

void update(int v, int l, int r) {
    if (l == r)
        t[v] = MAX;
    else {
        int m = (l + r) / 2;
        if (tl <= m)
            update(v * 2, l, m);
        else
            update(v * 2 + 1, m + 1, r);
        t[v] = min(t[v * 2], t[v * 2 + 1]);
    }
}

int lower_bound_s(int v, int l, int r) {
    if (r < tl || (l == r && s < -t[v])) {
        return -1;
    }
    if (l == r || -t[v] <= s) {
        return r;
    }
    int m = (l + r) / 2;

    if (m < tl) {
        return lower_bound_s(2 * v + 1, m + 1, r);
    }
    if (s < -t[2 * v]) {
        return lower_bound_s(2 * v, l, m);
    }
    int res = lower_bound_s(2 * v + 1, m + 1, r);
    return (res == -1) ? m : res;
}


int P24多路归并Ⅱ() {
    int tests;
    cin >> tests;
    forn(tt, tests) {
        int n;
        cin >> n >> s;

        t = vector<ll>(4 * n);
        a = vector<ll>(n);

        forn(i, n) {
            cin >> a[i];
        }
        for (int i = 1; i < n; ++i) {
            a[i] += a[i - 1];
        }

        build(1, 0, n - 1);

        int first = -1, second = -2;
        for (tl = 0; tl < n; ++tl) {
            int v = lower_bound_s(1, 0, n - 1);
            if (v != -1 && v - tl > second - first) {
                first = tl + 1;
                second = v + 1;
            }
            s -= a[tl];
            if (tl != 0) s += a[tl - 1];
            update(1, 0, n - 1);
        }

        if (first == -1) {
            cout << -1;
        } else {
            cout << first << " " << second;
        }
        cout << endl;
    }
}

 */


public class F_ATMAndStudents {
    public static void main(String[] args) {

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
