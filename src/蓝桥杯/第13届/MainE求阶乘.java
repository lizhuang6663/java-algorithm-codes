package 蓝桥杯.第13届;

import java.util.Scanner;

// 二分，数学
// 蓝桥杯：https://www.lanqiao.cn/problems/2145/learning/

public class MainE求阶乘 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();

        long l = 0, r = Long.MAX_VALUE - 1;
        long mid;

        // 因为要找最小的，所以就算找到了mid也不能退出 while 循环
        while (l < r) {
            mid = l + ((r - l) >> 1);

            if (cacl(mid) >= k) {//如果mid的阶乘的0数大于等于k
                r = mid;//如果mid的阶乘的0数大于等于k
            } else {
                l = mid + 1;//并且这里想让while循环中止就要不得不+1
            }
        }

        if (cacl(r) == k) {
            System.out.println(r);
        } else {
            System.out.println(-1);
        }

        scanner.close();
    }


    // 求n的阶乘后边有多少个0（要看有多少个0，只需要看有几个5）
    public static long cacl(long n) {
        long res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

}
