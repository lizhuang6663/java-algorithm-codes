package 校队.校队题库_新;

import java.util.Scanner;

// 校队题库：http://154.37.212.21/p/P22

// 或者使用双指针
public class P22冒泡 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        String[] strings = str.split("-");

        int maxLen = 0;

        for (int i = 0; i < strings.length; i++) {
            maxLen = Math.max(maxLen, strings[i].length());
        }
        System.out.println(maxLen);
    }
}
