package 牛客.牛客周赛Round78;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 思维：判断有多少列元素相同
// https://ac.nowcoder.com/acm/contest/100671/C

public class C翻之 {
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] s = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        for (int i = 0; i < m; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < n; j++) {
                t.append(s[j].charAt(i));
            }
            map.put(t.toString(), map.getOrDefault(t.toString(), 0) + 1);
        }

        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }

        out.println(max);
        out.flush();
        out.close();
    }

    static Kattio sc = new Kattio();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static class Kattio {
        static BufferedReader r;
        static StringTokenizer st;

        public Kattio() {
            r = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            char[] str = next().toCharArray();
            int i = 0;
            boolean neg = false;
            if (str[0] == '-') {
                i = 1;
                neg = true;
            }
            int ans = 0;
            for (; i < str.length; i++) ans = ans * 10 + (str[i] - '0');
            return neg ? -ans : ans;
        }

        public long nextLong() {
            char[] str = next().toCharArray();
            int i = 0;
            boolean neg = false;
            if (str[0] == '-') {
                i = 1;
                neg = true;
            }
            long ans = 0;
            for (; i < str.length; i++) ans = ans * 10 + (str[i] - '0');
            return neg ? -ans : ans;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}


