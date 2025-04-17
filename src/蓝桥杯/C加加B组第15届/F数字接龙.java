package 蓝桥杯.C加加B组第15届;

import java.util.*;

// 回溯+状态记录
// 只对了75%

public class F数字接龙 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        boolean[][] status = new boolean[n][n]; // 存放各个位置是否已经走过了，true表示走过了
        for (int i = 0; i < n; i++) {
            status[i] = new boolean[n];
        }
        status[0][0] = true;
        if (arr[0][0] != 0) {
            System.out.println(-1);
            return;
        }


        List<String> results = new ArrayList<>(); // 存放最终的全部结果
        dfs(arr, 0, 0, arr[0][0] + 1, k, "", results, status);


        String result = "";
        for (String demo : results) {
            if (demo.length() != n * n - 1) {
                continue;
            }
            if (result.equals("")) {
                result = demo;
            }
            if (demo.compareTo(result) < 0) {
                result = demo;
            }
        }

        if (result.equals("")) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);

    }

    public static void dfs(int[][] arr, int x, int y, int num, int k, String demo, List<String> result, boolean[][] status) {
        if (x == arr.length - 1 && y == arr.length - 1) {
            result.add(demo);
            return;
        }

        // 重置num
        if (num > k - 1) {
            num = 0;
        }

        // 向上
        if (x - 1 >= 0 && arr[x - 1][y] == num && !status[x - 1][y]) {
            status[x - 1][y] = true;
            dfs(arr, x - 1, y, num + 1, k, demo + "0", result, status);
            status[x - 1][y] = false;
        }

        // 向右上角
        if (x - 1 >= 0 && y + 1 <= arr[0].length - 1 && arr[x - 1][y + 1] == num && !status[x - 1][y + 1] && (!status[x - 1][y] || !status[x][y + 1])) {
            status[x - 1][y + 1] = true;
            dfs(arr, x - 1, y + 1, num + 1, k, demo + "1", result, status);
            status[x - 1][y + 1] = false;
        }

        // 向右
        if (y + 1 <= arr[0].length - 1 && arr[x][y + 1] == num && !status[x][y + 1]) {
            status[x][y + 1] = true;
            dfs(arr, x, y + 1, num + 1, k, demo + "2", result, status);
            status[x][y + 1] = false;
        }

        // 向右下角
        if (x + 1 <= arr.length - 1 && y + 1 <= arr[0].length - 1 && arr[x + 1][y + 1] == num && !status[x + 1][y + 1] && (!status[x + 1][y] || !status[x][y + 1])) {
            status[x + 1][y + 1] = true;
            dfs(arr, x + 1, y + 1, num + 1, k, demo + "3", result, status);
            status[x + 1][y + 1] = false;
        }

        // 向下
        if (x + 1 <= arr.length - 1 && arr[x + 1][y] == num && !status[x + 1][y]) {
            status[x + 1][y] = true;
            dfs(arr, x + 1, y, num + 1, k, demo + "4", result, status);
            status[x + 1][y] = false;
        }

        // 向左下角
        if (x + 1 <= arr.length - 1 && y - 1 >= 0 && arr[x + 1][y - 1] == num && !status[x + 1][y - 1] && (!status[x + 1][y] || !status[x][y - 1])) {
            status[x + 1][y - 1] = true;
            dfs(arr, x + 1, y - 1, num + 1, k, demo + "5", result, status);
            status[x + 1][y - 1] = false;
        }

        // 向左
        if (y - 1 >= 0 && arr[x][y - 1] == num && !status[x][y - 1]) {
            status[x][y - 1] = true;
            dfs(arr, x, y - 1, num + 1, k, demo + "6", result, status);
            status[x][y - 1] = false;
        }

        // 向左上角
        if (x - 1 >= 0 && y - 1 >= 0 && arr[x - 1][y - 1] == num && !status[x - 1][y - 1] && (!status[x - 1][y] || !status[x][y - 1])) {
            status[x - 1][y - 1] = true;
            dfs(arr, x - 1, y - 1, num + 1, k, demo + "7", result, status);
            status[x - 1][y - 1] = false;
        }
    }

}
