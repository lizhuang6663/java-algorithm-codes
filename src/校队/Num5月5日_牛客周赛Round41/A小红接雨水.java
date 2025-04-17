package 校队.Num5月5日_牛客周赛Round41;

import java.util.Scanner;

/*

    牛客周赛 Round 41:https://ac.nowcoder.com/acm/contest/80742#question
    题解：https://ac.nowcoder.com/discuss/1303169?type=101&order=1&pos=1&page=1&ncTraceId=&channel=-1&source_id=discuss_tag_nctrack

 */

// 签到题
public class A小红接雨水 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int result = Math.min(a, c) - b;
        if (result < 0) {
            System.out.println(0);
        }else {
            System.out.println(result);
        }

    }
}
