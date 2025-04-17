package 牛客.winterVacation.num6;

import java.util.Scanner;

public class MainE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str2 = scanner.next();

        str = str.substring(2);
        int n = Integer.valueOf(str);

        int hong = 0, zi = 0;

//        for (int i = 0; i < str2.length(); i++) {
//            if (str2.charAt(i) == 'R') hong++;
//            if (str2.charAt(i) == 'P') zi++;
//
//            if (hong == n / 2 + 1 || zi == n / 2 + 1) break;
//        }
//
//        if (hong == n / 2 + 1) {
//            System.out.println("kou!");
//        } else if (zi == n / 2 + 1) {
//            System.out.println("yukari!");
//        } else {
//            System.out.println("to be continued.");
//        }
//
//        System.out.println(hong + zi);


        // 或者：
        for (int i = 0; i < n; i++) {
            if (hong == n/2+1) {
                System.out.println("kou!");
                System.out.println(hong + zi);
                return;
            } else if (zi == n/2+1) {
                System.out.println("yukari!");
                System.out.println(hong + zi);
                return;
            }

            if (i >= str2.length()) {
                System.out.println("to be continued.");
                System.out.println(hong + zi);
                return;
            }

            if (str2.charAt(i) == 'R') hong ++;
            if (str2.charAt(i) == 'P') zi ++;

            if (hong == n/2+1) {
                System.out.println("kou!");
                System.out.println(hong + zi);
                return;
            } else if (zi == n/2+1) {
                System.out.println("yukari!");
                System.out.println(hong + zi);
                return;
            }

            if (i >= str2.length()) {
                System.out.println("to be continued.");
                System.out.println(hong + zi);
                return;
            }
        }


    }
}

/*

BO11
RRRRRR
kou!
6


BO11
RRRRRP
to be
5

 */