package 洛谷.入门6;

import java.io.*;
import java.util.Scanner;

// 由于输出的数据量比较多，使用到了快速输出： BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

public class P5461赦免战俘 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        arr = new int[(int) Math.pow(2, n)][(int) Math.pow(2, n)];

        // 写0:
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                arr[i][j] = 1;
//            }
//        }
//        fanZhuan(0,0,arr.length);


        // 写1：
        operate(0, 0, (int) Math.pow(2, n) - 1, (int) Math.pow(2, n) - 1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        scanner.close();
    }

    public static void operate(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) return;

        if (x1 + 1 == x2 && y1 + 1 == y2) {
            arr[x1][y2] = 1;
            arr[x2][y1] = 1;
            arr[x2][y2] = 1;
        }

        // 分成四份，然后接着递归
//        operate(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);

        //右上角
        operate(x1, (y1 + y2) / 2 + 1, (x1 + x2) / 2, y2);
        //左下角
        operate((x1 + x2) / 2 + 1, y1, x2, (y1 + y2) / 2);
        //右下角
        operate((x1 + x2) / 2 + 1, (y1 + y2) / 2 + 1, x2, y2);
    }


    public static void fanZhuan(int x, int y, int r) {
        for (int i = x; i < x + r / 2; i++) {
            for (int j = y; j < y + r / 2; j++) {
                arr[i][j] = 0;
            }
        }
        if (r / 2 == 1) {
            return;
        }
        //右上角
        fanZhuan(x + r / 2, y, r / 2);
        //左下角
        fanZhuan(x, y + r / 2, r / 2);
        //右下角
        fanZhuan(x + r / 2, y + r / 2, r / 2);
    }


}
