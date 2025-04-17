package 牛客.winterVacation.num6;

import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        System.out.println( d*d*(1-d)*(1-d)*(1-d) +  (1-d)*(1-d)*d*d*d);
    }
}
