package 代码随想录And力扣.图论;


// dfs，bfs，并查集
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/number-of-provinces/
// 计算省份总数，等价于计算图中的连通分量数

public class P547省份数量 {
    // 方法一：dfs
    // 遍历所有城市，对于每个城市，如果该城市尚未被访问过，则从该城市开始深度优先搜索，通过矩阵 isConnected 得到与该城市直接相连的城市有哪些，
    // 这些城市和该城市属于同一个连通分量，然后对这些城市继续深度优先搜索，直到同一个连通分量的所有城市都被访问到，即可得到一个省份。
    // 遍历完全部城市以后，即可得到连通分量的总数，即省份的总数。
//    boolean [] visited;
//    int result = 0;
//    public int findCircleNum(int[][] isConnected) {
//        visited = new boolean[isConnected.length];
//
//        for (int i = 0; i < isConnected.length; i++) {
//            if (!visited[i]) {
//                dfs(isConnected, i);
//                result++;
//            }
//        }
//        return result;
//    }
//
//    public void dfs(int[][] isConnected, int i) {
//        for (int j = 0; j < isConnected.length; j++) {
//            if (!visited[j] && isConnected[i][j] == 1) {
//                visited[j] = true;
//                dfs(isConnected,j);
//            }
//        }
//    }


    // 方法二：bfs
    // 对于每个城市，如果该城市尚未被访问过，则从该城市开始广度优先搜索，直到同一个连通分量中的所有城市都被访问到，即可得到一个省份。
//    public int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length;
//        boolean[] visited = new boolean[n];
//        int result = 0;
//        Queue<Integer> queue = new LinkedList<>();
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                queue.add(i);
//
//                while (!queue.isEmpty()) {
//                    int temp = queue.poll();
//                    visited[temp] = true;
//
//                    for (int j = 0; j < n; j++) {
//                        if (!visited[j] && isConnected[i][j] == 1) {
//                            queue.add(j);
//                        }
//                    }
//                }
//                result++;
//            }
//        }
//        return result;
//    }


    // 方法三：并查集
    // 初始时，每个城市都属于不同的连通分量。遍历矩阵 isConnected，如果两个城市之间有相连关系，则它们属于同一个连通分量，对它们进行合并。
//    int [] parent ;
//    public int findCircleNum(int[][] isConnected) {
//        parent = new int[isConnected.length];
//        init();
//
//        int result = 0;
//
//        for (int i = 0; i < isConnected.length; i++) {
//            for (int j = 0; j < isConnected.length; j++) {
//                // 合并
//                if (isConnected[i][j] == 1) {
//                    union(i, j);
//                }
//            }
//        }
//
//        // 计数
//        for (int i = 0; i < isConnected.length; i++) {
//            if (parent[i] == i) result ++;
//        }
//
//        return result;
//    }
//
//    // 初始化
//    public void init () {
//        for (int i = 0; i < parent.length; i++) {
//            parent[i] = i;
//        }
//    }
//
//    // 查找
//    public int find(int u) {
//        if (parent[u] != u) {
//            parent[u] = find(parent[u]); // 压缩路径
//        }
//
//        return parent[u];
//    }
//
//    // 合并:v->u
//    public void union(int u, int v) {
//        u = find(u);
//        v = find(v);
//
//        parent[v] = u;
//    }

}
