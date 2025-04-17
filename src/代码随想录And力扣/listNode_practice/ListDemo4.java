package 代码随想录And力扣.listNode_practice;

//链表4.反转链表
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//题意：反转一个单链表。
//示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL



//重要
public class ListDemo4 {
    //方法一：双指针
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;//保存下一个节点

            cur.next = pre;// 反转

            // 更新pre、cur位置
            pre = cur;//必须先移动pre，后移动cur
            cur = temp;
        }
        return pre;
    }



    //方法二：递归（原理和双指针相同）
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }
    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) return prev;//停止递归的条件（cur到达最后的null）

        ListNode temp = cur.next;//保存下一个节点
        cur.next = prev;// 反转

        return reverse(cur, temp);
    }



    //方法三：从后向前递归（没看懂）
    public ListNode reverseList3(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList3(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }


}
