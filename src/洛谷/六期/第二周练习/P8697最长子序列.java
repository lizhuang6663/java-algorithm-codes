package 洛谷.六期.第二周练习;

import java.util.Scanner;


// 洛谷，蓝桥杯：https://www.luogu.com.cn/problem/P8697?contestId=162817

public class P8697最长子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb1 = new StringBuilder(scanner.next());
        StringBuilder sb2 = new StringBuilder(scanner.next());

        int ans = 0;
        for (int i = 0; i < sb2.length(); i++) {
            int index = sb1.indexOf(String.valueOf(sb2.charAt(i)));
            if (index != -1) {
                ans++;

                sb1 = new StringBuilder(sb1.substring(index + 1));

            } else {
                break;
            }
        }
        System.out.println(ans);
    }


    // 或者
//    public static void P24多路归并Ⅱ(String[] args) {
//        String s1, s2;
//        Scanner scanner = new Scanner(System.in);
//        s1 = scanner.nextLine();
//        s2 = scanner.nextLine();
//        int ans = 0;
//        for(int i = 0;i < s1.length() && ans < s2.length();i ++) {
//            if(s1.charAt(i) == s2.charAt(ans)) {
//                ans ++;
//            }
//        }
//        System.out.println(ans);
//    }

}
