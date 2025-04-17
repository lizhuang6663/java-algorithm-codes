package 牛客.winterVacation.num1;

import java.util.*;

// 牛客寒假1：https://ac.nowcoder.com/acm/contest/67741/G
// 点外卖最大优惠

public class MainG {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();

            ArrayList<int[]> list = new ArrayList();
            for (int i = 0; i < n; i++) {
                list.add(new int[]{scan.nextInt(), scan.nextInt()});
            }

            // 使用了 Comparator.comparing 方法来创建一个比较器，它的参数是一个 lambda 表达式 (s -> s[0])。
            // 这个 lambda 表达式的作用是接受一个整数数组 s，并返回该数组的第一个元素，即 s[0]。
            // 因此，Comparator.comparing(s -> s[0]) 的含义是按照数组的第一个元素来比较数组。
            // 这样，Collections.sort 方法就会根据每个数组的第一个元素进行排序，根据每个数组的第一个元素从小到大排序
            Collections.sort(list, Comparator.comparing(s -> s[0]));

            long c = 0;
            long x = m;

            for (int[] a : list) {
                c += a[1];
                if (a[0] <= c + m)  x = m + c;
            }

            System.out.println(x);
        }
    }
}

/*

4
1 10
100 80
2 10
30 10
100 90
3 10
100 30
100 30
100 30
2 10
21 10
1000 1

 */
