package 代码随想录And力扣.力扣.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// dfs 和 bfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/binary-tree-level-order-traversal/description/


public class P102二叉树的层序遍历 {

    // 方法一：bfs
    // 在广度优先遍历的过程中，把每一层的节点都添加到同一个数组中即可，问题的关键在于遍历同一层节点前，
    // 必须事先算出同一层的节点个数有多少(即队列已有元素个数)，因为 BFS 用的是队列来实现的，遍历过程中会不断把左右子节点入队
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // 最终的层序遍历结果
        List<List<Integer>> result = new ArrayList<>();

        // queue 提前存下本层的数据
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 记录每一层
            List<Integer> list = new ArrayList<>();
            int levelNum = queue.size(); // 当前队列中的元素有多少个

            // 遍历当前层的节点
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll(); // 弹出元素

                // 队首节点的左右子节点入队,由于 levelNum 是在入队前算的，所以入队的左右节点并不会在当前层被遍历到
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                list.add(node.val);
            }

            result.add(list);
        }

        return result;
    }


    // 方法二：dfs（用深度遍历来模拟广度遍历，需要加一个level，表示当前是第几层）
    // DFS 不是按照层次遍历的。为了让递归的过程中同一层的节点放到同一个列表中，在递归时要记录每个节点的深度 level。递归到新节点要把该节点放入 level 对应列表的末尾。
    // 当遍历到一个新的深度 level，而最终结果 res 中还没有创建 level 对应的列表时，应该在 res 中新建一个列表用来保存该 level 的所有节点。
    // (DFS 可以用递归来实现，只要在递归函数上加上一个「层」的变量即可，只要节点属于这一层，则把这个节点放入相当层的数组里。)
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, root, 0);

        return result;
    }

    public void dfs( List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        // 当遍历到一个新的深度 level，而最终结果 res 中还没有创建 level 对应的列表时，应该在 res 中新建一个列表用来保存该 level 的所有节点。
        // (没有这个深度的子list，所以需要创建一个)
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        // 在对应该层的小list中添加值
        result.get(level).add(node.val);

        if (node.left != null) dfs(result, node.left, level+1);
        if (node.right != null) dfs(result, node.right, level+1);
    }

}
