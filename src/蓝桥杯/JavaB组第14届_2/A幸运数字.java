package 蓝桥杯.JavaB组第14届_2;

public class A幸运数字 {
    public static void main(String[] args) {
//        System.out.println(215040);

        int num = 0;
        for (int i = 1; ; i++) {
            // 十进制

            String s = String.valueOf(i);
            int n = 0;
            for (int j = 0; j < s.length(); j++) {
                n += s.charAt(j) - '0';
            }
            if (i % n != 0) {
                continue;
            }

            // 二进制
            String s1 = Integer.toBinaryString(i);
            int n1 = 0;
            for (int j = 0; j < s1.length(); j++) {
                n1 += s1.charAt(j) - '0';
            }
            if (i % n1 != 0) {
                continue;
            }

            // 八进制
            String s2 = Integer.toOctalString(i);
            int n2 = 0;
            for (int j = 0; j < s2.length(); j++) {
                n2 += s2.charAt(j) - '0';
            }
            if (i % n2 != 0) {
                continue;
            }


            // 十六进制
            String s3 = Integer.toHexString(i);
            int n3 = 0;
            for (int j = 0; j < s3.length(); j++) {
                if (s3.charAt(j) >= '0' && s3.charAt(j) <= '9') {
                    n3 += s3.charAt(j) - '0';
                } else {
                    n3 += s3.charAt(j) - 'a' + 10;
                }
            }
            if (i % n3 != 0) {
                continue;
            }

            num++;
            if (num == 2023) {
                System.out.println(i);
                return;
            }
        }

    }
}
