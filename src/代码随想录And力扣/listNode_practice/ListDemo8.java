package 代码随想录And力扣.listNode_practice;

//8.环形链表II
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//使用快慢指针法，分别定义 fast 和 slow 指针，从头结点出发，fast指针每次移动两个节点，
// slow指针每次移动一个节点，如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。

//为什么fast指针和slow指针一定会相遇呢？这是因为fast是走两步，slow是走一步，其实相对于slow来说，
// fast是一个节点一个节点的靠近slow的，所以fast一定可以和slow重合。

public class ListDemo8 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;

                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口(涉及到数学问题)
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                //退出循环的位置就是环的开头，涉及到数学问题
                return index1;
            }
        }
        return null;
    }

}
