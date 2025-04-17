package 牛客.winterVacation.num5;

import java.util.Scanner;

// 牛客寒假训练5
public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if (temp != 1) {
                result++;
            }
        }

        System.out.println(result);

    }
}
