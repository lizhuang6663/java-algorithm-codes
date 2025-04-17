package common.homework;

import java.util.Scanner;

//判断是否能将 n个2，m个3 均分为两份
//https://www.matiji.net/exam/brushquestion/50/4009/C448715ED43BEA9D2D47CED523050945
public class Num8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count2 = 0, count3 = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 2) count2++;
            if (x == 3) count3++;
        }

        //当count2 == 1时，为NO
        //当count2 为偶数时：count3为奇数，NO；count3为偶数，YES
        //当count2 >= 3，而且count2为奇数时：count3为奇数，NO；count3为偶数时，YES
        System.out.println((count2 == 1 || count3 % 2 != 0) ? "NO" : "YES");

    }
}
