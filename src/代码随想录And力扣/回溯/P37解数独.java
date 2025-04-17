package 代码随想录And力扣.回溯;


// 回溯：棋盘问题，二维递归
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/sudoku-solver/description/
// N皇后问题是因为每一行每一列只放一个皇后，只需要一层for循环遍历一行，递归来遍历列，然后一行一列确定皇后的唯一位置。
// 本题就不一样了，本题中棋盘的每一个位置都要放一个数字（而N皇后是一行只放一个皇后），并检查数字是否合法，解数独的树形结构要比N皇后更宽更深。
public class P37解数独 {
    public static void main(String[] args) {
        System.out.println(5 + '0');
        System.out.println((char) (5 + '0'));
    }

    public void solveSudoku(char[][] board) {

        backTracking(board);
    }

    public boolean backTracking(char[][] board) {

        for (int i = 0; i < board.length; i++) { // 行
            for (int j = 0; j < board[i].length; j++) { // 列

                 // 跳过原始数字
                if (board[i][j] != '.') continue;

                // 填1-9，看一看哪个合适
                for (char k = '1'; k <= '9'; k++) {

                    // 如果合适就添加到数组中，并进行下一个递归
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;

                        // 如果下一个递归返回true，这里也返回true
                        if (backTracking(board)) {
                            return true;
                        }

                        // 如果无法找到，把这个位置变为 . ，并换一个数字试一试
                        board[i][j] = '.';
                    }
                }

                // 9个数字都试过了，但是都不符合，就返回false
                return false;

            }
        }

        // 这里是遍历结束，说明成功找到了
        return true;
    }

    // 判断放在这个位置上是否合法
    public boolean isValid(int row, int col, char val, char[][] board) {
        // 判断放在这一行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
        }

        // 判断放在这一列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }

        // 判断这个 3*3 格子内是否重复
//        if (row == 0 || row == 1 || row == 2) {
//            row = 0;
//        } else if (row == 3 || row == 4 || row == 5) {
//            row = 3;
//        } else if (row == 6 || row == 7 || row == 8) {
//            row = 6;
//        }
//
//        if (col == 0 || col == 1 || col == 2) {
//            col = 0;
//        } else if (col == 3 || col == 4 || col == 5) {
//            col = 3;
//        } else if (col == 6 || col == 7 || col == 8) {
//            col = 6;
//        }

        // 或者
        row = row / 3 * 3;
        col = col / 3 * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }

}
