package 校队.Codeforces.Num4月26日_第十届山东省ACM省赛;

import 校队.Codeforces.Read2;

// 图论，签到题
// CodeForces:https://codeforces.com/gym/104459/problem/D

// 题目大意：
// 给出一个含n个点，m条边的连通图，将k个人按照输入分成两组，按顺序取边，当取走一条边后图不再连通，该队就输了，要求输出赢的队的编号。
// 分析：
// 题目看上去很长，像是一个复杂的图论，但其实算作一个签到题也不过分。。。对于n个点，
// 若要该图连通，则至少需要n-1条边。而题目所给出的图最初一定是连通的，那么我们可以说，当边数为n-1时，下一个拿边的队伍就是输掉比赛的队伍。

public class DGameOnAGraph {
    public static void main(String[] args)  {
        Read2 scanner = new Read2(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int k = scanner.nextInt();
            String order = scanner.next();
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            for (int j = 0; j < m; j++) {
                int a1 = scanner.nextInt();
                int a2 = scanner.nextInt();
            }

            int lastIndex = 0;
            if (m  > n - 1) { // 一条边也不能删
                lastIndex = (m - n + 1) % k; // 要取模，人会循环
            }

            if (order.charAt(lastIndex) == '1') { // 1组刚好选择了最后一个
                System.out.println(2);
            } else { // 2组刚好选择了最后一个
                System.out.println(1);
            }

        }
    }
}