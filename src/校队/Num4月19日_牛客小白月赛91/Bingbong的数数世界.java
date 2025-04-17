package 校队.Num4月19日_牛客小白月赛91;

import java.util.Scanner;

// 模拟，找规律
// 牛客，校队比赛：https://ac.nowcoder.com/acm/contest/78807/B

public class Bingbong的数数世界 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            int ji = ( num + 1)/ 2;
            int ou = num - ji;

            if (ji % 2 == 0 && ou % 2 == 0) {
                System.out.println("Bong");
            }else {
                System.out.println("Bing");
            }

        }
    }
}
