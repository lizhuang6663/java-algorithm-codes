package 牛客.winterVacation.num5;

import java.util.Scanner;

public class MainI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        long a = scanner.nextLong();
        long k = scanner.nextLong();

        // 一开始就可以看到a
        if (k >= Math.abs(a)) {
            // 先找a，后找t
            if ((a > 0 && t > 0) || (a < 0 && t < 0)) { // 如果a，t在同一方向
                // 判断a，t哪一个离原点近
                if (Math.abs(a) <= Math.abs(t)) { // a近
                    System.out.println(Math.abs(t));
                } else { // t近
                    System.out.println(Math.abs(a) + Math.abs(a) - Math.abs(t));
                }
            } else { // a,t不在同一方向
                System.out.println(Math.abs(a) + Math.abs(a) + Math.abs(t));
            }


        } else { // 先去找t

            if ((a > 0 && t > 0) || (a < 0 && t < 0)) {  // 如果a，t在同一方向
                // 判断a，t哪一个离原点近
                if (Math.abs(a) <= Math.abs(t)) { // a近
                    System.out.println(Math.abs(t));
                } else { // t近
                    System.out.println(Math.abs(a) + Math.abs(a) - Math.abs(t));
                }
            } else { // a,t不在同一方向
                System.out.println(Math.abs(t) + Math.abs(t) + Math.abs(a) + Math.abs(a) +  Math.abs(t));
            }
        }


    }
}

/*

-1000000000 1000000000 1

2000000000


10 100 1000
190

-10 100 1000
210


-10 100 1
220

 */