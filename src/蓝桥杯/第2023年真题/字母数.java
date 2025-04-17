package 蓝桥杯.第2023年真题;

public class 字母数 {
    public static void main(String[] args) {
        int i = 2022;
        while (true) {
            String str = Integer.toString(i, 16);
            str = str.toLowerCase();

            if (judge(str)) {
                System.out.println(i);
                break;
            }

            i++;
        }


    }

    public static boolean judge(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 97 || str.charAt(i) > 122) return false;
        }
        return true;
    }


}
