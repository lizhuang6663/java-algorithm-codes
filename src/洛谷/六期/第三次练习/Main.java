package 洛谷.六期.第三次练习;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int s = 0;
            for (int j = 2; j <= n; j++) {
                if (n % j == 0){
                    s = j;
                    break;
                }
            }



        }



    }
}
