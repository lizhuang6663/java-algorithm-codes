package 前缀和和差分;

import java.util.Scanner;

//二维前缀和
//CSDN： https://blog.csdn.net/weixin_45629285/article/details/111146240?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164895247816781685391282%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=164895247816781685391282&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-5-111146240.142%5Ev5%5Epc_search_result_cache,157%5Ev4%5Econtrol&utm_term=%E5%89%8D%E7%BC%80%E5%92%8C%E7%AE%97%E6%B3%95&spm=1018.2226.3001.4187

//输入一个n行m列的整数矩阵，再输入q个询问，每个询问包含四个整数x1, y1, x2, y2，表示一个子矩阵的左上角坐标和右下角坐标。
//对于每个询问输出子矩阵中所有数的和。

//输入格式
//第一行包含三个整数n，m，q。
//接下来n行，每行包含m个整数，表示整数矩阵。
//接下来q行，每行包含四个整数x1, y1, x2, y2，表示一组询问。

//输出格式
//共q行，每行输出一个询问的结果。

public class 二维前缀和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        int arr[][] = new int[n+1][m+1];
        int result [][] = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                result[i][j] = result[i-1][j] + result[i][j-1] - result[i-1][j-1] + arr[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            System.out.println(result[x2][y2] - result[x2][y1-1] - result[x1-1][y2] + result[x1-1][y1-1]);
        }

    }
}

/*

3 4 3
1 7 2 4
3 6 2 8
2 1 2 3
1 1 2 2
2 1 3 4
1 3 3 4

17
27
21

 */