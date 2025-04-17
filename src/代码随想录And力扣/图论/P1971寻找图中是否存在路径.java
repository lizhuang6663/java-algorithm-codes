package 代码随想录And力扣.图论;


// 三种方法：dfs、bfs、并查集（要压缩路径，更快）
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/find-if-path-exists-in-graph/description/

public class P1971寻找图中是否存在路径 {

    // 方法一：bfs
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        List<Integer>[] arr = new List[n]; // 存数据
//        for (int i = 0; i < n; i++) {
//            arr[i] = new ArrayList<>();
//        }
//
//        for (int[] edge : edges) {
//            int k = edge[0];
//            int v = edge[1];
//            arr[k].add(v);
//            arr[v].add(k); // 是双向的
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[n];
//
//        queue.add(source);
//        visited[source] = true;
//
//        while (!queue.isEmpty()) {
//            int key = queue.poll();
//
//            for (int i = 0; i < arr[key].size(); i++) {
//                int val = arr[key].get(i);
//                if (!visited[val]) {
//                    visited[val] = true;
//                    queue.add(val);
//                }
//
//            }
//        }
//
//        // 判断 destination 是否走过
//        return visited[destination];
//    }


    // 方法二：dfs
//    boolean [] visited;
//    List<Integer> [] arr;
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        visited = new boolean[n];
//        arr= new List[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = new ArrayList<>(); // 初始化
//        }
//        // 赋值
//        for (int[] edge : edges) {
//            int k = edge[0];
//            int v = edge[1];
//            arr[k].add(v);
//            arr[v].add(k);
//        }
//
//        return dfs(edges, source, destination);
//    }
//
//    public boolean dfs(int[][] edges, int source, int destination) {
//        if (source == destination) return true;
//
//        visited[source] = true;
//        for (int temp : arr[source]) {
//            if (!visited[temp] && dfs(edges, temp, destination)) {
//                return true;
//            }
//        }
//        return false;
//    }


    // 方法三：并查集（重点）
    int[] father;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        father = new int[n];
        init();

        // 加入集合
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0], edges[i][1]);
            // 因为是双向图（无向图）所以可以改为 join(edges[i][1], edges[i][0]);
            // 如果是有向图就不可以改了
        }

        // 判断
        return isSame(source, destination);
    }


    // 并查集初始化
    public void init () {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    // 并查集里寻根的过程
    // 路径压缩后的并查集时间复杂度在O(logn)与O(1)之间，且随着查询或者合并操作的增加，时间复杂度会越来越趋于O(1)。了解到这个程度对于求职面试来说就够了。
    //在第一次查询的时候，相当于是n叉树上从叶子节点到根节点的查询过程，时间复杂度是logn，
    // 但路径压缩后，后面的查询操作都是O(1)，而 join 函数 和 isSame函数 里涉及的查询操作也是一样的过程。

    // 路径压缩
    public int find(int u) {
        if (father[u] == u) {
            return u;
        }else {
            father[u] = find(father[u]);
            return father[u];
        }
    }

    // 不压缩路径
    public int find2 (int u) {
        if (u == father[u]) return u;
        else return find2(father[u]);
    }

    // 压缩路径和不压缩路径两种方法的区别：不压缩路径：4->3->2->1，压缩路径：4->1


    // 判断 u 和 v是否找到同一个根
    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    // 将v->u 这条边加入并查集（一定要先 通过find函数寻根再进行关联。）
    public void join(int u, int v) {
        u = find(u); // 寻找u的根
        v = find(v); // 寻找v的根
        if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回

        father[v] = u;
    }

    // 举个例子：u=1, v=2, 1->3, 2->4；如果用join的方法，最后连接的结果是:1->3<-4<-2
    // 如果用join2的方法，最后连接的结果是：2->1

    // 错误的join方法：
    public void join2(int u, int v) {
        if (isSame(u,v)) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回
        father[v] = u;
    }

}
