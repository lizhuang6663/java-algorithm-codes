package 蓝桥杯.JavaB组第14届_1;

import java.util.Scanner;

// 思维(模拟，计算几何)
// 蓝桥杯：https://www.lanqiao.cn/problems/3536/learning/

public class MainC矩形总面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        // 总面积
        long total = (long) (x2 - x1) * (y2 - y1) + (long) (x4 - x3) * (y4 - y3);

        long width = Math.min(x2, x4) - Math.max(x1, x3);
        long height = Math.min(y2, y4) - Math.max(y1, y3);

        if (width > 0 && height > 0) { // 如果都 > 0 ，说明有重合部分
            total -= width * height;
        }

        System.out.println(total);

        scanner.close();
    }
}
