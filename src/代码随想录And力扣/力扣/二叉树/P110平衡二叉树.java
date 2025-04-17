package 代码随想录And力扣.力扣.二叉树;

// dfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/balanced-binary-tree/description/
// 平衡二叉树：空树；或者它的左右两个子树的高度差不超过1。

public class P110平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }


}
