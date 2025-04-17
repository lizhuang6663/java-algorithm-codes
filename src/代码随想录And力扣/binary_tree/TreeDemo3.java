package 代码随想录And力扣.binary_tree;


// 二叉树前序，中序，后序遍历（二叉树的迭代遍历，用栈迭代）
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/binary-tree-preorder-traversal/

/*

迭代遍历：使用栈
前序遍历是中左右，每次先处理的是中间节点，那么先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子。
为什么要先加入 右孩子，再加入左孩子呢？ 因为这样出栈的时候才是中左右的顺序。

 */

public class TreeDemo3 {

    /**
     * // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        // 一次拿出来一个
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop(); // 重要的一步
//            result.add(node.val);
//
//            // 使用栈来完成前序遍历，要先把right 放到栈中
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//        }
//        return result;
//    }





    // 中序遍历
    // 前序遍历的代码，不能和中序遍历通用，因为前序遍历的顺序是中左右，先访问的元素是中间节点，要处理的元素也是中间节点，
    // 所以刚刚才能写出相对简洁的代码，因为要访问的元素和要处理的元素顺序是一致的，都是中间节点。
    // 那么再看看中序遍历，中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，
    // 再开始处理节点（也就是在把节点的数值放进result数组中），这就造成了处理顺序和访问顺序是不一致的。
    // 原因总结：因为前序遍历中访问节点（遍历节点）和处理节点（将元素放进result数组中）可以同步处理，但是中序就无法做到同步！


    /**
     * 中序遍历顺序: 左-中-右 入栈顺序： 左-右
     * 在使用迭代法写中序遍历，就需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素
     * 一直向左走，直到为null，然后出栈（出栈的就是null的父节点了），然后向一直右走，如果为空，就再出栈，这时出栈的就是当前的父亲的父亲了
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null){
//            return result;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//
//        TreeNode cur = root;
//
//        while (cur != null || !stack.isEmpty()){
//            // 如果 cur 不为空，就入栈；并向左边走
//            if (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }else{
//                // 如果cur的 为空，（cur的父节点已经入栈了，而且在栈的最上面），就把cur的父节点出栈，然后向右边走（左边已经走过了），
//                // 如果下一次循环的cur == null 的话，这时候栈 pop 的就是当前的 cur 的父亲的父亲了，（当前的 cur 的父亲的父亲也是左节点）
//                cur = stack.pop();  // cur 就是一层一层往上爬
//                result.add(cur.val);
//                cur = cur.right;
//            }
//        }
//        return result;
//    }






    /**
     * 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            result.add(node.val);
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//        }
//        Collections.reverse(result);
//        return result;
//    }


}

