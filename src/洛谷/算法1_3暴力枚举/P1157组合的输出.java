package 洛谷.算法1_3暴力枚举;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 回溯：组合问题
// 洛谷：https://www.luogu.com.cn/problem/P1157

public class P1157组合的输出 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        backTracking(n, r, 1, new ArrayList<>());

    }

    public static void backTracking(int n, int r, int startIndex, List<Integer> path) {
        if (path.size() == r) {
            for (int i = 0; i < path.size(); i++) {
                System.out.printf("%3d", path.get(i));
            }
            System.out.println();
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);

            backTracking(n, r, i + 1, path);

            path.remove(path.size() - 1);
        }

    }

}
