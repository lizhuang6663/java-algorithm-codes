package common.homework;

import java.util.Scanner;


//求 mol 2 的值 （不能硬写）
//https://ac.nowcoder.com/acm/contest/68258/B?&headNav=acm

public class Num7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();

            if (k == 0) {
                System.out.println((r-l+1) % 2);
            }else {
                int num = r/2 - (l-1)/2;
                System.out.println(((r-l+1) - num) % 2);
            }


        }

    }
}

/*

输入：
2
1 2 1
2 5 2

输出：
1
0

 */