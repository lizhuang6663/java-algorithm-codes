package 牛客.牛客小白月赛101;

import java.util.Scanner;

// 时间：2024-09-20 19:00:00 至 2024-09-20 21:00:00

// 前缀和、或者滑动窗口
// 牛客：https://ac.nowcoder.com/acm/contest/90072/A
// 题解：https://blog.nowcoder.net/n/2a0a84f6479340119592ebc2abc27235?f=comment

public class Atb的区间问题 {
    // 方法一：前缀和
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//
//        int[] prefix = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            prefix[i] = prefix[i - 1] + arr[i - 1];
//        }
//
//        int len = n - k;
//        int max = 0;
//        for (int i = len; i <= n; i++) {
//            max = Math.max(prefix[i] - prefix[i - len], max);
//        }
//        System.out.println(max);
//    }


    // 代码简化
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] pre = new int[n + 1];
        int len = n - k;

        int max = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = scanner.nextInt() + pre[i - 1];
            if (i >= len) {
                max = Math.max(max, pre[i] - pre[i - len]);
            }
        }
        System.out.println(max);
    }

    // 方法二：滑动窗口
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//
//        int[] nums = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//
//        int l=n-k-1;
//        int res=0;
//        int i=0;
//        int j=l;
//        int max=0;
//        for(int m=i;m<=j;m++){
//            max+=nums[m];
//        }
//
//        while(++j<n){
//            max+=nums[j];
//            max-=nums[i];
//            i++;
//            res=Math.max(res, max);
//        }
//        System.out.println(res);
//    }

}


// 为什么这样写错了？原因是：如果按照这样写的话， 999 999 0 0 1000，删除2个数据后，最大值应该是1000，但是最大值应该是 999+999
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        long[] arr = new long[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//
//        long sum = 0;
//        int left = 0, right = arr.length - 1;
//
//        for (int i = 0; i < k; i++) {
//            if (arr[left] >= arr[right]) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//
//        for (int i = left; i <= right; i++) {
//            sum += arr[i];
//        }
//        System.out.println(sum);
//    }
