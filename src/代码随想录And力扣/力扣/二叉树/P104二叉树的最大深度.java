package 代码随想录And力扣.力扣.二叉树;

// dfs 和 bfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/

import java.util.LinkedList;
import java.util.Queue;

public class P104二叉树的最大深度 {
    // 用深度优先遍历更容易理解，但是也可以用广度优先遍历，可以让面试官眼前一亮

    // 方法一：dfs 深度优先遍历
    // 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
    // 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }



    // 方法二：bfs 广度优先遍历
    // 我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
    // 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，
    // 即我们是一层一层地进行拓展，最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 ans。
    public int maxDepth2(TreeNode root) {
        if (root ==  null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 把本层的删除全部的元素（不删除下一层的元素）
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // 走完一层就++
            ans++;

        }
        return ans;
    }



}

