package 蓝桥杯.第13届;

import java.util.Arrays;
import java.util.Scanner;

// 条件判断
// 蓝桥杯：https://www.lanqiao.cn/problems/2143/learning/

public class MainD最少刷题数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] copyarr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            copyarr[i] = arr[i];
        }
        Arrays.sort(copyarr); //将新的复制数组进行排序

        int median = copyarr[copyarr.length / 2]; // 中间值
        int[] result = new int[arr.length]; // 存放最终的结果

        int bigger = 0; // 比中间值大的数有多少
        int smaller = 0; // 比中间值小的数有多少

        // 找出比中间值大的数有多少 比中间值小的数有多少
        for (int i = 0; i < arr.length; i++) {
            if (copyarr[i] > median) {
                bigger++;
            } else if (copyarr[i] < median) {
                smaller++;
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (arr[i] < median) {
                if (bigger >= smaller) { // 大的数比较多，需要多加1超过中间值
                    result[i] = median - arr[i] + 1;
                } else {
                    result[i] = median - arr[i];
                }

            } else if (arr[i] == median) { // 这是中间值

                if (bigger > smaller) { // 大于就加1
                    result[i] = 1;
                } else { // 如果 <= 就是0，不用变化
                    result[i] = 0;
                }

            } else { // 不用增加
                result[i] = 0;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        scanner.close();
    }

}


/*

5
10 10 10 10 10
0 0 0 0 0

4
10 11 12 13
2 1 0 0

6
10 11 12 13 14 15
3 2 1 0 0 0

6
10 12 12 12 14 15
3 1 1 1 0 0

6
10 10 10 10 12 13
1 1 1 1 0 0

 */