package 蓝桥杯.C加加B组第15届;

import java.util.Scanner;

//public class DR格式 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        double f = scanner.nextDouble();
//
//        double d = Math.round( f * Math.pow(2, n));
//        System.out.printf("%.0f\n",d);
//
//        scanner.close();
//    }
//}

import java.math.BigDecimal;

public class DR格式 {
    public static void main(String[] args) {
        // 创建Scanner对象，用于接收用户输入
        Scanner sc = new Scanner(System.in);

        // 接收用户输入的整数
        int n = sc.nextInt();

        // 接收用户输入的BigDecimal类型的数
        BigDecimal d = sc.nextBigDecimal();

        // 创建一个值为2的BigDecimal对象，用于后续的指数计算
        BigDecimal m = new BigDecimal("2");

        // 计算2的n次方乘以d，不保留小数点后的位数，采用四舍五入的方式进行舍入
        System.out.println(m.pow(n).multiply(d).setScale(0, BigDecimal.ROUND_HALF_UP));
        // setScale 方法的第一个参数是要设置的小数位数。例如，setScale(2) 表示设置小数位数为两位。
        // 第二个参数是舍入模式，BigDecimal.ROUND_HALF_UP 是其中一种舍入模式，表示四舍五入。
        // 常见的舍入模式还有 ROUND_DOWN（直接舍去小数部分）、ROUND_UP（向远离零的方向舍入）等。
    }
}