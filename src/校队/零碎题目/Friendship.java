package 校队.零碎题目;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 并查集
// 牛客：https://ac.nowcoder.com/acm/contest/82508/A

class DisjointSet {
    // rank 深度
    private int[] parent, rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void unionSets(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // 如果 rootX 的深度大于 rootY 的深度，则将 rootY 的父节点设置为 rootX，表示将 y 所在的集合合并到 x 所在的集合中。
        // 如果 rootX 的深度小于 rootY 的深度，则将 rootX 的父节点设置为 rootY，表示将 x 所在的集合合并到 y 所在的集合中。
        // 如果 rootX 和 rootY 的深度相等，则任选一个根节点作为新的父节点，同时将该根节点的深度增加 1，表示两个集合合并后的深度增加了一层。
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

class Edge {
    int u, v, cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}

public class Friendship {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
        scanner.close();
    }

    public static void solve() {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            // 勇气值为 0，因为这些是已知的认识关系
            edges.add(new Edge(u, v, 0));
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int cost = scanner.nextInt();
            // 忽略男女之间的直接边
            if ((u <= a && v > a) || (u > a && v <= a)) {
                continue;
            }
            edges.add(new Edge(u, v, cost));
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        DisjointSet ds = new DisjointSet(a + b + 1); // 包括0索引，尽管它不会被使用
        int maxCost = 0;

        for (Edge edge : edges) {
            // 花费勇气值交朋友
            if (ds.find(edge.u) != ds.find(edge.v)) {
                ds.unionSets(edge.u, edge.v);
                maxCost = Math.max(maxCost, edge.cost);
            }
        }

        // 检查是否所有同学都在一个集合中
        int root = ds.find(1);
        for (int i = 2; i <= a + b; i++) {
            if (ds.find(i) != root) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(maxCost);
    }

}


