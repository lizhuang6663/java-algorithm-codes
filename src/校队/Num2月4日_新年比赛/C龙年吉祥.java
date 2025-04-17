package 校队.Num2月4日_新年比赛;

import java.util.Scanner;

// 签到题：https://ac.nowcoder.com/acm/contest/73955/C

public class C龙年吉祥 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = (int) (scanner.nextLong() % 12);

            switch (N) {
                case 0 :
                case 12:
                case -12:
                    System.out.println("Dragon");
                    break;
                case 1 :
                case  -11:
                    System.out.println("Snake");
                    break;
                case 2:
                case  -10:
                    System.out.println("Horse");
                    break;
                case  3:
                case  -9:
                    System.out.println("Goat");
                    break;
                case 4 :
                case  -8:
                    System.out.println("Monkey");
                    break;
                case  -7:
                case 5 :
                    System.out.println("Rooster");
                    break;
                case 6:
                case  -6:
                    System.out.println("Dog");
                    break;
                case 7 :
                case  -5:
                    System.out.println("Pig");
                    break;
                case 8:
                case  -4:
                    System.out.println("Rat");
                    break;
                case 9 :
                case  -3:
                    System.out.println("Ox");
                    break;
                case 10:
                case -2:
                    System.out.println("Tiger");
                    break;
                case 11:
                case -1:
                    System.out.println("Rabbit");
                    break;
            }

        }


    }
}
