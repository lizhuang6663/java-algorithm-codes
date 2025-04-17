package common.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//车的攻击(Java未通过，C_PolycarpRecoversthePermutation++通过)
// https://www.luogu.com.cn/problem/P3913


public class Num11 {

    //方法一：（内存超限）
    //解释：
    //比如输入车的坐标1，2和3，4，第1,3行的格子就被攻击了，第2,4列的格子也被攻击了，把被攻击的行和列都挪在左上角，不被攻击的格子变为(n-2)*(n-2)。
    //同理，只要统计输入的行不重复的个数h与列不重复的个数l，答案便为 n*n - (n-h)*(n-l)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < k; i++) {
            xSet.add(scanner.nextInt());
            ySet.add(scanner.nextInt());
        }

        int hang = xSet.size(); //统计剩余的行
        int lie = ySet.size(); //统计剩余的列
        System.out.println(n*n - (n-hang)*(n-lie));
    }




    //方法二：容易理解（内存超限）
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int N = scanner.nextInt(); // 棋盘大小
        int K = scanner.nextInt(); // 车的数量
        int[][] positions = new int[K][2]; // 车的位置

        for (int i = 0; i < K; i++) {
            positions[i][0] = scanner.nextInt(); // 车的行位置
            positions[i][1] = scanner.nextInt(); // 车的列位置
        }

        // 计算被攻击的格子数量
        int result = attackedCellsCount(N, K, positions);
        System.out.println(result);
    }

    // 计算被攻击的格子数量的方法
    public static int attackedCellsCount(int N, int K, int[][] positions) {
        // 创建一个N*N的棋盘，并初始化所有格子为0
        int[][] chessboard = new int[N][N];

        // 在棋盘上标记每个车能够攻击的位置
        for (int i = 0; i < K; i++) {
            int r = positions[i][0];
            int c = positions[i][1];

            // 标记同一行的格子
            for (int j = 0; j < N; j++) {
                chessboard[r - 1][j] = 1;
            }

            // 标记同一列的格子
            for (int j = 0; j < N; j++) {
                chessboard[j][c - 1] = 1;
            }
        }

        // 统计被攻击的格子数量
        int attackedCells = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (chessboard[i][j] == 1) {
                    attackedCells++;
                }
            }
        }

        return attackedCells;
    }
}



/*

输入：
3 2
1 2
2 2

输出：7

 */

