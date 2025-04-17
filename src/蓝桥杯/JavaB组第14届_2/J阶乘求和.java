package 蓝桥杯.JavaB组第14届_2;

// 数学技巧

public class J阶乘求和 {
    // 暴力，时间太长
//    public static void main(String[] args) {
//        long n = 202320232023L;
////        long n = 6; // 873
//
//        long result = 0;
//        long demo = 1;
//        for (long i = 1; i <= n; i++) {
//            i = i % 1000000000;
//            long dd = i * demo ;
//            dd = dd % 1000000000;
//            demo = dd;
//            result += dd;
//            result = result % 1000000000;
//        }
//        System.out.println(result);
//    }

    public static void main(String[] args) {
//        System.out.println(420940313);

        long sum = 0L;  //计算整体求和的
        long b = 1L; //计算每一步阶乘的和
        for (int i = 1; ; i++) {
            b *= i;
            b = b % 1000000000L; //只计算每一步计算后9位
            sum += b; //求和所有的后9位的 步
            sum = sum % 1000000000L; //只保留后9位
            if (b % 1000000000L == 0) { //如果当该步的后9位全为0 表明 不可能 再变化 因为是乘法
                System.out.println(sum); //输出所有步求和的后9位
                break;
            }
        }
    }

}
