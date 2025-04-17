package 校队.Num4月19日_牛客小白月赛91;

import java.util.Scanner;

// 模拟，签到题
// 牛客，校队：https://ac.nowcoder.com/acm/contest/78807/A

public class Bingbong的化学世界 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c1 = ' ';
        char c2 = ' ';

        for (int i = 0; i < 6; i++) {
             String str = scanner.nextLine();

             if (i == 0) c1 = str.charAt(3) ;
             if (i == 5) c2  = str.charAt(3);
        }

        if (c1 == '|') {
            if (c2 == '|') {
                System.out.println("p");
            }else {
                System.out.println("m");
            }
        }else {
            System.out.println("o");
        }
    }

}
