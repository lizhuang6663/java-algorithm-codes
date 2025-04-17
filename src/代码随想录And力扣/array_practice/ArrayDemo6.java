package 代码随想录And力扣.array_practice;

//数组6:螺旋矩阵II
//给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//示例:
//输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
public class ArrayDemo6 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 0;//每一轮循环开始的时候，初始坐标位置(start, start)
        int x = 0, y = 0;
        int loop = 0;//循环的圈数
        int count = 1;//计数1 ～ n*n


        while (loop++ < n/2) {
            //从左到右(x不变，y变化)
            for (y = start; y<n-loop; y++) result[start][y] = count++;

            //从上到下(x变化，y不变)
            for (x = start; x<n-loop; x++) result[x][y] = count++;

            //从右到左(x不变，y变化)
            for ( ; y>=loop; y--) result[x][y] = count++;

            //从下到上(x变化，y不变)
            for ( ; x>=loop; x--) result[x][y] = count++;

            start++;
        }
        if (n%2 != 0) result[n/2][n/2] = n*n;

        return result;
    }
}
