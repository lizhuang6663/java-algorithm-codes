package 牛客.牛客周赛Round61;

import java.util.Scanner;

// 思维：（一定不可能是三角形）
// 牛客：https://ac.nowcoder.com/acm/contest/91072/B

public class B简单图形问题0123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            double d = Math.sqrt(s);
            int temp = (int) d;
            if (temp * temp == s) {
                System.out.println(0);
            }else {
                System.out.println(3);
            }
        }
    }
}
