package 牛客.题库.二分;


import java.util.Scanner;

// Num7月19日_牛客周赛：https://ac.nowcoder.com/acm/contest/67914/B
public class 浮点二分 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1;i<=n;i++) {
            double y = scanner.nextDouble();

            //递增的
            double left = 0, right = 100,middle = 0;
            double sum ;

            while (right - left > 1e-8) {
                middle = (right+left)/2;
                sum = 2018 * Math.pow(middle, 4) + 21 * middle + 5 * Math.pow(middle, 3) + 5 * middle * middle + 14 ;
                if (sum > y) {
                    right = middle;
                }else if (sum < y) {
                    left = middle;
                }else {
                    break;
                }
            }

            if (y<14 || y>2018 * Math.pow(100, 4) + 21*100 + 5 * Math.pow(100, 3) + 5*100*100+ 14) {
                System.out.println(-1);
            }else {
                System.out.printf("%.4f\n",middle);
            }

        }

    }
}
