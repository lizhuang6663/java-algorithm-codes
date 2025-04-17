package common.homework;

import java.util.Scanner;

//水往低处流
//https://www.matiji.net/exam/brushquestion/16/4009/C448715ED43BEA9D2D47CED523050945

//小码哥正在给梯田浇水。小码哥家的梯田可以抽象为一个n×n 的网格，每个格子有自己的高度h。
//小码哥每次挑来一桶水，一桶水可以给一个格子浇水，这个格子的状态将会变成”湿润的”;特别的，如果一个格子为”湿润的”，
// 那么与其有边相邻且高度严格低于其的格子也会变成”湿润的”，这个关系会一直传递下去。
//小码哥希望所有的格子都变成”湿润的”，他想请教你一下，他最少需要挑多少桶水。

public class Num6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }


        int count = 0;//不用浇水的格子数量
        //判断当前位置是否可以被其他位置影响到
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i > 0 && arr[i-1][j] > arr[i][j]) {
                    count++;
                }else if (i < arr.length-1 && arr[i+1][j] > arr[i][j]) {
                    count++;
                }else if (j > 0 && arr[i][j-1] > arr[i][j]) {
                    count++;
                }else if (j < arr.length-1 && arr[i][j+1] > arr[i][j]){
                    count++;
                }

            }
        }
        System.out.println(n*n - count);
    }
}



/*

输入：
2
3 1
1 2
输出：2


3
1 2 3
4 9 5
6 7 8
输出：2

 */