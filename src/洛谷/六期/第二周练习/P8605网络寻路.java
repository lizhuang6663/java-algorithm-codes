package 洛谷.六期.第二周练习;

import java.util.Scanner;

// 洛谷，蓝桥杯：https://www.luogu.com.cn/problem/P8605?contestId=162817

public class P8605网络寻路 {

    // 方法一：回溯，运行时错误，内存超限
//    static List<Integer>[] data; // 存数据
//    static boolean[] used; // 节点不能重复使用
//    static long ans = 0;
//    static int begin; // 每一种情况的开头是什么
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        data = new List[n + 1];
//
//        used = new boolean[n + 1]; // 代表着 1-n 个节点
//        for (int i = 0; i < m; i++) {
//            int n1 = scanner.nextInt();
//            int n2 = scanner.nextInt();
//
//            if (data[n1] == null) {
//                data[n1] = new ArrayList<>();
//            }
//            if (data[n2] == null) {
//                data[n2] = new ArrayList<>();
//            }
//
//            data[n1].add(n2);
//            data[n2].add(n1);
//        }
//
////        for (int i = 1; i < data.length; i++) {
////            for (int j = 0; j < data[i].size(); j++) {
////                System.out.println((i ) + "   " + data[i].get(j) + " ");
////            }
////        }
//
//        for (int i = 1; i <= n; i++) {
//            used[i] = true;
//            begin = i;
//
//            backTracking(i, 1);
//
//            used[i] = false;
//        }
//
//        System.out.println(ans);
//    }
//
//
//    /**
//     * @param now 当前走到的元素值
//     * @param len 现在的长度
//     */
//    public static void backTracking(int now, int len) {
//        if (len == 4) {
//            ans++;
//            return;
//        }
//
//        for (int i = 0; i < data[now].size(); i++) {
//            int temp = data[now].get(i);
//
//            if (!used[temp]) {
//                used[temp] = true;
//
//                backTracking(temp, len + 1);
//
//                used[temp] = false;
//
//            } else if (len == 3 && temp == begin) { // 就差最后一个元素了，但是要记得，之前的开头的元素我们已经把它标记为true了，这时候我们就要手动的判断：当长度为3时，是否可以找到begin元素，如果可以找到这一轮循环就成功了
//                backTracking(temp, len+1);
//            }
//
//        }
//    }


    // 方法二：https://www.luogu.com.cn/problem/solution/P8605
    static final int MAXN = 10010;
    static final int MAXM = 100010;

    static int[] d = new int[MAXN];
    static int[] u = new int[MAXM];
    static int[] v = new int[MAXM];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long ans = 0;
        for (int i = 0; i < m; i++) {
            u[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
            d[u[i]]++;
            d[v[i]]++;
        }

        for (int i = 0; i < m; i++) {
            if (d[u[i]] > 1 && d[v[i]] > 1) {
                ans += (long) (d[u[i]] - 1) * (d[v[i]] - 1) * 2;
            }
        }
        System.out.println(ans);
    }

}
