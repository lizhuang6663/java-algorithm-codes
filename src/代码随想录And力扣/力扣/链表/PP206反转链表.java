package 代码随想录And力扣.力扣.链表;

import 代码随想录And力扣.listNode_practice.ListNode;

// 链表，递归
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/reverse-linked-list/description/

public class PP206反转链表 {

    // 方法一：
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        ListNode temp = null;
//        while (cur != null) {
//            temp = cur.next;
//
//            cur.next = prev;
//            prev = cur;
//            cur = temp;
//        }
//
//        return prev;
//    }



    // 方法二：递归
    // 参考题解：https://mp.weixin.qq.com/s?__biz=MzkxODI3NDk5Nw==&mid=2247498339&idx=1&sn=d627fec62f98b6264218f20b7e2717de&source=41#wechat_redirect
    public ListNode reverseList(ListNode head) {
        return dfs(head);
    }

    // 相当于从后往前更改链表的顺序
    public ListNode dfs(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        // 递归反转 子链表
        ListNode newList = dfs(node.next);

        // 改变 1，2节点的指向。
        // 通过 node.next获取节点2
        ListNode t = node.next;
        // 让 1 的 next 指向 2
        t.next = node;
        // 2 的 next 指向 null.
        node.next = null;
        // 把调整之后的链表返回。
        return newList;
    }

}
