package 校队.Num5月5日_牛客周赛Round41;

import java.util.Scanner;

// 思维（位数有10^5，数比较大。两位 两位看，如果这两位可以整除4，就说明可以，如果遍历完后还找不到就打印-1）
// 牛客：https://ac.nowcoder.com/acm/contest/80742/C

public class C小红的循环移位 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int len = str.length();
        // 长度为1时
        if (len == 1) {
            if ((str.charAt(0) - '0') % 4 == 0) System.out.println(0);
            else System.out.println(-1);
            return;
        }

        int l = len - 2, r = len - 1;

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int temp = (str.charAt(l) - '0') * 10 + (str.charAt(r) - '0');
            if (temp % 4 == 0) {
                System.out.println(ans);
                return;
            }

            ans ++;
            l = (l + 1) % len;
            r = (r + 1) % len;
        }
        System.out.println(-1);
    }
}
