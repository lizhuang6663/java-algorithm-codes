package 码蹄集.百度松果菁英班;

import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.printf("%.6f\n%.6f\n", a + b + c, (a + b + c) / 3);

    }
}
