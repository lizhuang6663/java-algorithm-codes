package 洛谷.进制;

import java.util.Scanner;

// 进制转换
// 洛谷：https://www.luogu.com.cn/problem/P1143?contestId=162285
public class P1143进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        String str = scanner.next();
        int n2 = scanner.nextInt();


        // 转化为十进制
        int i = Integer.parseInt(str, n1);
        // 转化为n2进制
        String result = Integer.toString(i, n2);

        // 将结果中的字母转换为大写
        if (n2 > 10) {
            result = result.toUpperCase();
        }
        System.out.println(result);

    }

}
