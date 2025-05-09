package 代码随想录And力扣.listNode_practice;

public class ListNode {
    // 结点的值
    int val;

    // 下一个结点
    public ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {}

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}