package 代码随想录And力扣.listNode_practice;


//链表5:两两交换链表中的节点
//一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
public class ListDemo5 {

    //方法一：递归（没看懂）
    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }



    //方法二：含有虚拟头结点
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyhead = new ListNode(-1); // 设置一个虚拟头结点
        dummyhead.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode cur = dummyhead;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点

        //cur.next != null 和 cur.next.next != null的先后顺序不能写反了，因为如果cur.next 是空的，这时候我们取cur.next.next，我们取的是空指针的下一个，会报空指针异常
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            cur.next = secondnode;       // 步骤一
            secondnode.next = firstnode; // 步骤二
            firstnode.next = temp;      // 步骤三
            cur = firstnode; // cur移动，准备下一轮交换，firstnode的位置已经改变了，相当于cur.next.next，所以这句话等同于 cur = cur.next.next;
        }
        return dummyhead.next;
    }



    //跟着视频写的（和方法二是一样的，只不过省略了 ListNode secondnode）
    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;//cur 是每两个交换的节点的第一个节点的前一位
        ListNode temp1 = null, temp3 = null;

        while (cur.next != null && cur.next.next != null) {
            temp3 = cur.next.next.next;//保存节点3
            temp1 = cur.next;//保存节点1


            cur.next = cur.next.next;//改变cur 的后面是节点2
            cur.next.next = temp1;//让节点2 的后面是节点1
            temp1.next = temp3;//让节点1 的后面是节点3

            cur = cur.next.next;//将cur向后移动两位
        }

        return dummy.next;
    }
}
