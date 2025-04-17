package 蓝桥杯.第13届;

import java.util.Scanner;

// 数组
// 蓝桥杯：https://www.lanqiao.cn/problems/2142/learning/

public class MainC字符统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int [] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A'] ++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                result.append((char) (i + 'A'));
            }
        }

        System.out.println(result);

        scanner.close();
    }
}


/*

AABBCCCC

 */