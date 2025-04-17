package 洛谷.蓝桥杯;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 在洛谷上应该使用dp，否则最后一个案例无法通过
// 洛谷、蓝桥杯：https://www.lanqiao.cn/problems/1447/learning/

public class P8742砝码称重 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Set<Integer> result = new HashSet<>();
        result.add(0);

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();

            Set<Integer> set = new HashSet<>();

            for (int t : result) {
                set.add(t + temp);
                set.add(Math.abs(t - temp));
            }

            result.addAll(set);
        }

        result.remove(0); // 重要：删除0
        System.out.println(result.size());

    }
}
