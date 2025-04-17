package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;


// 洛谷：https://www.luogu.com.cn/problem/P1088
// 相似题目，代码随想录And力扣.力扣：下一个排列：https://leetcode.cn/problems/next-permutation/


public class P1088火星人 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        for (int i = 0; i < m; i++) {
            // 找到第一个数1
            int left = arr.length-2;
            while (left >= 0 && arr[left] >= arr[left+1]) {
                left--;
            }

            // 找到第二个数
            int right = arr.length-1;
            if (left >= 0 ) {
                while (right >= 0 && arr[right] <= arr[left]) {
                    right --;
                }

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            reverse(arr, left+1);
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }



    // 反转数组的后部分
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


}
