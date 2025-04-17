package 校队.Num4月28日_牛客小白月赛92;

import java.util.Scanner;

// 模拟

public class B采矿时间到 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        char[][] chars = new char[5][n];
        for (int i = 0; i < 5; i++) {
            chars[i] = scanner.next().toCharArray();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (chars[1][i] == '*') {
                if (h > 0) {
                    result++;
                    chars[1][i] = '1';
                    h--;
                } else {
                    System.out.println(result);
                    return;
                }
            }

            if (chars[3][i] == '*') {
                if (h > 0) {
                    result++;
                    chars[3][i] = '1';
                    h--;
                } else {
                    System.out.println(result);
                    return;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (chars[0][i] == '*' && chars[1][i] == '1') {
                if (h > 0) {
                    result++;
                    chars[0][i] = '1';
                    h--;
                } else {
                    System.out.println(result);
                    return;
                }
            }

            if (chars[4][i] == '*' && chars[3][i] == '1') {
                if (h > 0) {
                    result++;
                    chars[4][i] = '1';
                    h--;
                } else {
                    System.out.println(result);
                    return;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (chars[0][i] == '*' && chars[1][i] != '1') {
                if (h - 2 >= 0) {
                    result++;
                    chars[0][i] = '1';
                    h -= 2;
                } else {
                    System.out.println(result);
                    return;
                }
            }
            if (chars[4][i] == '*' && chars[3][i] != '1') {
                if (h - 2 >= 0) {
                    result++;
                    chars[4][i] = '1';
                    h -= 2;
                } else {
                    System.out.println(result);
                    return;
                }
            }

        }
        System.out.println(result);
    }

}

/*

20 7
##*#######**########
#########*##########
....................
#####*######**######
####################
5


 */
