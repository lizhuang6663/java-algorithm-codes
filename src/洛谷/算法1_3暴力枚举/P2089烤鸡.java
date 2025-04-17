package 洛谷.算法1_3暴力枚举;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 回溯
// 洛谷：https://www.luogu.com.cn/problem/P2089
// 也可以用10层for循环来遍历

public class P2089烤鸡 {

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n > 30 || n < 10) {
            System.out.println(0);
            return;
        }

        backTracking(n, 0, 0);

        System.out.println(result.size());

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    /**
     *
     * @param n 需要多少美味
     * @param now 现在已经有了多少美味
     * @param num 现在到第几种调料了
     */
    public static void backTracking(int n, int now, int num) {
        if (now == n && num == 10) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (now > n  || (now == n && num != 10) || num > 10) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            path.add(i);

            backTracking(n, now + i, num+1);

            path.removeLast();
        }

    }

}
