package 洛谷.六期.第三次练习;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class P8807取模 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();


        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Set<Integer> set = new HashSet<>();
            int j = 1;
            for ( j = 1; j <= m; j++) {
                int mod = n % j;
                if (set.contains(mod)) {
                    System.out.println("Yes");
                    break;
                }else {
                    set.add(mod);
                }

            }

            if (j > m) {
                System.out.println("No");
            }

        }



    }
}
