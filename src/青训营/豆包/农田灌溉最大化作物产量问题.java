package 青训营.豆包;

// 签到：数组

public class 农田灌溉最大化作物产量问题 {
    public static int solution(int m, int n, int[][] cropField) {
        // m 是列，n是行
        int row = n;
        int col = m;

        // 1. 计算每一行的总产量
        int[] rowSums = new int[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowSums[i] += cropField[i][j];
            }
        }
        // 2. 计算每一列的总产量
        int[] colSums = new int[col];
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                colSums[j] += cropField[i][j];
            }
        }
        // 3. 计算不灌溉的初始总产量
        int baseYield = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                baseYield += cropField[i][j];
            }
        }

        // 4. 找出最大增量
        int maxYield = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 计算当前选择的行和列的增量
                int yieldIncrease = rowSums[r] + colSums[c] - cropField[r][c];
                maxYield = Math.max(maxYield, baseYield + yieldIncrease);
            }
        }
        return maxYield;
    }

    public static void main(String[] args) {
        int[][] cropField1 = {{2, 3, 1, 4}, {1, 2, 0, 3}, {4, 2, 1, 7}, {3, 1, 4, 2}};
        int[][] cropField2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] cropField3 = {{10, 20}, {30, 40}};
        int[][] cropField4 = {{1, 15, 1, 5}, {10, 7, 14, 7}, {10, 7, 9, 2}, {7, 5, 10, 13}, {10, 8, 5, 16}, {10, 6, 12, 1}, {1, 6, 1, 12}, {15, 16, 15, 1}, {2, 10, 3, 5}, {6, 14, 11, 10}, {4, 5, 10, 11}, {11, 9, 6, 7}, {15, 7, 3, 13}, {13, 10, 16, 17}, {2, 8, 17, 4}};

        System.out.println(solution(4, 4, cropField1) == 64);
        System.out.println(solution(3, 3, cropField2) == 78);
        System.out.println(solution(2, 2, cropField3) == 190);
        System.out.println(solution(4, 15, cropField4) == 686);
    }
}
