package 代码随想录And力扣.array_practice;

import java.util.ArrayList;
import java.util.List;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
public class ArrayDemo6_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(matrix.length);

    }


    //返回值是 List<Integer>
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int x = 0, y = 0;//每一圈的起始位置
        int i,j;//i，j分别代表每一圈中，不断变化的x,y
        int loop = matrix.length/2; //共有几圈
        int itemX = matrix.length - 1;
        int itemY = matrix[0].length - 1;

        while (loop-- > 0) {

            for (j = y; j<itemY; j++) list.add(matrix[x][j]);
            for (i = x; i<itemX; i++) list.add(matrix[i][j]);

            for ( ; j>y; j--) list.add(matrix[i][j]);
            for ( ; i>x; i--) list.add(matrix[i][j]);

            itemX--;
            itemY--;
            x++;
            y++;
        }
        int mid = matrix[0].length/2; //matrix[mid][mid]:matrix最中心的数据
        if (matrix[0].length % 2 != 0) list.add(matrix[mid][mid]);


        return list;
    }


    //返回值是 int[]
    public int[] spiralOrder2(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int idx = 0;
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (true) {
            //从左往右走
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            //从上往下走
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            //从右往左走
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            //从下往上走
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
