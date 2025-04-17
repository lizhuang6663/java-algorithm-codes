package 代码随想录And力扣.图论;

// dfs和bfs：连通性问题（二维数组的dfs）
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/number-of-islands/description/

// 思路：只有在边界的'O' 和 与边界'O'相连的'O'，才不会被围绕。我们把这种 'O'，标记为 'A获得木头'，不能被围绕，然后剩下的就全部是被围绕的'O'了
// 具体：先在边界遍历到 'O'，然后递归查找这个'O'相连的'O'。

public class P130被围绕的区域 {

    // 方法一：dfs
    int width, height;

    public void solve(char[][] board) {
        width = board.length;
        height = board[0].length;

        for (int i = 0; i < width; i++) {
            // 不需要添加 if，backTracking函数开头有判断条件
//            if (board[i][0] == 'O') backTracking(board, i, 0);
//            if (board[i][height - 1] == 'O') backTracking(board, i, height - 1);

            dfs(board, i, 0);
            dfs(board, i, height - 1);
        }

        for (int j = 0; j < height; j++) {
//            if (board[0][j] == 'O') backTracking(board, 0, j);
//            if (board[width - 1][j] == 'O') backTracking(board, width - 1, j);

            dfs(board, 0, j);
            dfs(board, width - 1, j);
        }


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if (board[i][j] == 'O') { // 把不符合的 0 换为X
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') { // 把A换回来
                    board[i][j] = 'O';
                }

            }
        }

    }

    public void dfs(char[][] board, int i, int j) {
        // 注意：遇到 'A获得木头' 也要退出去，否则在遇到：board = [["O","O"],["O","O"]] 的情况下，就会进入到死循环，报错：堆栈溢出
        if (i < 0 || i >= width || j < 0 || j >= height || board[i][j] == 'X' || board[i][j] == 'A') {
            return;
        }

        // 将当前的'O' 标记为'A获得木头'
        board[i][j] = 'A';

        // 向四周扩散
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }


    // -----------------------------------------------------------------------------------------------------------------

//    // 方法二：bfs
//    int width, height;
//    Queue<int[]> queue = new LinkedList<>(); // 存位置的坐标
//    public void solve(char[][] board) {
//        width = board.length;
//        height = board[0].length;
//
//
//        for (int i = 0; i < width; i++) {
//            bfs(board, i, 0);
//            bfs(board, i, height - 1);
//        }
//
//        for (int j = 0; j < height; j++) {
//            bfs(board, 0, j);
//            bfs(board, width - 1, j);
//        }
//
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//
//                if (board[i][j] == 'O') {
//                    board[i][j] = 'X';
//                }else if (board[i][j] == 'A获得木头') {
//                    board[i][j] = 'O';
//                }
//
//            }
//        }
//
//    }
//
//    public void bfs(char[][] board, int i, int j) {
//        if (i < 0 || i >= width || j < 0 || j >= height || board[i][j] == 'X' || board[i][j] == 'A获得木头') {
//            return;
//        }
//
//        board[i][j] = 'A获得木头';
//        queue.add(new int[]{i, j}); // 把当前符合的位置添加上去
//
//        while (!queue.isEmpty()) {
//
//            // 从头部元素开始扩散
//            int[] head = queue.poll();
//            int x = head[0], y = head[1];
//
//            // 上
//            if (x > 0 && board[x - 1][y] == 'O') {
//                board[x - 1][y] = 'A获得木头';
//                queue.add(new int[]{x - 1, y});
//            }
//            // 下
//            if (x < width - 1 && board[x + 1][y] == 'O') {
//                board[x + 1][y] = 'A获得木头';
//                queue.add(new int[]{x + 1, y});
//            }
//            // 左
//            if (y > 0 && board[x][y - 1] == 'O') {
//                board[x][y - 1] = 'A获得木头';
//                queue.add(new int[]{x, y - 1});
//            }
//            // 右
//            if (y < height - 1 && board[x][y + 1] == 'O') {
//                board[x][y + 1] = 'A获得木头';
//                queue.add(new int[]{x, y + 1});
//            }
//
//        }
//    }


    // 也可以把bfs写进方法中：
//    public void solve(char[][] board) {
//        // 四个方向
//        int[] dx = {1, -1, 0, 0};
//        int[] dy = {0, 0, 1, -1};
//
//        int n = board.length;
//        if (n == 0) {
//            return;
//        }
//        int m = board[0].length;
//        Queue<int[]> queue = new LinkedList<int[]>();
//        for (int i = 0; i < n; i++) {
//            if (board[i][0] == 'O') {
//                queue.offer(new int[]{i, 0});
//                board[i][0] = 'A获得木头';
//            }
//            if (board[i][m - 1] == 'O') {
//                queue.offer(new int[]{i, m - 1});
//                board[i][m - 1] = 'A获得木头';
//            }
//        }
//        for (int i = 1; i < m - 1; i++) {
//            if (board[0][i] == 'O') {
//                queue.offer(new int[]{0, i});
//                board[0][i] = 'A获得木头';
//            }
//            if (board[n - 1][i] == 'O') {
//                queue.offer(new int[]{n - 1, i});
//                board[n - 1][i] = 'A获得木头';
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int[] cell = queue.poll();
//            int x = cell[0], y = cell[1];
//
//            for (int i = 0; i < 4; i++) {
//                int mx = x + dx[i], my = y + dy[i];
//                if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
//                    continue;
//                }
//                queue.offer(new int[]{mx, my});
//                board[mx][my] = 'A获得木头';
//            }
//
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == 'A获得木头') {
//                    board[i][j] = 'O';
//                } else if (board[i][j] == 'O') {
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }

}

