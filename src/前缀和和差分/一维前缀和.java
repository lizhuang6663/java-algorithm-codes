package 前缀和和差分;

import java.util.*;


//一维前缀和
//CSDN知识点链接：https://blog.csdn.net/weixin_45629285/article/details/111146240?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164895247816781685391282%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=164895247816781685391282&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-5-111146240.142%5Ev5%5Epc_search_result_cache,157%5Ev4%5Econtrol&utm_term=%E5%89%8D%E7%BC%80%E5%92%8C%E7%AE%97%E6%B3%95&spm=1018.2226.3001.4187
//输入一个长度为n的整数序列。
//接下来再输入m个询问，每个询问输入一对l, r。
//对于每个询问，输出原序列中从第l个数到第r个数的和。

//输入格式
//第一行包含两个整数n和m。
//第二行包含n个整数，表示整数数列。
//接下来m行，每行包含两个整数l和r，表示一个询问的区间范围。

//输出格式:共m行，每行输出一个询问的结果。

public class 一维前缀和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //首先给定一个原数组a：a[1], a[2], a[3],,,,,, a[n];
        //然后我们构造一个数组b ： b[1], b[2], b[3],,,,,, b[i];
        //使得 a[i] = b[1] + b[2] + b[3] + ,,,,,, + b[i]
        //也就是说，a数组是b数组的前缀和数组，反过来我们把b数组叫做a数组的差分数组。换句话说，每一个a[i]都是b数组中从头开始的一段区间和。

        //数组arr是result的差分数组，result是arr的前缀和数组
        int[] arr = new int[n+1];
        int[] result = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = scanner.nextInt();
        }

        //前缀和
        for (int i = 1; i < n+1; i++) {
            result[i] = result[i-1] + arr[i];
        }

        //求差
        for (int i = 0; i < m; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            System.out.println(result[right] - result[left-1]);
        }

    }
}

/*

输入：
5 3
2 1 3 6 4
1 2
1 3
2 4

输出：
3
6
10

 */







//二维前缀和
//public class common.incomplete.Num3 {
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int q = scanner.nextInt();
//
//        int[][] arr = new int[n+1][m+1];
//        int[][] result = new int[n+1][m+1];
//
//
//        for (int i = 1; i < n+1; i++) {
//            for (int j = 1; j < m+1; j++) {
//                arr[i][j] = scanner.nextInt();
//            }
//        }
//
//        //前缀和
//        for (int i = 1; i < n+1; i++) {
//            for (int j = 1; j < m+1; j++) {
//                result[i][j] = result[i-1][j] + result[i][j-1] - result[i-1][j-1] + arr[i][j];
//            }
//        }
//
//        //求差
//        for (int i = 0; i < q; i++) {
//            int x1 = scanner.nextInt();
//            int y1 = scanner.nextInt();
//            int x2 = scanner.nextInt();
//            int y2 = scanner.nextInt();
//
//            int temp = result[x2][y2] - result[x1-1][y2] - result[x2][y1-1] + result[x1-1][y1-1];
//            //不正确写法：
////            int temp = result[x2][y2] - result[x1][y2] - result[x2][y1] + result[x1][y1];
//            System.out.println(temp);
//        }
//
//
//    }
//}


/*

输入：
3 4 3
1 7 2 4
3 6 2 8
2 1 2 3
1 1 2 2
2 1 3 4
1 3 3 4

输出：
17
27
21

 */