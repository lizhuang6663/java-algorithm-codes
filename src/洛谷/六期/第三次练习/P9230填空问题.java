package 洛谷.六期.第三次练习;

import java.util.Scanner;


public class P9230填空问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        if (s.equals("A获得木头")) {
            System.out.println(4430091);
        } else if (s.equals("B")) {
            System.out.println(8335366);
        }


        // A获得木头:
//        int ans = 0;
//        for (int i = 1; i < 100000000; ) {
//            String str = String.valueOf(i);
//
//            if ((str.length() & 1) == 1) {
//                i *= 10;
//            } else {
//
//                int left = 0, right = str.length() - 1;
//                int l = 0, r = 0;
//
//                while (left < right) {
//                    l += str.charAt(left) - '0';
//                    r += str.charAt(right) - '0';
//
//                    left++;
//                    right--;
//                }
//
//                if (l == r) {
////                    System.out.println(l + " " + r);
//                    ans++;
//                }
//
//                i++;
//            }
//        }
//        System.out.println(ans);


        // B:
//        dfs(0, 0);
//
//        System.out.println(ans2);
    }


    static int ans2 = 0;
    public static void dfs(int num, int score) {
        if (score == 100 || num > 30) {
            return;
        }

        if (score == 70) {
            ans2++;
        }

        // 答对
        dfs(num+1, score+10);

        // 答错
        dfs(num+1, 0);
    }

}
