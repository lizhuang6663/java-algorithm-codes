package 校队.Num5月5日_牛客周赛Round41;

import java.util.Scanner;

// 数组
// 牛客：https://ac.nowcoder.com/acm/contest/80742/B

public class B小红的排列构造 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (k > n || k == 1) {
            System.out.println(-1);
            return;
        }

        int[] result = new int[n];
        for (int i = 0; i < n - k; i++) {
            result[i] = arr[i];
        }

        int temp = 0;
        for (int i = n - k; i < n; i++) {
            if (i == n - k) temp = arr[i];

            if (i == n - 1) {
                result[i] = temp;
            } else {
                result[i] = arr[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

    }
}

/*

3 3
2 3 1


 */