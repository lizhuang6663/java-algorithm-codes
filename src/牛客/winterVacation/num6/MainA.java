package 牛客.winterVacation.num6;

import java.util.*;

public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        for (int i = l; i <= r ; i++) {
            List <Integer> list = judge(i);

            if (list.size() == 3 && judgePrim(list.get(0)) && judgePrim(list.get(1)) && judgePrim(list.get(2)) &&
                    list.get(0) != list.get(1) && list.get(0) != list.get(2) && list.get(1) != list.get(2)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    public static  List <Integer>  judge(int n) {
        // 分割因数
        List <Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            while (n % i == 0) {
                list.add(i);
                n = n/i;
            }
        }
        if (n != 1) {
            list.add(n);
        }

        return list;
    }

    // 判断是否是素数
    public static boolean judgePrim(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }


}
