package 牛客.河南农业大学_7月_17日;

import java.util.Scanner;

// 河南萌新联赛2024第（一）场：河南农业大学：https://ac.nowcoder.com/acm/contest/86639#question
// CSDN题解：https://blog.csdn.net/wh233z/article/details/140503218

// 数学思维（倒着看）
// 牛客：https://ac.nowcoder.com/acm/contest/86639/A

public class A造数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;

        while (n != 0) {
            if (n == 2) {
                result++;
                break;
            }

            if ((n & 1) == 1) {
               n--;
            } else {
                n /= 2;
            }
            result++;
        }

        System.out.println(result);
    }
}