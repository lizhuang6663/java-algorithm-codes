package 蓝桥杯.第13届;

// 模拟，枚举
// 蓝桥杯：https://www.lanqiao.cn/problems/2141/learning/

public class MainB山 {
    public static void main(String[] args) {
//        System.out.println(3138);

        long ans = 0;
        for (int i = 2022; i <= 2022222022; i++) {
            if (judge1(i) && judge2(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }


    public static boolean judge1(int n) {
        String str = String.valueOf(n);


        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return false;
            }
        }

        for (int i = str.length() / 2; i >= str.length() - 1; i--) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean judge2(int n) {
        String str = String.valueOf(n);

        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
