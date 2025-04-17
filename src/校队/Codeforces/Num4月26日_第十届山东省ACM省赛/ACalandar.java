package 校队.Codeforces.Num4月26日_第十届山东省ACM省赛;

import java.util.Scanner;


/*

    第十届山东省ACM省赛:https://codeforces.com/gym/104459
    题解：https://blog.csdn.net/diaofu6766/article/details/101268772

 */


// 签到题
public class ACalandar {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int y1 = scanner.nextInt();
            int m1 = scanner.nextInt();
            int d1 = scanner.nextInt();
            String s = scanner.next();
            int y2 = scanner.nextInt();
            int m2 = scanner.nextInt();
            int d2 = scanner.nextInt();

            int num;
            if (d1 > d2) {
                num = Math.abs((30 - d1) + d2);
            } else {
                num = Math.abs(d1 - d2);
            }

            switch (s) {
                case "Monday":
                    num += 1;
                    break;
                case "Tuesday":
                    num += 2;
                    break;
                case "Wednesday":
                    num += 3;
                    break;
                case "Thursday":
                    num += 4;
                    break;
                case "Friday":
                    num += 5;
                    break;
            }

            switch (num % 5) {
                case 0:
                    System.out.println("Friday");
                    break;
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
            }
        }

    }
}

/*

4
2019 5 12 Monday
2019 5 14
2019 5 12 Tuesday
2019 12 30
2019 5 12 Friday
1000000000 1 1
1000000000 1 1 Wednesday
2019 5 12


 */