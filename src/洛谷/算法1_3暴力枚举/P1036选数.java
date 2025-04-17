package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;

// dfs
// 洛谷：https://www.luogu.com.cn/problem/P1036

public class P1036选数 {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        dfs(arr, 0, k, 0);
        System.out.println(ans);
    }


    /**
     * @param arr
     * @param num        还需要几个数
     * @param startIndex
     * @param total      现在的总和
     */
    public static void dfs(int[] arr, int startIndex, int num, int total) {
        if (num == 0 && judgePrime(total)) {
            ans++;
//            System.out.println(total);
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {

            dfs(arr, i + 1, num-1, total + arr[i]);

        }

    }


    public static boolean judgePrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
