package 牛客.河南农业大学_7月_17日;

import java.util.Scanner;

// 思维题，由于它可以删无数条边，那么我们只需要将所有边拆散然后均分为2堆连通块即可
// 牛客：https://ac.nowcoder.com/acm/contest/86639/K

public class K图上计数Easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();

        // 最大代价：两个相近的数相乘最大
        long ans =  (n / 2) * (n - n / 2);

        System.out.println(ans);
    }
}
