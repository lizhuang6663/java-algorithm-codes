package 码蹄集.百度松果菁英班;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int a = scanner.nextInt();

        System.out.printf("%.2f\n", 0.5 * (1.0 * a * x + 1.0 * (a + x) / (4.0 * a)));

    }
}
