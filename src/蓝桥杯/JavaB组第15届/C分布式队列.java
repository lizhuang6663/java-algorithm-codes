package 蓝桥杯.JavaB组第15届;

import java.util.Arrays;
import java.util.Scanner;

// 状态记录（下面的代码可优化，可以把arr优化掉，不用存储实际数据，只需要有indexs数组即可）

public class C分布式队列 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int maxOperate = 2010;
        int[][] arr = new int[N][maxOperate];
        for (int i = 0; i < N; i++) {
            arr[i] = new int[maxOperate];
            Arrays.fill(arr[i], -1);
        }

        int[] indexs = new int[N]; // 存储arr数组中的每一个子节点应该处理哪个位置

        while (scan.hasNext()) {
            String str = scan.next();

            if (str.equals("add")) {

                int res = scan.nextInt();
                arr[0][indexs[0]] = res;
                indexs[0]++;

            } else if (str.equals("sync")) {

                int ind = scan.nextInt();
                // 跳过
                if (arr[0][indexs[ind]] == -1 ) {
                    continue;
                }

                arr[ind][indexs[ind]] = arr[0][indexs[ind]];
                indexs[ind]++;

            } else if (str.equals("query")) {

                int min = Integer.MAX_VALUE;
                for (int i = 0; i < indexs.length; i++) {
                    min = Math.min(min, indexs[i]);
                }
                System.out.println(min);
            }

//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[0].length; j++) {
//                    if (j <= 3) {
//                        System.out.print(arr[i][j]);
//                        System.out.print(" ");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println("-------");
//            for (int i = 0; i < indexs.length; i++) {
//                System.out.print(indexs[i]);
//                System.out.print(" ");
//            }
//            System.out.println();
//            System.out.println("======= end end end ");

        }
    }
}
