package 蓝桥杯.C加加B组第15届;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class E宝石组合 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long[] arr = new long[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextLong();
//        }
//
//        // 排序
//        Arrays.sort(arr);
//
//        long resA = 0, resB = 0, resC = 0;
//        long result = Long.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j+1; k < n; k++) {
//                    long a = arr[i];
//                    long b = arr[j];
//                    long c = arr[k];
//                    long demo = a * b * c * (help2(a, b, c)) / (help1(a, b) * help1(a, c) * help1(b, c));
//
//                    if (result < demo) {
//                        resA = a;
//                        resB = b;
//                        resC = c;
//                        result = demo;
//                    }
//                }
//            }
//        }
//
//        System.out.printf("%d %d %d\n", resA, resB, resC);
//        scanner.close();
//    }
//
//
//    public static long help1(long a, long b) {
//        for (long i = Math.max(a, b); i <= a * b; i++) {
//            if (i % a == 0 && i % b == 0) {
//                return i;
//            }
//        }
//        return a * b;
//    }
//
//    public static long help2(long a, long b, long c) {
//        for (long i = Math.max(a, Math.max(b, c)); i <= a * b * c; i++) {
//            if (i % a == 0 && i % b == 0 && i % c == 0) {
//                return i;
//            }
//        }
//        return a * b * c;
//    }
//
//}

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

// 不理解：
public class E宝石组合 {
    static final int h = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> mp = new HashMap<>();

        // 读取输入并计数
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            mp.put(t, mp.getOrDefault(t, 0) + 1);
        }

        // 从h到1寻找答案
        for (int i = h; i >= 1; i--) {
            int ans = 0;
            ArrayList<Integer> num = new ArrayList<>();

            for (int j = i; j <= h; j += i) {
                if (mp.containsKey(j)) {
                    ans += mp.get(j);
                    for (int k = 0; k < mp.get(j); k++) {
                        num.add(j);
                    }
                }
                if (ans >= 3) {
                    for (int k = 0; k < 3; k++) {
                        System.out.print(num.get(k) + " ");
                    }
                    System.out.println();
                    return;
                }
            }
        }
        scanner.close();
    }
}
