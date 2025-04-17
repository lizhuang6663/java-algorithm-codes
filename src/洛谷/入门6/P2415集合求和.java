package 洛谷.入门6;

import java.util.*;

// 集合求和
// 洛谷：https://www.luogu.com.cn/problem/P2415
// 首先要知道：所有的元素和乘以 2 的 元素的个数-1 次方 等于集合所有子集的和

public class P2415集合求和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] arr = new int[strings.length];

        long temp = 0;
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            temp += arr[i];
        }

        System.out.printf("%.0f", temp * Math.pow(2, arr.length - 1));

        scanner.close();
    }
}
