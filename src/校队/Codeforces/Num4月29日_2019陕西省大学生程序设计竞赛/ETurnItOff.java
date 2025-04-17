package 校队.Codeforces.Num4月29日_2019陕西省大学生程序设计竞赛;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 二分法（暴力）
// Codeforces:https://codeforces.com/gym/104460/problem/E

public class ETurnItOff {
    // 方法一：暴力：记录一下字符串里面1的数量num，如果num比可以关的次数小或者等于，那么就直接输出1，
    // 否则根据让 num/k 向上取整，这样就得到了一个最小的区间长度min，使用这个区间长度遍历，看是否能遍历完，不能就让min++，直到可以为止。
//    public static void P24多路归并Ⅱ(String[] args) {
//        int T = nextInt();
//        for (int i = 0; i < T; i++) {
//            int n = nextInt();
//            int k = nextInt();
//            char[] chars = next().toCharArray();
//
//            int num = 0;
//            // 统计灯开启的数量
//            for (int j = 0; j < n; j++) {
//                if (chars[j] == '1') num++;
//            }
//            // 当 num <= k 的时候，肯定可以把灯全部关闭，所以L取最小，取1，
//            if (num <= k) {
//                out.println(1);
//                continue;
//            }
//
//            // 找到末尾为1的地方
//            for (int j = n - 1; j >= 0; j--) {
//                if (chars[j] == '1') break;
//                n--;
//            }
//
//            // 向上取整（这是最小的值，然后不断++，找到合适的情况）
//            int min = (int) Math.ceil(1.0 * num / k);
//            while (true) {
//                int j = 0;
//                int cnt = 0; // 实际用的次数
//
//                while (j < n) { // j:开头，n:结尾
//                    if (chars[j] == '0') {
//                        j++;
//                        continue;
//                    }
//
//                    if (chars[j] == '1') {
//                        cnt++;
//                        j += min;
//                    }
//                    // 关灯的次数到了
//                    if (cnt == k) break;
//                }
//                if (j >= n) break; // 找到合适的L了
//                min++;
//            }
//            out.println(min);
//        }
//        out.flush();
//    }



    // 方法二：二分法，时间复杂度O(nlogn)
    // 二分L，每次操作令i为最左边亮着的灯的下标
    static int n, k;
    static char[] chars;

    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            n = nextInt();
            k = nextInt();
            String s = next();
            chars = (" " + s).toCharArray(); // chars 要从1开始，不能从0开始

            int left = 1, right = n;
            // 二分L
            while (left < right) {
                int mid = (left + right) >> 1;
                // L=mid，一共需要count次，如果count<=k，说明次数够了，把L缩小；如果count>k，说明次数不够，这时候就要把L扩大了
                // 当 mid = 0的时候，在check()方法里面会死循环，所以left不能从0开始，要从1开始
                if (check(mid)) {
                    right = mid ;
                } else {
                    left = mid + 1;
                }
            }
            out.println(left);
        }
        out.flush();
    }

    public static boolean check(int L) {
        int count = 0;
        // 从1开始
        for (int i = 1; i <= n; ) {
            // 位置 i 的灯是亮的，进行关灯操作
            if (chars[i] == '1') {
                count++;
                i += L;
            } else {
                i++;
            }
        }
        // 返回使用的次数是否大于k
        return count <= k;
    }


    static OutputStream outputStream = System.out;
    static PrintWriter out = new PrintWriter(outputStream);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
    static StringTokenizer tokenizer = null;

    static String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    static String nextLine() {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static Double nextDouble() {
        return Double.parseDouble(next());
    }

    static BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

}
