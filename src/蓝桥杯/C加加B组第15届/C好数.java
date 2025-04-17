package 蓝桥杯.C加加B组第15届;

import java.util.Scanner;

public class C好数 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = 0;
        boolean select;

        for (int i = 1; i <= n; i++) {
            select = false;
            int demo = i;
            boolean isGood = true;

            while (demo > 0) {
                int num = demo % 10;
                // 当为false时，应该为奇数，为true时，应该为偶数
                if (!select) {
                    if ((num & 1) == 1) {
                        select = true; // 调整select
                    } else {
                        isGood = false;
                        break;
                    }
                } else {
                    if ((num & 1) == 0) {
                        select = false;
                    } else {
                        isGood = false;
                        break;
                    }
                }
                demo /= 10;
            }
            if (isGood) {
                result++;
            }
        }

        System.out.println(result);

        scan.close();
    }
}
