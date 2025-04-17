package 蓝桥杯.JavaB组第15届;

import java.util.*;

// 图


// 超时，只通过了4个案例，加上了快速输入输出也超时
//public class F星际旅行 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int m = scan.nextInt();
//        int Q = scan.nextInt();
//
//        // 存放各个星球之间是否可以到达
//        boolean[][] planet = new boolean[n + 1][n + 1];
//        for (int i = 0; i < planet.length; i++) {
//            planet[i] = new boolean[n + 1];
//        }
//        for (int i = 0; i < m; i++) {
//            int a = scan.nextInt();
//            int b = scan.nextInt();
//            planet[a][b] = true;
//            planet[b][a] = true;
//        }
//
//
//        int total = 0;
//        for (int i = 0; i < Q; i++) {
//            int x = scan.nextInt();
//            int y = scan.nextInt();
//
//            // bfs
//            Set<Integer> set = new HashSet<>();
//            List<Integer> list = new ArrayList<>();
//            list.add(x);
//            set.add(x);
//
//            // 特殊判断，只能到达x
//            if (y == 0) {
//                total += 1;
//                continue;
//            }
//
//            while (list.size() != 0 && y != 0) {
//
//                int l = list.size();
//                for (int j = 0; j < l; j++) {
//                    int xx = list.get(j);
//
//                    // 判断当前的这个值能够到达哪些位置
//                    for (int k = 0; k < n + 1; k++) {
//                        // 如果xx能够到达k
//                        if (planet[xx][k]) {
//
//                            // 再判断一次：如果已经包含了这个值，就不再添加，防止死循环；如果没有包含，就添加
//                            if (!set.contains(k)) {
//                                set.add(k);
//                                list.add(k);
//                            }
//
//                        }
//                    }
//                }
//
//                // 删除元素
//                for (int j = 0; j < l; j++) {
//                    list.remove(0);
//                }
//                y--;
//            }
//
//            total += set.size();
//        }
//
//        System.out.printf("%.2f", total * 1.0 / Q);
//        scan.close();
//    }
//}


// 方法二：Floyd（动态规划），权重问题
public class F星际旅行 {
    static int[][] d = new int[1010][1010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m, Q;
        n = sc.nextInt();
        m = sc.nextInt();
        Q = sc.nextInt();

        // 初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = (int) 1e9;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            d[a][b] = d[b][a] = 1;
        }

        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]); // 动态规划思想


        double ans = 0;
        for (int i = 0; i < Q; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            for (int j = 1; j <= n; j++) {
                if (d[x][j] <= y) {
                    ans ++;
                }
            }
        }

        System.out.printf("%.2f", ans / Q);
    }
}
