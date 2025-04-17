package 码蹄集.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;


// 暴力，或者 dfs

public class MC0116水往低处流 {
    // 只需要找到上下左右四个格子的高度都 <= 当前这个格子的高度，然后++

    // 方法一：暴力，求出不需要浇水的格子数量
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[][] arr = new int[n][n];
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = scanner.nextInt();
//            }
//        }
//
//        // 找出不需要浇水的格子的数量
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if (i > 0 && arr[i - 1][j] > arr[i][j]) {
//                    count++;
//                } else if (i < n - 1 && arr[i + 1][j] > arr[i][j]) {
//                    count++;
//                } else if (j > 0 && arr[i][j - 1] > arr[i][j]) {
//                    count++;
//                } else if (j < n - 1 && arr[i][j + 1] > arr[i][j]) {
//                    count++;
//                }
//            }
//        }
//
//        System.out.println(n * n - count);
//    }


    // -----------------------------------------------------------------------------------------------------------------


    // 方法二：直接求出最高点（内存超限了，有一个案例无法通过）
    static int count = 0;// 最高点的数量

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
//        Scanner scanner = new Scanner(System.in);
        int n = (int) st.nval;

        int[][] arr = new int[n + 2][n + 2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                st.nextToken();
                arr[i][j] = (int) st.nval;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                dfs(arr, i, j);

            }
        }

        System.out.println(count);
    }

    // 判断这个点的四周是否还有比当前这个点更高的格子；返回false说明不是最高点，返回true说明是最高点
    public static void dfs(int[][] arr, int i, int j) {
        int now = arr[i][j];

        if (now >= arr[i - 1][j] && now >= arr[i + 1][j] && now >= arr[i][j - 1] && now >= arr[i][j + 1]) {
            count++;
        }

    }


}
