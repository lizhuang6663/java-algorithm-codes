package 蓝桥杯.JavaB组第14届_2;

import java.util.Scanner;

// 数学几何

/*

要确定重叠部分的面积，需先找出重叠区域的坐标范围:
重叠区域的左下角横坐标xLeft：应为max(x1, x3)，即两个矩形左下角横坐标中较大的值。
重叠区域的左下角纵坐标yBottom：应为max(y1, y3)，即两个矩形左下角纵坐标中较大的值。
重叠区域的右上角横坐标xRight：应为min(x2, x4，即两个矩形右上角横坐标中较小的值。
重叠区域的右上角纵坐标yTop：应为min(y2, y4)，即两个矩形右上角纵坐标中较小的值。

当xRight > xLeft 且 yTop > yBottom时，说明存在重叠区域，此时重叠区域的面积：sOverlap = xRight - xLeft * yTop - yBottom；
若不满足上述条件，则说明不存在重叠区域，此时sOverlap = 0

 */

public class C矩形总面积 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x1 = scan.nextLong(), y1 = scan.nextLong();
        long x2 = scan.nextLong(), y2 = scan.nextLong();
        long x3 = scan.nextLong(), y3 = scan.nextLong();
        long x4 = scan.nextLong(), y4 = scan.nextLong();

        long xLeft,yLeft ;
        long xRight,yRight ;

        xLeft = Math.max(x1, x3);
        yLeft = Math.max(y1, y3);
        xRight = Math.min(x2, x4);
        yRight = Math.min(y2, y4);

        long area1 = (x2-x1)*(y2-y1);
        long area2 = (x4-x3)*(y4-y3);

        // 说明有重叠部分
        if (xLeft < xRight && yLeft < yRight) {
            long demo = (xRight-xLeft) * (yRight - yLeft);
            System.out.println(area1 + area2 - demo);
        }else {
            System.out.println(area1 + area2);
        }

        scan.close();
    }
}
