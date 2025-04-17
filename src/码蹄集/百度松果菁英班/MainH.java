package 码蹄集.百度松果菁英班;

import java.util.Scanner;

public class MainH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String str1 = String.format("%" + a + "." + b + "f", 18.16054);
        String str2 = String.format("%" + a + "." + b + "f", 17.676767);

        System.out.println(str1 + " " + str2);
    }
}
