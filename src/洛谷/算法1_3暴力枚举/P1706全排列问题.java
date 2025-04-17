package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;

// 回溯：排列问题
// 洛谷：https://www.luogu.com.cn/problem/P1706

public class P1706全排列问题 {

    // 当 n == 9 时，内存超限
//    static List<List<Integer>> result = new ArrayList<>();
//    static LinkedList<Integer> path = new LinkedList<>();
//    static boolean[] used;
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        used = new boolean[n];
//
//        backTracking(n);
//
//        for (int i = 0; i < result.size(); i++) {
//            for (int j = 0; j < result.get(i).size(); j++) {
//                System.out.printf("%5d", result.get(i).get(j));
//            }
//            System.out.println();
//        }
//
//    }
//
//    public static void backTracking(int n) {
//        if (path.size() == n) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (!used[i-1]) {
//                path.add(i);
//                used[i-1] = true;
//
//                backTracking(n);
//
//                used[i-1] = false;
//                path.removeLast();
//            }
//        }
//
//    }


    // 改进：使用StringBuilder来存数据（有一个缺点，如果输入的 n >= 10 就会出错，因为Sb的长度到后面会一下加2个单位，但是我们只加了一个数）
    static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        used = new boolean[n];

        backTracking(n, new StringBuilder());

    }

    public static void backTracking(int n, StringBuilder sb) {
        if (sb.length() == n) {
            for (int i = 0; i < sb.length(); i++) {
                System.out.printf("%5d", sb.charAt(i) - '0');
            }
            System.out.println();
            return;
        }


        for (int i = 1; i <= n; i++) {

            if (!used[i - 1]) {
                used[i-1] = true;
                sb.append(i);

                backTracking(n, sb);

                used[i-1] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

        }

    }


}
