package common.homework;

import java.util.Scanner;

// 校队：https://ac.nowcoder.com/acm/contest/72681/B

/**

 链接：https://ac.nowcoder.com/acm/contest/72681/B
 来源：牛客网

 小红拿到了一个正整数x。她可以对x 做以下操作：
 1. 将x 乘以5。
 2. 若 x 是6的倍数，将 x 除以6。
 例如，12经过一次操作可以变成60，也可以变成2。


 现在小红想知道，如果要把x 变成y，需要操作多少次？一共有t 组询问。

 输入描述:
 第一行输入一个正整数t，代表询问次数。
 接下来的t 行，每行输入两个正整数x 和 y ，代表一次询问。
 数据范围：
 1 <= t <= 1000
 1 <= x, y <= 10e9

 输出描述:
 输出t行，对于每次询问，如果无论如何都不能把 x 变成 y，输出-1。否则输出操作次数。


 输入：
 1
 6 5

 输出：2

 */

// 是一个最短路问题，是图论的知识（但是我不会用图论写）
public class Num15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t -- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int num1 = x, num2 = y;
            int n1 = 0,n2 = 0,n3 = 0,n4 = 0;

            // 看一看num1 里面包含几个5，几个6
            while (num1 % 5 == 0) {
                num1 /= 5;
                n1 ++;
            }
            while (num1 % 6 == 0) {
                num1 /= 6;
                n2 ++;
            }

            // 看一看num2 里面包含几个5，几个6
            while (num2 % 5 == 0) {
                num2 /= 5;
                n3 ++;
            }
            while (num2 % 6 == 0) {
                num2 /= 6;
                n4 ++;
            }

            // 因为num1 可以 乘以 5， 所以num1包含的5必须 <= num2包含的5
            // 因为num1 可以 除以 6， 所以num1包含的6必须 >= num2包含的6
            if (num1 == num2 && n1 <= n3 && n2 >= n4) {
                // n3 - n1 代表num1 需要乘以多少个5，n2 - n4 代表num1需要除以多少个6才能和num2相等
                System.out.println(n3 - n1 + n2 - n4);
            }else  {
                System.out.println(-1);
            }

        }
    }
}
