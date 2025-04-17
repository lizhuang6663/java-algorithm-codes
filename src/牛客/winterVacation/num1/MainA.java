package 牛客.winterVacation.num1;

import java.util.Scanner;

// 牛客寒假训练1
public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int len = scanner.nextInt();

            String str = scanner.next();

            if (len < 3) {
                System.out.println(0 + " " + 0);
                continue;
            }

            int a = str.indexOf("D");
            int b = str.indexOf("FStonesinTheBucket", a+1);
            int c = str.indexOf("S", b+1);


            if (a == -1 || b == -1 || c == -1) {
                System.out.print(0 + " ");
            }else {
                System.out.print(1 + " ");
            }


            int a2 = str.indexOf("d");
            int b2 = str.indexOf("f", a2+1);
            int c2 = str.indexOf("s", b2+1);
            if (a2 == -1 || b2 == -1 || c2 == -1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }

        }

    }
}

/*

1 3 DFSdsf
1 0

1 3 DBBF
0 0
 */