package common.homework;

import java.math.BigInteger;
import java.util.Scanner;

// 阶乘之和：使用 BigInteger
// 洛谷：https://www.luogu.com.cn/problem/P1009
public class Num20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        BigInteger he = new BigInteger("0");
        BigInteger cheng = new BigInteger("1");
        BigInteger zizeng = new BigInteger("0");
        BigInteger zhi1 = new BigInteger("1");
        while (n -- > 0) {
            // 自增
            zizeng = zizeng.add(zhi1);
            // 阶乘
            cheng = cheng.multiply(zizeng);
            // 阶乘和
            he = he.add(cheng);
        }

        System.out.println(he);


    }
}
