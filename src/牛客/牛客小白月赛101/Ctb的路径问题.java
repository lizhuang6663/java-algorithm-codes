package 牛客.牛客小白月赛101;

import java.util.Scanner;

// 找规律：分别试一试当 n = 1，2，3，4，5，6，7 的时候就可以得出规律了
// 最近的走法就是从[1,1] 走到[2,2]，然后跳到[2k−2,2k]。再加上几个 n 比较小的时候的特判即可
// 牛客：https://ac.nowcoder.com/acm/contest/90072/C

public class Ctb的路径问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if ( n == 1) {
            System.out.println(0);
        } else if (n == 2) {
            System.out.println(2);
        } else if (n == 3) {
            System.out.println(4);
        }else {
            if (n % 2 == 0) { // 偶数
                System.out.println(4);
            }else { // 奇数
                System.out.println(6);
            }
        }

    }
}

