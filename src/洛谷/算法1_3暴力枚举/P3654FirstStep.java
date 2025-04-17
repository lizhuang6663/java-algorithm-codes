package 洛谷.算法1_3暴力枚举;

import java.util.Scanner;

// dfs
// 洛谷：https://www.luogu.com.cn/problem/P3654

public class P3654FirstStep {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();

        char[][] chars = new char[r][c];
        for (int i = 0; i < r; i++) {
            chars[i] = scanner.next().toCharArray();
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {

                if (chars[i][j] == '.') {

                    // 如果k == 1，就不用dfs了
                    if (k == 1) {
                        ans++;
                    }else {
                        // 向右向下都走一遍
                        dfs(chars, i, j, k - 1, 1);
                        dfs(chars, i, j, k - 1, 2);
                    }

                }
            }
        }

        System.out.println(ans);
    }


    /**
     *
     * @param chars
     * @param row
     * @param col
     * @param k 还剩几个人
     * @param target 朝向，如果向右走就一直向右走，不能向右走一半然后就向下走了。1:向右，2:向下
     */
    public static void dfs(char[][] chars, int row, int col, int k, int target) {
        if (k == 0) {
            ans++;
            return;
        }

        // (这里可以剪枝)
        // 向右
        if (target == 1) {
            if (col + 1 < chars[row].length && chars[row][col + 1] == '.') dfs(chars, row, col + 1, k - 1, 1);
        }

        // 向下
        if (target == 2) {
            if (row + 1 < chars.length && chars[row + 1][col] == '.') dfs(chars, row + 1, col, k - 1, 2);
        }

    }

}

/*


5 5 2
.###.
##.#.
..#..
#..#.
#.###
8


5 5 3
.###.
##.#.
..#..
#..#.
#.###
3


5 5 1
.###.
##.#.
..#..
#..#.
#.###
12


 */
