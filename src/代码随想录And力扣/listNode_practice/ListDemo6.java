package 代码随想录And力扣.listNode_practice;


//6.删除链表的倒数第N个节点
//删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class ListDemo6 {

    //双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        //只要快慢指针相差 n 个结点即可
        while (n-- > 0 && fastIndex.next != null) {
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }



    //和上一个方法原理相同，只不过方法二 fastIndex 走了n+1步，方法一判断的是 fastIndex.next，方法二判断的是 fastIndex
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fastIndex = dummy, slowIndex = dummy;

        //1.先让fastIndex 先走 n+1步
        n++;
        while (n-- > 0 && fastIndex != null) {
            fastIndex = fastIndex.next;
        }

        //2.再让fastIndex 和 slowIndex 同时走，直到fastIndex 走到了null
        //判断条件和方法一不同  fastIndex != null
        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //3.删除我们要删除的节点
        slowIndex.next = slowIndex.next.next;

        return dummy.next;
    }

}
