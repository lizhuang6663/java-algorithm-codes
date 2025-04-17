package 洛谷.六期.第二周练习;

import java.io.*;

// 差分、快速读入
// 洛谷：https://www.luogu.com.cn/problem/P2367?contestId=162817


public class P2367语文成绩 {
    public static void main(String[] args) throws Exception {
        // 最后一个案例内存超限：换成占用内存小的读入：StreamTokenizer 类通常占用的内存要比 Scanner 类小，但是没有Scanner快
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int p = scanner.nextInt();
//
//        // 前缀和数组（原数组）
//        int[] arr = new int[n + 1];
//        // 差分数组
//        int[] difference = new int[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            arr[i] = scanner.nextInt();
//
//            // 前缀和转为差分数组
//            difference[i] = arr[i] - arr[i - 1];
//        }
//
//
//        // 给差分数组增减分数
//        for (int i = 1; i <= p; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            int z = scanner.nextInt();
//
//            // 在范围 x 到 y 中增减分数
//            difference[x] += z;
//            if (y + 1 <= n) difference[y + 1] -= z;
//        }
//
//        int result = Integer.MAX_VALUE;
//        // 差分数组转换为前缀和
//        for (int i = 1; i <= n; i++) {
//            arr[i] = arr[i - 1] + difference[i];
//            result = Math.min(result, arr[i]);
//        }
//
//        System.out.println(result);
//        scanner.close();


        // 或者直接使用自定义的 Read2 类
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int p = (int) st.nval;

        // 前缀和数组（原数组）
        int[] arr = new int[n + 1];
        // 差分数组
        int[] difference = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st.nextToken();
            arr[i] = (int) st.nval;

            // 前缀和转为差分数组
            difference[i] = arr[i] - arr[i - 1];
        }

        // 给差分数组增减分数
        for (int i = 1; i <= p; i++) {
            st.nextToken();
            int x = (int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            st.nextToken();
            int z = (int) st.nval;

            // 在范围 x 到 y 中增减分数
            difference[x] += z;
            if (y + 1 <= n) difference[y + 1] -= z;
        }

        int result = Integer.MAX_VALUE;
        // 差分数组转换为前缀和
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + difference[i];
            result = Math.min(result, arr[i]);
        }

        System.out.println(result);
    }
}
