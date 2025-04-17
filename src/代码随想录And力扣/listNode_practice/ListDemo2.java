package 代码随想录And力扣.listNode_practice;

//链表2：移除链表元素
//在链表中，我们要删除一个节点，我们要先获取到这个节点的前一个节点，如果前面没有节点，我们就在前面设置一个虚拟节点。

public class ListDemo2 {

    //方法一：
    //虚拟节点
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                //这里必须用 pre.next，如果用cur的话，那么之后 pre.next != cur了，也就是说 pre.next 不能和 cur 连到一起了
                pre.next = cur.next;
            }else {
               pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }




    //方法二：
    //不添加虚拟节点，但有 pre 节点
    public ListNode removeElements2(ListNode head, int val) {
        //直到找到 head.val != val
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) return null;

        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }





    //方法三：
    //不添加虚拟节点 和 pre 节点
    public ListNode removeElements3(ListNode head, int val) {
        //先检查头部（从head 开始找到第一个不符合题目要求的值，并从这个值向下开始查）
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
