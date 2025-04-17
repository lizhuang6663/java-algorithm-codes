package 洛谷.回溯;

import java.util.Scanner;


// dfs，回溯；bfs
// 洛谷：https://www.luogu.com.cn/problem/P1451
// 使用dfs，并往四个方向延伸


public class P1451求细胞数量 {
    public static int[][] arr; // 存题目输入的矩阵
    // 判断这个点是否走过，true代表走过了，false表示还没有走
    public static boolean[][] isUsed;

    // 四个方向
    public static int[] dx = {-1, 1, 0, 0}; // 向上，向下
    public static int[] dy = {0, 0, -1, 1}; // 向左，向右


    // 方法一：dfs
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new int[n + 2][m + 2];
        isUsed = new boolean[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            String str = scanner.next();
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j - 1, j));
            }
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                // 如果这个位置没有走过，而且值不是0，就执行
                if (!isUsed[i][j] && arr[i][j] != 0) {
                    dfs(i, j);
                    ans++;
                }

            }
        }

        System.out.println(ans);
    }


    public static void dfs(int i, int j) {
        isUsed[i][j] = true;
        // 向四个方向延伸
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            // 已经走过了，或者没必要走，就跳过
            if (isUsed[x][y] || arr[x][y] == 0) continue;

            dfs(x, y);
        }

    }


    // 或者另一种 dfs：
//    public static int n, m;
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//
//        arr = new int[101][101];
//        for (int i = 1; i < n + 1; i++) {
//            String str = scanner.next();
//            for (int j = 1; j < m + 1; j++) {
//                arr[i][j] = str.charAt(j - 1) - '0';
//            }
//        }
//
//
//        int ans = 0;
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//
//                if (arr[i][j] != 0) {
//                    // 不是0就变成零，目的是将所有这个细胞中的元素清零，这样就可以直接找下一个细胞的某个元素
//                    arr[i][j] = 0;
//
//                    dfs2(i, j);
//                    ans++;
//                }
//
//            }
//        }
//
//        System.out.println(ans);
//    }
//
//
//    public static void dfs2(int i, int j) {
//        if (i < 1 || j < 1 || i > n || j > m) {
//            return;
//        }
//
//        //以下是四个点的判断
//        //只要不是0都变成0，然后继续搜索
//        if (arr[i][j + 1] != 0) {
//            arr[i][j + 1] = 0;
//            dfs2(i, j + 1);
//        }
//        if (arr[i][j - 1] != 0) {
//            arr[i][j - 1] = 0;
//            dfs2(i, j - 1);
//        }
//        if (arr[i + 1][j] != 0) {
//            arr[i + 1][j] = 0;
//            dfs2(i + 1, j);
//        }
//        if (arr[i - 1][j] != 0) {
//            arr[i - 1][j] = 0;
//            dfs2(i - 1, j);
//        }
//
//    }




//    // 方法二：bfs，使用队列，横着走
//    public static Queue<int[]> queue = new LinkedList<>(); // 存位置坐标
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        arr = new int[n + 2][m + 2];
//        isUsed = new boolean[n + 2][m + 2];
//        for (int i = 1; i < n + 1; i++) {
//            String str = scanner.next();
//            for (int j = 1; j < m + 1; j++) {
//                arr[i][j] = str.charAt(j - 1) - '0';
//            }
//        }
//
//        int ans = 0;
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//
//                if (!isUsed[i][j] && arr[i][j] != 0) {
//                    bfs(i, j);
//                    ans++;
//                }
//
//            }
//        }
//
//        System.out.println(ans);
//    }
//
//    public static void bfs(int i, int j) {
//        isUsed[i][j] = true;
//        queue.add(new int[]{i, j});
//
//        while (!queue.isEmpty()) {
//
//            // 删除头部元素
//            int[] head = queue.poll();
//            for (int k = 0; k < 4; k++) {
//                int[] next = new int[]{head[0] + dx[k], head[1] + dy[k]};
//
//                if (arr[next[0]][next[1]] == 0 || isUsed[next[0]][next[1]]) continue;
//                isUsed[next[0]][next[1]] = true;
//                queue.add(next); // 添加新元素，并在下一次while循环中延伸到四周
//            }
//
//        }
//    }

}
