package 校队.Codeforces.Num5月4日_CodeforcesRound756_Div3;

import java.util.Scanner;

/*

    Codeforces Round 756 (Div. 3):https://codeforces.com/contest/1611
    题解：https://codeforces.com/blog/entry/97288

 */

// 签到题
public class A_MakeEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            int index = -1;

            // 找到最后一个偶数位置索引
            for (int j = 0; j < s.length(); j++) {
                if ((s.charAt(j) - '0' & 1) != 1) index = j;
            }

            if (index == -1) {
                System.out.println(-1);
            } else if (index == s.length() - 1) {
                System.out.println(0);
            } else if ((s.charAt(0) - '0' & 1) != 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
        scanner.close();
    }

}