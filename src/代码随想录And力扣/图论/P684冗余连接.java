package 代码随想录And力扣.图论;


// 并查集（无向图）
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/redundant-connection/description/

public class P684冗余连接 {
    // 如果边的两个节点已经出现在同一个集合里(有同一个根)，说明着边的两个节点已经连在一起了，再加入这条边一定就出现环了。
    int[] father;

    public int[] findRedundantConnection(int[][] edges) {
        father = new int[1005]; // 节点数量3 到 1000
        init();

        for (int i = 0; i < edges.length; i++) {
            // 判断是否有同一个根，如果有同一个根就可以退出了，如果没有同一个根就合并
            if (isSame(edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }

        return null;
    }

    public void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    // 并查集里寻根的过程
    public int find(int u) {
        if (father[u] == u) {
            return u;
        } else {
            father[u] = find(father[u]);
            return father[u];
        }
    }

    // 将v->u 这条边加入并查集
    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;

        father[v] = u;
    }

    // 判断 u 和 v是否找到同一个根
    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return v == u;
    }


    // 官方题解：
//    public int[] findRedundantConnection(int[][] edges) {
//        int n = edges.length;
//        int[] parent = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            parent[i] = i;
//        }
//        for (int i = 0; i < n; i++) {
//            int[] edge = edges[i];
//            int node1 = edge[0], node2 = edge[1];
//            if (find(parent, node1) != find(parent, node2)) {
//                union(parent, node1, node2);
//            } else {
//                return edge;
//            }
//        }
//        return new int[0];
//    }
//
//    // 合并
//    public void union(int[] parent, int index1, int index2) {
//        parent[find(parent, index1)] = find(parent, index2);
//    }
//
//    // 查找
//    public int find(int[] parent, int index) {
//        if (parent[index] != index) {
//            parent[index] = find(parent, parent[index]);
//        }
//        return parent[index];
//    }


}
