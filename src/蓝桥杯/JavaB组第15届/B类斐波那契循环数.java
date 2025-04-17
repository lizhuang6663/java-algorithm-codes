package 蓝桥杯.JavaB组第15届;

// 暴力

public class B类斐波那契循环数 {
    public static void main(String[] args) {
//        System.out.println(7913837);

        int n = 10000000;
        for (; n >= 0; n--) {
            int len = 0;
            for (int demo = n; demo > 0; demo /= 10) {
                len++;
            }

            // 填充arr
            int[] arr = new int[len];
            String demo = new String(n+"");
            int demo2 = 0;
            for (int i = 0;i <  demo.length(); i++) {
                arr[i] = demo.charAt(i) - '0';
                demo2 += arr[i];
            }

            int index = 0; // arr 的指针
            while (demo2 <= n) {
                if (demo2 == n) {
                    System.out.println(n);
                    return;
                }

                int help = demo2;
                demo2 = demo2 * 2 - arr[index];
                arr[index] = help;
                index++;
                if (index >= arr.length) {
                    index = 0;
                }

            }
        }

    }
}
