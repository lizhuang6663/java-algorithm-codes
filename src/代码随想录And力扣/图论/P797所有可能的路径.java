package 代码随想录And力扣.图论;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// dfs（回溯）： 有向无环图（DAG）
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/all-paths-from-source-to-target/description/
// 有向图路径问题，最合适使用深搜，当然本题也可以使用广搜，但广搜相对来说就麻烦了一些，需要记录路径。

public class P797所有可能的路径 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 因为是从节点0开始的，所以要将节点0加入path中
        path.add(0);
        backTracking(graph, 0);

        return result;
    }

    // node：节点（node从0开始，代表第一个节点）
    public void backTracking(int[][] graph, int node) {
        if (node == graph.length - 1 ) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[node].length; i++) {
            path.add(graph[node][i]);

            // 注意这里传递的参数：graph[node][i]
            backTracking(graph, graph[node][i]);

            path.removeLast();
        }

    }


}
