package 前缀和和差分;

//二维前缀和（下标熟练度考察）
//代码随想录And力扣.力扣：https://leetcode.cn/problems/range-sum-query-2d-immutable/description/

class NumMatrix {

    int sums[][] ;
    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length+1][matrix[0].length+1];

        for (int i = 1; i < matrix.length+1; i++) {
            for (int j = 1; j < matrix[0].length+1; j++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    //四个参数是索引
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }
}


//class NumMatrix {
//
//    int sums[][] ;
//    public NumMatrix(int[][] matrix) {
//        sums = new int[matrix.length+1][matrix[0].length+1];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
//    }
//}