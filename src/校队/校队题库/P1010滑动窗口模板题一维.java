package 校队.校队题库;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 一维滑动窗口
public class P1010滑动窗口模板题一维 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int left =0, right = k-1;

        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        while (right < arr.length) {

            // 如果循环刚开始，或者在这轮离开的left元素是最小值或者最大值就重新比较（如果不分情况的比较就会时间超限）
            if (left == 0 || arr[left-1] == max || arr[left-1] == min) {
                 max = Integer.MIN_VALUE;
                 min = Integer.MAX_VALUE;
                for (int i = left; i <= right ; i++) {
                    max = Math.max(max, arr[i]);
                    min = Math.min(min, arr[i]);
                }

            } else {
                max = Math.max(max, arr[right]);
                min = Math.min(min, arr[right]);
            }

            maxList.add(max);
            minList.add(min);

            left++;
            right++;
        }

        for (int i = 0; i < maxList.size(); i++) {
            System.out.print(maxList.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < minList.size(); i++) {
            System.out.print(minList.get(i) + " ");
        }


    }
}