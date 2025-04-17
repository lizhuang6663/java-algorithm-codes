package 码蹄集.百度松果菁英班;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int a = Integer.parseInt(str.split(",")[0]);
        int b = Integer.parseInt(str.split(",")[1]);
        System.out.printf("%d+%d=%d\n", a, b, a+b);
        System.out.printf("%d-%d=%d\n", a, b, a-b);

    }
}
