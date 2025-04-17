package 洛谷.算法1_3暴力枚举;

import java.util.*;

// 暴力，减少枚举的对象
// 代码随想录And力扣.力扣：https://www.luogu.com.cn/problem/P1618

public class P1618三连击升级版 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a == 0 || b == 0 ||  c == 0) {
            System.out.println("No!!!");
            return;
        }

        List<List<Integer>> result = new ArrayList<>();
        int num1, num2, num3;
        for (int i = 123; i <= 987; i++) {
            num1 = i;

            if (!judge(num1)) continue;

            for (int j = i + 1; j <= 987; j++) {
                num2 = j;
                if (!judge(num2)) continue;

                for (int k = j + 1; k <= 987; k++) {
                    num3 = k;
                    if (!judge(num3)) continue;

                    if (judge2(num1, num2, num3) && num1 / a == num2 / b && num3 / c == num2 / b  && num1 % a == 0 && num2 % b == 0 &&  num3 % c == 0) {
                        result.add(Arrays.asList(num1, num2, num3));
                    }

                }
            }
        }


        if (result.size() == 0) {
            System.out.println("No!!!");
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    // 判断一个数中是否有重复的数字
    public static boolean judge(int num) {
        int[] used = new int[10];

        while (num > 0) {
            if (used[num % 10] == 1 || used[0] == 1) {
                return false;
            } else {
                used[num % 10] = 1;
            }
            num /= 10;
        }

        return true;
    }


    // 判断三个num中是否有重复的数字
    public static boolean judge2(int num1, int num2, int num3) {
        int[] used = new int[10];

        while (num1 > 0) {
            if (used[num1 % 10] == 1 || used[0] == 1) {
                return false;
            } else {
                used[num1 % 10] = 1;
            }
            num1 /= 10;
        }

        while (num2 > 0) {
            if (used[num2 % 10] == 1 || used[0] == 1) {
                return false;
            } else {
                used[num2 % 10] = 1;
            }
            num2 /= 10;
        }

        while (num3 > 0) {
            if (used[num3 % 10] == 1 || used[0] == 1) {
                return false;
            } else {
                used[num3 % 10] = 1;
            }
            num3 /= 10;
        }

        return true;
    }


}
