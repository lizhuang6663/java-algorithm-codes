package 代码随想录And力扣.力扣.二叉树;

// dfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
// 说明：叶子节点是指没有子节点的节点。

import java.util.LinkedList;
import java.util.Queue;

public class P111二叉树的最小深度 {
    // 方法一：dfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = minDepth(root.left) + 1;
        int rightDepth = minDepth(root.right) + 1;

        // 这里之所以判断是为了特殊情况：
        // 注意：输出不是1，题目的要求不一样：最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
        // 输入：root = [2,null,3,null,4,null,5,null,6]
        // 输出：5
        if (leftDepth == 1 || rightDepth == 1) {
            return Math.max(leftDepth , rightDepth);
        }

        return Math.min(leftDepth, rightDepth);
    }

    // 或者
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, minDepth2(root.left));
        }

        if (root.right != null) {
            min = Math.min(min, minDepth2(root.right));
        }

        return min + 1;
    }



    // 方法二：bfs
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 遇到第一个叶子节点就返回。(左，右两边都没有子节点就返回)
                if (node.left == null && node.right == null) {
                    return min;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // 走完了一层，++
            min ++;
        }

        return min;
    }

}
