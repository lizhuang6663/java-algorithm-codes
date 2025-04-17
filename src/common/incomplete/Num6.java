package common.incomplete;

import java.util.*;

// 买饮料
// 校队：https://ac.nowcoder.com/acm/contest/75588/C
// 计算由数组 x 中元素组成的所有子集中，元素之和小于等于 m 的子集的个数

public class Num6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long ans = 0;
        // n 个元素自由搭配可以形成 2^n 种结果
        for (int i = 0; i < (1 << n); i++) {
            long res = 0;

            // n 种饮料
            for (int j = 0; j < n; j++) {
                //(i >> j)：将 i 向右移动 j 位，这样可以将 i 的第 j 位移到最低位。
                //(1 & (i >> j))：将结果与 1 进行按位与运算，这样只保留了 i 的第 j 位，其他位都置为了 0。
                //如果 (1 & (i >> j)) 的结果为 1，则表示 i 的第 j 位为 1，那么就将 a[j] 加到 res 中。
                //这段代码主要用于遍历一个二进制数 i 的每一位，根据每一位的值来决定是否将对应位置的 a[j] 加到 res 中。

                System.out.print("i = " + i + " j = " + j + "   ");
                System.out.println("i >> j : " + (i >> j));
                System.out.println(1 & (i >> j));

                if ((1 & (i >> j)) == 1) {
                    res += a[j];
                }
            }

            // 如果 花费的钱数res <= 拥有的钱数m，ans++
            if (res <= m) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
