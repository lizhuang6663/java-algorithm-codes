package 校队.校队题库;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1004取模 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            boolean b = false;
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j <= m; j++) {
                if (set.contains(n % j )) {
                    System.out.println("Yes");
                    b = true;
                    break;
                } else {
                    set.add(n%j);
                }
            }

            if (!b) System.out.println("No");
        }

    }
}
