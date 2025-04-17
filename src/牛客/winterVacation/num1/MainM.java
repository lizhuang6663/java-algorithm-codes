package 牛客.winterVacation.num1;

import java.util.Scanner;

public class MainM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        for (int i = 0; i < n; i++) {
            int result = 0;
            int nums = scanner.nextInt();

            if (nums % 6 == 0) {
                result += nums / 6;
            } else {
                result += nums / 6 * 2 ;

                // 错误的思路：（多想了）
//                if (nums % 6 != 3) {
//                    result += nums / 6 * 2 ;
//                } else {
//                    result += nums / 6;
//                    result += 1;
//                }

            }
            System.out.println(result);
        }


    }

}
