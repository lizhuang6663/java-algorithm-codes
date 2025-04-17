package 码蹄集.百度松果菁英班;

import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int year = Integer.valueOf(str.split("/")[2]);
        int day = Integer.valueOf(str.split("/")[1]);
        int month = Integer.valueOf(str.split("/")[0]);
        System.out.printf("%04d%02d%02d\n", year, month, day);

    }
}
