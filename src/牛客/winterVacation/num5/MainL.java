package 牛客.winterVacation.num5;

import java.util.Scanner;

public class MainL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int cha = n - x;

        // 如果 %2 == 0，说明可以确定
        if (cha % 2 == 0) {
            System.out.println(cha/2+x + " " + (n-(cha/2+x)));
        } else { // 不确定
            System.out.println(-1);
        }

    }
}



