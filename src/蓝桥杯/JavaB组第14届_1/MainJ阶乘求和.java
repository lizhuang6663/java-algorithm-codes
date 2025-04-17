package 蓝桥杯.JavaB组第14届_1;

// 思维
// 蓝桥杯：https://www.lanqiao.cn/problems/3500/learning/

public class MainJ阶乘求和 {
    public static final long MOD = (long) 1e10;
    public static void main(String[] args) {
        long result = 0;

        long temp = 1;
        for (long i = 1; i <= 202320232023L; i++) {
            temp = temp * i % MOD;
            // 注意当i = 40的时候，后面9位数都是0，这时候就没有必要继续进行了，因为后9位再也不会变化了
            if (temp == 0) {
                System.out.println(result); // 420940313
                return;
            }

            result = (result + temp) % MOD;
        }

        System.out.println(result);
    }
}
