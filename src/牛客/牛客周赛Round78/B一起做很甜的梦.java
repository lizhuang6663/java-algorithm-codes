package 牛客.牛客周赛Round78;

import java.util.Scanner;

public class B一起做很甜的梦 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 错误：
//        int[] arr = new int[n];
//        int left = 1, right = n;
//        int indexLeft, indexRight;
//
//        if (n % 2 == 1) {
//            // 放在正中间
//            arr[n / 2 + 1 - 1] = n / 2 + 1;
//            indexLeft = n / 2 - 1;
//            indexRight = n / 2 + 1;
//        } else {
//            indexLeft = n / 2 - 1;
//            indexRight = n / 2;
//        }
//
//        int demo = 1;
//        while (left < right) {
//            if (demo > 0) {
//                // 左边加 left，右边加 right
//                arr[indexLeft] = left;
//                arr[indexRight] = right;
//            } else {
//                // 左边加 right，右边加 left
//                arr[indexLeft] = right;
//                arr[indexRight] = left;
//            }
//
//            indexLeft--;
//            indexRight++;
//            demo *= -1;
//            left++;
//            right--;
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }

        System.out.print(1);
        for (int i = n; i >1 ; i--) {
            System.out.print(" " + i);
        }
    }
}
