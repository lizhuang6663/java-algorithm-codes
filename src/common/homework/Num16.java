package common.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 牛客周赛：找中位数：https://ac.nowcoder.com/acm/contest/73422/D
public class Num16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = b[i] = sc.nextInt();
        }

        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            double ans = 0;

            if (n % 2 == 0) {
                // 前提 b 是有序的
                // 如果有偶数个元素，这时有两个中间元素
                // b[n/2 - 1]，b[n/2] 分别是中间的两个元素的左边和右边
                // 此时将删除的元素的大小 和 b[n/2] 比较
                // 如果 大于 b[n/2]，那么我们只能选择b[n/2 - 1]（因为b[n/2 - 1]在b[n/2]的左边，这时候删除一个元素，b[n/2 - 1]就在最中间了）
                // 如果小于，那么我们只能选择b[n/2]
                // 如果等于那么我们只能选择 b[n/2 - 1]
                //（注意是要删除的是a中的元素，b的位置是有序的，元素个数没有变，中位数只能在b[n/2 - 1]和b[n/2]中选择）
                ans = a[i] < b[n / 2] ? b[n / 2] : b[n / 2 - 1];
            } else {
                // 如果有奇数个元素
                // b[n / 2]是最中间的元素
                // 将要删除的元素和b[n / 2] 比较
                // 如果大于 b[n / 2]，那么中位数就是 (b[n/2-1] + b[n/2]) / 2
                // 如果小于 b[n / 2]，那么中位数就是 (b[n/2] + b[n/2+1]) / 2
                // 如果等于b[n / 2]，那么中位数就是 (b[n/2-1] + b[n/2+1]) / 2

                // 如果还是不能理解，可以画图了解
                if (a[i] < b[n / 2]) {
                    ans = (b[n / 2] + b[n / 2 + 1]) / 2.0;

                } else if (a[i] == b[n / 2]) {
                    ans = (b[n / 2 - 1] + b[n / 2 + 1]) / 2.0;

                } else {
                    ans = (b[n / 2 - 1] + b[n / 2]) / 2.0;
                }

            }
            System.out.printf("%.1f\n", ans);
        }

    }
}