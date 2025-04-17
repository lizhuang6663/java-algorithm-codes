package 蓝桥杯.JavaB组第14届_1;

// 进制，模拟，枚举
// 蓝桥杯：https://www.lanqiao.cn/problems/3499/learning/

public class MainA幸运数字 {
    // 方法一：
    public static void main(String[] args) {
//        System.out.println(215040);

        int ans = 0; // 当前是第几个符合要求的数
        int result = 0;
        while (ans < 2023) {
            result++;
            if (judge(result)) {
                ans++;
            }
        }

        System.out.println(result); // 215040
    }

    public static boolean judge(int n) {
        String s2 = Integer.toString(n, 2);
        String s8 = Integer.toString(n, 8);
        String s10 = Integer.toString(n, 10);
        String s16 = Integer.toString(n, 16);


        int temp = 0;
        for (int i = 0; i < s2.length(); i++) {
            temp += Integer.parseInt(String.valueOf(s2.charAt(i)));
        }
        if (n % temp != 0) return false;


        temp = 0;
        for (int i = 0; i < s8.length(); i++) {
            temp += Integer.parseInt(String.valueOf(s8.charAt(i)));
        }
        if (n % temp != 0) return false;


        temp = 0;
        for (int i = 0; i < s10.length(); i++) {
            temp += Integer.parseInt(String.valueOf(s10.charAt(i)));
        }
        if (n % temp != 0) return false;


        temp = 0;
        for (int i = 0; i < s16.length(); i++) {
            temp += Integer.parseInt(String.valueOf(s16.charAt(i)), 16);
        }
        if (n % temp != 0) return false;

        return true;
    }


    // 方法二：
//    public static void P24多路归并Ⅱ(String[] args) {
//        int cnt = 0;
//        for(int i=1; ; i++){
//            if(check(i, 2) && check(i, 8) && check(i, 10) && check(i, 16)) cnt++;
//            if(cnt == 2023){
//                System.out.println(i);
//                break;
//            }
//        }
//
//    }
//
//    //判断是否为mod进制下的哈沙德数
//    public static boolean check(int x, int mod){
//        int n = x;
//        int ans = 0;
//        while(x>0){
//            ans = ans+ x%mod;
//            x /= mod;
//        }
//        return n%ans==0;
//    }

}

