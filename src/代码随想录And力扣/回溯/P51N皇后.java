package 代码随想录And力扣.回溯;


// 回溯：棋盘问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/n-queens/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51N皇后 {

     List<List<String>> result = new ArrayList<>();
     char[][] path;

    public  List<List<String>> solveNQueens(int n) {
        path = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(path[i], '.');
        }

        // 从 0 开始（row是索引）
        backTracking(n, 0);

        return result;
    }


    /**
     * @param n   一共要放多少个皇后
     * @param row 现在已经到第几行了，也就是已经放完了row-1个皇后，该放第row个皇后了（row是索引）
     */
    public  void backTracking(int n, int row) {
        if (row == n) {
            // 将二维char 转换为 List<String>
            result.add(ArrayToList(path));
            return;
        }

        // 遍历列，看一看那一列符合
        for (int col = 0; col < n; col++) {
            // 如果符合
            if (isValid(row, col, n)) {
                path[row][col] = 'Q';

                backTracking(n, row + 1);

                path[row][col] = '.';
            }

        }
    }


    // 判断把一个皇后放在 [row, col] 是否符合
    public  boolean isValid(int row, int col, int n) {
        // 判断列，i代表行
        for (int i = 0; i < row; i++) { // i < row 相当于剪枝
            if (path[i][col] == 'Q') {
                return false;
            }
        }

        // 判断45度对角线（不理解的话可以画图看一看）
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (path[i][j] == 'Q') return false;
        }

        // 判断135度对角线（不理解的话可以画图看一看）
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (path[i][j] == 'Q') return false;
        }

        return true;
    }


    // 将二维char数组 转换为 List<String>
    public  List<String> ArrayToList(char[][] path) {
        List<String> p = new ArrayList<>();
        for (int i = 0; i < path.length; i++) {
            p.add(String.copyValueOf(path[i]));

            // 或者：
//            StringBuilder temp = new StringBuilder();
//            for (int j = 0; j < path[i].length; j++) {
//                temp.append(path[i][j]);
//            }
//            p.add(temp.toString());
        }

        return p;
    }

}
