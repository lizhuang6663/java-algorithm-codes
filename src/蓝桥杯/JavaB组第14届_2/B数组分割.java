package 蓝桥杯.JavaB组第14届_2;

import java.util.Scanner;

// 数学组合

public class B数组分割 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();

            int jishu = 0, oushu = 0;
            for (int j = 0; j < N; j++) {
                int n = scan.nextInt();
                if ((n & 1) == 1) {
                    jishu++;
                } else {
                    oushu++;
                }
            }

            if ((jishu & 1) == 1) {

                System.out.println(0);

            } else {

                long result = 1;
                int cifang = 0;
                if (jishu >= 2) {
                    cifang = oushu + jishu - 1;
                } else {
                    cifang = oushu;
                }

                while (cifang > 0) {
                    result = result * 2;
                    result =   result%1000000007;
                    cifang--;
                }

                System.out.println(result);
            }
        }
        scan.close();
    }
}

/*


2
2
6 6
2
1 6


1
4
1 2 3 4


 */