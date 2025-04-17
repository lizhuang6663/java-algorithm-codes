package 代码随想录And力扣.binary_tree;


// 二叉树前序，中序，后序遍历（二叉树的统一迭代遍历）
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/binary-tree-preorder-traversal/

// 将访问的节点放入栈中，把要处理的节点也放入栈中但是要做标记。（要处理的节点放入栈之后，紧接着放入一个空指针作为标记。）
// 我们将访问的节点直接加入到栈中，但如果是处理的节点则后面放入一个空节点， 这样只有空节点弹出的时候，才将下一个节点放进结果集。
public class TreeDemo4 {
    // 和中序遍历相比仅仅改变了两行代码的顺序


    static {

    }

    public static int a = 23;

    public static void main(String[] args) {

    }


}

