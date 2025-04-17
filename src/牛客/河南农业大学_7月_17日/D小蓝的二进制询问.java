package 牛客.河南农业大学_7月_17日;

// 二进制：考虑每一位二进制位的贡献。算出1到R的贡献减去1到L-1的贡献，就是L到R的贡献。
// 从低位往高位枚举x的二进制位，简单枚举一下1到15的二进制可以发现，第0位是每2次出现一个1，第1位是每4次出现2个1，第2位是每8次出现4个1，
// 可以看出，对于每一位，画红框的地方是每一位的循环节，第 k 位的循环节长度为2k+1,其中有2k个1，所以我们可以按位枚举，
// 计算每一位上总共有多少个循环节和剩下非循环节中 1 的个数，因为这里是从 0 开始计算每一行的长度，所以实际计算时 x 需要加 1
// 图解：https://blog.csdn.net/wh233z/article/details/140503218

// 牛客：https://ac.nowcoder.com/acm/contest/86639/D

import java.util.Scanner;

public class D小蓝的二进制询问 {
    static int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            System.out.println((f(r) - f(l - 1) + MOD) % MOD);
        }
    }

    public static long f(long x) {
        long ans = 0, a = 2;
        x++;
        while (x >= a / 2) {
            // x/a：在第某位上有几个循环体；a/2：这个循环体有几个循环的1
            ans = (ans + (x / a) * (a / 2)) % MOD;//循环节里面1的个数
            if (x % a != 0) ans = (ans + Math.max(0, x % a - (a / 2))) % MOD;//非循环节1的个数
            a *= 2;
        }
        return ans;
    }
}

/*

1
1 5
7

 */