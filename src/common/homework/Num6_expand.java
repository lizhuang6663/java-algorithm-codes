package common.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//相邻的字符数量
//https://www.matiji.net/exam/brushquestion/15/4446/16A92C42378232DEB56179D9C70DC45C

public class Num6_expand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char ch = scanner.next().charAt(0);

        char[][] chars = new char[m][n];

        for (int i = 0; i < m; i++) {
            chars[i] = scanner.next().toCharArray();
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[i][j] != ch) continue;

                //ch的上面
                if (i > 0 &&chars[i-1][j] >= 'A' && chars[i-1][j] <= 'Z' &&  chars[i-1][j] != ch) {
                    set.add(chars[i-1][j]);
                }
                //下面
                if (i < m-1 && chars[i+1][j] >= 'A' && chars[i+1][j] <= 'Z' && chars[i+1][j] != ch) {
                    set.add(chars[i+1][j]);
                }
                //左面
                if (j > 0 && chars[i][j-1] >= 'A' && chars[i][j-1] <= 'Z' && chars[i][j-1] != ch) {
                    set.add(chars[i][j-1]);
                }
                //右面
                if (j < n-1 && chars[i][j+1] >= 'A' && chars[i][j+1] <= 'Z' && chars[i][j+1] != ch) {
                    set.add(chars[i][j+1]);
                }
            }
        }

        System.out.println(set.size());
    }
}




/*

2 3 H
00A
0HH


2 3 H
0AB
AHH

 */