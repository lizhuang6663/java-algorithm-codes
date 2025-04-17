package common.homework;

import java.util.Scanner;

//房间打扫：（不能硬写）
//https://www.matiji.net/exam/brushquestion/2/4009/C448715ED43BEA9D2D47CED523050945

public class Num3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String [] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }


        //解题思路：判断哪一种字符串相同的多
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            int sum = 1;
            for (int j = i+1; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    sum ++;
                }
            }
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}

