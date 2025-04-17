package 蓝桥杯.C加加B组第15届;

public class A握手问题 {
    public static void main(String[] args) {
//        System.out.println(help(6)-help(3)); // 12

        System.out.println(help(50)-help(7)); // 1204
    }

    public static int help(int n ) {
        // 奇数
        if ((n & 1) == 1 ) {
            return n /2 * n;
        }
        // 偶数
        return n /2 + (n-1)/2 *n;
    }

}




