package 校队.校队题库;

import java.util.Scanner;

// 滑动窗口
public class P1017滑动窗口模板题双指针 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] arr1 = new long[n]; // 记录每个时刻的工作量
        long[] arr2 = new long[n]; // 记录每个时刻的工资
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }


        // 最终答案
        long maxSalary = Integer.MIN_VALUE;

        int left = 0, right = 0;
        for (; left <= right && left < n ; left++) {
            long workNum = 0;
            long moneyNum = 0;

            for (right = left; right < n; right++) {

                // 判断是否可以继续工作，如果不能就退出
                if (workNum + arr1[right] <= k) {
                    workNum += arr1[right];
                    moneyNum += arr2[right];
                    maxSalary = Math.max(maxSalary, moneyNum);
                }else {
                    break;
                }

            }
        }

        System.out.println(maxSalary < 0 ? 0 : maxSalary);
    }
}
